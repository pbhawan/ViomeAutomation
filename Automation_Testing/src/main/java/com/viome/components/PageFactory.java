package com.viome.components;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageFactory extends PageBase {
	FileInputStream fs;
	Properties Prop = new Properties();
	public PageFactory(WebDriver driver)

	{
		super(driver);

		try {
			fs = new FileInputStream("./src/test/resources/application.properties");
			Prop.load(fs);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			if (fs != null) {
				try {
					fs.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	
	protected WebDriver driver;

	public Properties getURLPropertiesValue() throws IOException

	{
			
		return Prop;
		
	}

	}

	/*
	 * // //// public Properties getDriverPropertiesValue() throws IOException {
	 * //// fs = new FileInputStream( ////
	 * "./src/test/resources/enviorments/ApplicationDriver.properties"); ////
	 * Prop.load(fs); //// return (Prop); // //// }
	 */

