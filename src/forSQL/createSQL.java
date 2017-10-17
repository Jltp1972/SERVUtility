package forSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class createSQL {
	
	public static void writeSQL(String sql, Connection conn, String[] displayFields, String result) {
		ResultSet rs = runSQL.executeSQL(sql, conn);
		if (result == "d") {
			int nbrFields = displayFields.length;			
			  try {
				while(rs.next())
				  try {
					for (int a=0; a < nbrFields; ) {
						System.out.print(displayFields[a] + ":" + rs.getString(displayFields[a]) + "  ");
						a++;
					} System.out.println();
				  }catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}			
		}
	}
}

