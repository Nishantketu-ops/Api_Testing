package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectConfigurations {
	
	
  @SuppressWarnings("finally")
public static String LoadProperties(String key) {

	Properties prop = new Properties();
	InputStream input = null;
	
	String Value=null;

	try {

		input = new FileInputStream(System.getProperty("user.dir")+"/Configuration/config.properties");

		// load a properties file
		prop.load(input);
		
		
		Value=prop.getProperty(key);
		
	} catch (IOException ex) {
		ex.printStackTrace();
	} finally {
		if (input != null) {
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
return 	Value;
		
	}

  }
  public static String LoadPropertiesUFT(String key) {

		Properties prop = new Properties();
		InputStream input = null;
		
		String Value=null;

		try {

			input = new FileInputStream(System.getProperty("user.dir")+"/Configuration/configUFT.properties");

			// load a properties file
			prop.load(input);
			
			
			Value=prop.getProperty(key);
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
	return 	Value;
			
		}

	  }
}