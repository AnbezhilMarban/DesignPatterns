package com.avnet.asset.designPatterns.factoryPattern;

import java.io.File;
import java.util.logging.Level;

import com.avnet.asset.designPatterns.commandFactory.CommandFactory;
import com.avnet.asset.designPatterns.util.constants.MessageConstants;
import com.avnet.asset.designPatterns.util.fileUtil.PropertyFileUtil;
import com.avnet.asset.designPatterns.util.logging.LoggingUtil;

/**
 * 
 * @author anbezhil
 * 
 *         This class produces the instances of the fruit objects needed. This
 *         class follows factory pattern and returns the fruit objects based on
 *         the fruit name given to it by the client
 *
 */
public class FruitFactory
{
	/** the name of the class */
	private static final String CLASS_NAME = FruitFactory.class
			.getCanonicalName();

	/** The logger to log messages */
	private static final LoggingUtil LOGGER = (LoggingUtil) CommandFactory
			.getCommand(CLASS_NAME);

	/** the property util variable to work with property files */
	private static PropertyFileUtil propertyUtil = (PropertyFileUtil) CommandFactory
			.getCommand(PropertyFileUtil.class.getCanonicalName());

	/** constant String */
	private static final String FRUIT_NAME = "fruitName";

	/** constant String for fruitsProperty file name */
	private static final String FRUITS_PROPERTY_FILE_NAME = " fruits.properties ";

	private static final String FRUITS_FILE_PATH = "src/com/avnet/asset/designPatterns/factoryPattern/fruits.properties";

	/**
	 * This method creates and returns the fruit objects based on the fruitname
	 * passed as input to this method
	 * 
	 * @return Fruit fruit objects based on fruitname passed to this method
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static Fruit getFruit(String fruitName)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException
	{
		String methodName = "getFruit";
		LOGGER.entering(CLASS_NAME, methodName, fruitName);
		Fruit fruit = null;
		if (fruitName != null)
		{
			// creating a file object for the fruits property file
			File fruitsfile = new File(FRUITS_FILE_PATH);
			// checking whether the fruits property file has read permission
			if (fruitsfile.canRead())
			{
				// retrieving the fruit class name based on the key from
				// property file
				String fruitClassName = propertyUtil.getProperty(fruitName,
						fruitsfile);
				try
				{
					// creating a new instance of the fruit class name retrieved
					// from the
					// property file and storing it in fruits variable
					fruit = (Fruit) Class.forName(fruitClassName).newInstance();
				}
				catch (InstantiationException e)
				{
					LOGGER.logpException(Level.SEVERE, CLASS_NAME, methodName,
							MessageConstants.INSTANTIATION_EXCEPTION, e);
					throw e;
				}
				catch (IllegalAccessException e)
				{
					LOGGER.logpException(Level.SEVERE, CLASS_NAME, methodName,
							MessageConstants.ILLEGAL_ACCESS_EXCEPTION, e);
					throw e;
				}
				catch (ClassNotFoundException e)
				{
					LOGGER.logpException(Level.SEVERE, CLASS_NAME, methodName,
							MessageConstants.CLASS_NOT_FOUND_EXCEPTION, e);
					throw e;
				}
			}
			else
			{
				LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName,
						MessageConstants.FILE_DOES_NOT_HAVE_READ_PERMISSION
								.concat(FRUITS_PROPERTY_FILE_NAME));

			}
		}
		else
		{
			LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName,
					MessageConstants.NULL_VALUE.concat(FRUIT_NAME));
			throw new NullPointerException(
					MessageConstants.NULL_VALUE.concat(FRUIT_NAME));
		}
		LOGGER.exiting(CLASS_NAME, methodName, fruit);
		return fruit;
	}
}
