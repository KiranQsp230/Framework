package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ToReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {

		//To create obj of FIS
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		
		//To create obj of properties
		Properties prop = new Properties();
		
		//Call methods
		prop.load(fis);
		
		String url = prop.getProperty("url");
		System.out.println(url);
	}

}
