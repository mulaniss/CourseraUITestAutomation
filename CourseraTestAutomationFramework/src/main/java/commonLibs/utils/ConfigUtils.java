package commonLibs.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

	public static Properties readProperties(String filename) throws Exception {
		filename = filename.trim();

		InputStream filereader = new FileInputStream(filename);

		Properties property = new Properties();
		property.load(filereader);

		return property;

	}

}
