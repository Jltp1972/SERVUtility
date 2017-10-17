package programExecution;

import java.sql.Connection;
import connections.createConnection;
import forSQL.createSQL;

public class sqlDriver {
	
	// Change library as needed
	static String lib = "JPARKER";
	// Change filename as needed
	static String filename = "ECCEMAILPF";
	// **IMPORTANT** db.properties file (in src folder) must be updated with your credentials
	static String propfile = "src//db.properties";
	// Enter all fields you want displayed for the results
	static String[] displayfields = new String[] {"ACCTNBR", "ORDERNBR", "RECSTATUS", "BLASTCNT"};
	static String print = "d"; //  Use "d" to display, any other value will not display
	
	// Type SQL query below in the area surrounded by double quotes
	static String query = "Select * from ECCEMAILPF where CLIENTABBR = 'BH6'";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = createConnection.newConnection(lib, filename, propfile);
		createSQL.writeSQL(query, conn, displayfields, print);
	}

}
