package com.sample.api.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigUtils {

	private static ConfigUtils configUtil;
	private static Properties prop;


	private ConfigUtils() throws IOException
	{
		//System.out.println(System. getProperty("user. dir") );
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
        System.out.println(currentWorkingDir.normalize().toString());
		prop= loadProperties(currentWorkingDir.normalize().toString());
		
	}
	
	public Properties loadProperties(String path) throws IOException
	{
		FileInputStream fis = null;
	      
	      try {
	    	  
	         fis = new FileInputStream(path+"/resource/config.properties");
	         prop = new Properties();
	         prop.load(fis);
	      } catch(FileNotFoundException fnfe) {
	         fnfe.printStackTrace();
	      } catch(IOException ioe) {
	         ioe.printStackTrace();
	      } finally {
	         fis.close();
	      }
	      return prop;
	}

	public static ConfigUtils getConfigInstance()
	{
		try {
			if(configUtil==null)
				configUtil = new ConfigUtils();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return configUtil;

	}
	
	
	public String getKeyValueOf(String key)
	{
		return prop.getProperty(key);
	}


}
