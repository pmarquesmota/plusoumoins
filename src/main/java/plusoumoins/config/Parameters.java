package plusoumoins.config;

import plusoumoins.exception.FichierConfigurationException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

public class Parameters {
	private static HashMap<String, String> mymap;

	/**
	 * getListeParametres
	 * 
	 * @return mymap
	 * @throws IOException
	 */
	public static synchronized HashMap<String, String> getListeParametres() throws IOException, FichierConfigurationException {

		if (null == mymap) {
		    final InputStream inputStream = new FileInputStream("config.properties");
			final Properties properties = new Properties();

			properties.load(inputStream);
			inputStream.close();

			mymap = new HashMap<String, String>();

			for (Entry<Object, Object> entry : properties.entrySet()) {
				mymap.put((String) entry.getKey(), (String) entry.getValue());
			}
			if(null == mymap.get("dev") || null == mymap.get("length") ) {
				throw new FichierConfigurationException();
			}
		}
		return mymap;
	}
}
