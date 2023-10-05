//.properties files are mainly used in Java programs to maintain project configuration data, database config or project settings, etc.The main advantage of properties is that they are outside your source code and you can change them anytime.

package com.suadeo.WEB.Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.suadeo.WEB.Tests.BaseClass;
import com.suadeo.WEB.Tests.Test_Catalogs;
import com.suadeo.WEB.Tests.Test_Menu;
import com.suadeo.WEB.Tests.Test_SignInPage;
import com.suadeo.WEB.Tests.Test_Models;

public class PropertiesFile {
	
	static Properties prop = new Properties(); //object of Properties class,This class is available in java
	static String projectPath = System.getProperty("user.dir");//To get the location of Config.properties file

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getProperties();
		setProperties();
		getProperties();

	}
	public static void getProperties()

	{
		try {

			
			InputStream input = new FileInputStream(projectPath+"/src/test/java/com/suadeo/WEB/Config/config.properties"); //Create object of FileInputStream and give property file location as fileInputStream parameter
			//InputStream inputt = new FileInputStream("C:\\Users\\Dell\\Downloads\\Exe\\Automation workspace\\MagrabiAutomation\\src\\test\\java\\com\\magrabi\\WEB\\Config\\config.properties");
			prop.load(input); // load a properties file
			String browser = prop.getProperty("browser"); // we need to read the properties of config file. Properties object gives us a .getProperty method which takes the key of the property as a parameter and return the value of the matched key from the .properties file.
			System.out.println(browser); 
			String url = prop.getProperty("url");
			System.out.println(url); 
			Test_SignInPage.browserName=browser;
			Test_Menu.browserName=browser;
			Test_Catalogs.browserName=browser;
			BaseClass.browserName=browser;
			BaseClass.url=url;
			
//			Test_Models.browserName=browser;
//			Test_Models.url=url;

			
			
	
			
			
		}
		catch(Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}
    public static void setProperties()
    {
    	try {
    		
    	OutputStream output = new FileOutputStream(projectPath+"/src/test/java/com/suadeo/WEB/Config/config.properties");
    	prop.setProperty("result", "Pass");
    	prop.store(output, null); // save a properties file

    	}
    	catch(Exception exp)
    	{
    		System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
    		
    	}
    	
    }


}
