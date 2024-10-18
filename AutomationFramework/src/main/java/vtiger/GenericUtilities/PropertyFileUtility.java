package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This class contains generic method related to property file
 * @author kiran
 *
 */
public class PropertyFileUtility {
     /**
      * This method will read the data from property file if we pass key
      * @param key
      * @return
      * @throws Exception
      */
	public String toReadDataFromProperty(String key) throws Exception {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
}