package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	static Properties pro;
	String propertiesFileLocation = System.getProperty("user.dir")+"\\data.properties";

	//Fetch data from properties file
	public ReadConfig() {

		try {
			pro = new Properties();
			FileInputStream fp = new FileInputStream(propertiesFileLocation);
			pro.load(fp);
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Exception is - "+e.getMessage());
		}
	}
	
	public String getBaseUrl() {
		
		String url = pro.getProperty("BaseUrl");
		return url;
	}
	
	public String getDrEmailId() {
		
		String email = pro.getProperty("Dr_Email");
		return email;
	}
	
	public String getDrPassword() {
		
		String password = pro.getProperty("Dr_Password");
		return password;
	}
	
	public String verifyReg() {
		
		String verifyReg = pro.getProperty("expectedRegText");
		return verifyReg;
	}
	
	public String validateEmail() {
		
		String validateEmail = pro.getProperty("emailVal");
		return validateEmail;
	}
	
	public String search() {
		
		String textSearch = pro.getProperty("searchText");
		return textSearch;
		
		
	}
	

}
