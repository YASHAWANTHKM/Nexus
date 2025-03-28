package FileUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtilityclass {
	    public String getDataFromPropertiesFile(String key) throws Throwable {
	        FileInputStream fis = new FileInputStream("./src/main/resources/ConfigurationData/CommonData.properties");
	        Properties pobj = new Properties();
	        pobj.load(fis);
	        String data = pobj.getProperty(key);
	        return data;
	    }
	}



