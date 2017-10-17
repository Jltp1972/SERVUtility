package connections;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class newProperties {
	protected static Properties dbProperties = new java.util.Properties(); 
	
	 public static Properties setProperties(String lib, String filename, String propfile) {
		 if (propfile == null) {
			 propfile = "db.properties";
		 }
		 
		 	try {
			dbProperties.load(new FileInputStream(propfile));
		 	} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 	} catch (IOException e) {
			System.out.println("jenn.properties not found");
			// TODO Auto-generated catch block
			e.printStackTrace();
		 	}
		 
		 System.setProperty("Jdbc.drivers", "com.ibm.as400.access.AS400JDBCDriver");  
  	//		Properties properties = new java.util.Properties(); 
  			dbProperties.put("user", getUser());
  			dbProperties.put("password", getPW());
  			dbProperties.put("language", "Java");
  			dbProperties.put("cursor hold", "false");
  		 if (lib == "") {	
  			dbProperties.put("libraries", "PRODUCTION");}
  		 else {
  			 setLib(lib);
  		 }
  		 
  	  return dbProperties;
	}
		
	public static String getUser() {
		 	return dbProperties.getProperty("database.user");
	}
		
	public static String getPW() {
			return dbProperties.getProperty("database.password");
	}
		
	public Object setFile(String filename) {
			return dbProperties.setProperty("file", filename);
	}
		
	public static Object setLib(String lib) {
			return dbProperties.setProperty("libraries", lib);
	}
}
