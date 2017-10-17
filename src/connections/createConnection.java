package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class createConnection {

	 static Properties properties; 
   
     
     static Connection conn =  null; 
   
   public static Connection newConnection(String lib, String filename, String propfile) {
	   
	properties = newProperties.setProperties(lib, filename, propfile);
     // Register driver.
    try {

       Class.forName("com.ibm.as400.access.AS400JDBCDriver");
    	  } catch (ClassNotFoundException cnf) {
       System.out.println("ERROR: The JDBC driver did not load.");
       System.exit(0);
    }
	
  	  try {
		conn = DriverManager.getConnection("jdbc:as400://SERV", properties);
		  
  	  
        if (conn instanceof com.ibm.as400.access.AS400JDBCConnection) {
          System.out.println("Connection is up and running under the IBM Toolbox for Java JDBC driver.");       
        }
        else {
          System.out.println("There is something wrong with connection.");
        }
      } 
  	  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }  

   return conn;
   }
}
