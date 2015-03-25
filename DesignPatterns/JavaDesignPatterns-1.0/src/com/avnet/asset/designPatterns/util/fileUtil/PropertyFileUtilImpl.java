package com.avnet.asset.designPatterns.util.fileUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.Level;

import com.avnet.asset.designPatterns.commandFactory.CommandFactory;
import com.avnet.asset.designPatterns.util.constants.MessageConstants;
import com.avnet.asset.designPatterns.util.logging.LoggingUtil;

/**
 * 
 * @author anbezhil
 * 
 *         This is an Util class which provides methods for reading and writing
 *         property files
 * 
 */
public class PropertyFileUtilImpl implements PropertyFileUtil
{
	/** The name for this class */
	private static final String CLASS_NAME = PropertyFileUtilImpl.class
			.getCanonicalName();

	/** the logger variable to perform logging */
	private static LoggingUtil logger = (LoggingUtil) CommandFactory
			.getCommand(LoggingUtil.class.getCanonicalName());

	/**
	 * 
	 * This method is used to read a property from a property file
	 * 
	 * @param key
	 *            This is the key for which value will be fetched from the
	 *            property file
	 * @param propertyFile
	 *            The property file from which the property has to be read
	 * @return String Returns the value for the Key in the property file
	 */
	public String getProperty(String key, File propertyFile)
	{
		String methodName = "getProperty";
		logger.entering(CLASS_NAME, methodName);
		Properties properties = new Properties();
		// the property value to be returned for the given key
		String propertyValue = null;
		// checking whether the property file exists and has read
		// permissions
		if (propertyFile.canRead())
		{
			try
			{
				properties.load(new FileInputStream(propertyFile));
				// the property value for the key in the
				// property file
				propertyValue = properties.getProperty(key);
			}
			catch (IOException ioException)
			{
				logger.logpException(Level.SEVERE, CLASS_NAME, methodName,
						MessageConstants.IOEXCEPTION_WHILE_LOADING_PROPERTIES,
						ioException);
			}
		}
		else
		{
			logger.logp(
					Level.SEVERE,
					CLASS_NAME,
					methodName,
					MessageConstants.FILE_NOT_FOUND_OR_DOES_NOT_HAVE_READ_PERMISSION);
		}
		logger.exiting(CLASS_NAME, methodName);
		return propertyValue;
	}

	/**
	 * This method is used to add a new property to the property file specified.
	 * 
	 * @param key
	 *            the key to be added in the property file
	 * @param value
	 *            the value to be added for the key in the property file
	 * @param propertyFile
	 *            the property file to which the key value pair has to be added
	 * 
	 */
	public boolean putProperty(String key, String value, File propertyFile)
	{
		String methodName = "setProperty";
		logger.entering(CLASS_NAME, methodName);
		Properties properties = new Properties();
		// checking whether the property file exists
		// and has write permission
		if (propertyFile.canWrite())
		{
			try
			{
				// loading the properties file to the
				// properties variable
				properties.load(new FileInputStream(propertyFile));
				// adding a new property to this
				// properties variable
				properties.put(key, value);
				// storing the new property to the
				// property file
				properties.store(new FileOutputStream(propertyFile), null);
				logger.exiting(CLASS_NAME, methodName);
				return true;
			}
			catch (IOException ioException)
			{
				logger.logpException(Level.SEVERE, CLASS_NAME, methodName,
						MessageConstants.IOEXCEPTION_WHILE_LOADING_PROPERTIES,
						ioException);
			}

		}
		else
		{
			logger.logp(
					Level.SEVERE,
					CLASS_NAME,
					methodName,
					MessageConstants.FILE_NOT_FOUND_OR_DOES_NOT_HAVE_WRITE_PERMISSION);
		}
		logger.exiting(CLASS_NAME, methodName);
		return false;
	}

	/**
	 * This method is used to get all the keys in the property file passed to
	 * this method
	 * 
	 * @param propertyFile
	 *            the file from which the keys have to be fetched
	 * @return Enumeration an enumeration of the keys in the property file
	 */
	public Enumeration<Object> getKeys(File propertyFile)
	{
		String methodName = "getPropertyNames";
		logger.entering(CLASS_NAME, methodName);
		Properties properties = new Properties();
		// the keys variable to store the keys from
		// the properties file
		Enumeration<Object> keys = null;
		// checking whether the property file
		// has read permission
		if (propertyFile.canRead())
		{
			try
			{
				properties.load(new FileInputStream(propertyFile));
				// getting the keys from the property file
				// and storing it in the keys enumeration
				keys = properties.keys();
			}
			catch (IOException ioException)
			{
				logger.logpException(Level.SEVERE, CLASS_NAME, methodName,
						MessageConstants.IOEXCEPTION_WHILE_LOADING_PROPERTIES,
						ioException);
			}
		}
		else
		{
			logger.logp(
					Level.SEVERE,
					CLASS_NAME,
					methodName,
					MessageConstants.FILE_NOT_FOUND_OR_DOES_NOT_HAVE_READ_PERMISSION);
		}
		logger.exiting(CLASS_NAME, methodName);
		return keys;
	}
}
