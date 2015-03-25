package com.avnet.asset.designPatterns.util.fileUtil;

import java.io.File;
import java.util.Enumeration;

public interface PropertyFileUtil
{
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
	public String getProperty(String key, File propertyFile);

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
	public boolean putProperty(String key, String value, File propertyFile);

	/**
	 * This method is used to get all the keys in the property file passed to
	 * this method
	 * 
	 * @param propertyFile
	 *            the file from which the keys have to be fetched
	 * @return Enumeration an enumeration of the keys in the property file
	 */
	public Enumeration<Object> getKeys(File propertyFile);
}
