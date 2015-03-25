package com.avnet.asset.designPatterns.commandFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.avnet.asset.designPatterns.util.constants.MessageConstants;

/**
 *
 * @author anbezhil
 * 
 *         This class is used to create objects for the interfaces. This class
 *         should be used to instantiate objects.
 *
 */
public class CommandFactory
{
	/** The class name */
	private static final String CLASS_NAME = CommandFactory.class
			.getCanonicalName();

	/** The logger */
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

	/**
	 * This hashmap variable caches the interface and their implementation names
	 * from the command registry property file
	 */
	private static HashMap<String, String> commandRegistry = null;

	/** This variable stores the Command registry file path */
	private static final String CMDREG_PATH = "src/com/avnet/asset/designPatterns/commandFactory/CmdReg.properties";

	/** Message Constant */
	private static final String COMMANDREGISTRY_VAR = "commandRegistry";

	// the command registry hashmap is loaded
	static
	{
		commandRegistry = new HashMap<String, String>();
		Properties properties = new Properties();
		File cmdRegFile = new File(CMDREG_PATH);
		// checking whether the command registry file
		// has read permissions
		if (cmdRegFile.canRead())
		{
			try
			{
				// loading the command registry properties file
				// to the properties variable
				properties.load(new FileInputStream(cmdRegFile));
				// storing the interface names which are the keys
				// from the command registry file to the keys enumeration
				Enumeration keys = properties.keys();
				// iterating through the keys enum
				while (keys.hasMoreElements())
				{
					String key = (String) keys.nextElement();
					// storing the interface name as key and their
					// corresponding class implementation as values
					// in the command registry hashmap
					commandRegistry.put(key, properties.getProperty(key));
				}
			}
			catch (IOException ioException)
			{
				if (LOGGER.isLoggable(Level.SEVERE))
				{
					LOGGER.logp(
							Level.SEVERE,
							CLASS_NAME,
							null,
							MessageConstants.IOEXCEPTION_WHILE_LOADING_PROPERTIES
									.concat(CMDREG_PATH), ioException);
				}
			}
		}
		else
		{
			if (LOGGER.isLoggable(Level.SEVERE))
			{
				LOGGER.logp(Level.SEVERE, CLASS_NAME, null,
						MessageConstants.FILE_NOT_FOUND.concat(cmdRegFile
								.getName()), cmdRegFile.getAbsolutePath());
			}
		}
	}

	/**
	 * 
	 * This method returns an object of the implementation class for a given
	 * interface
	 * 
	 * @param interfaceName
	 *            the name of the interface
	 * @return Object object of the implementation class
	 */
	public static Object getCommand(String interfaceName)
	{
		String methodName = "getCommand";
		if (LOGGER.isLoggable(Level.FINER))
		{
			LOGGER.entering(CLASS_NAME, methodName, interfaceName);
		}
		Object commandObj = null;
		try
		{
			// getting the implementation object for this interface
			commandObj = getImplObjectForInterface(interfaceName);
		}
		catch (InstantiationException instantiationException)
		{
			if (LOGGER.isLoggable(Level.SEVERE))
			{
				LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName,
						MessageConstants.EXCEPTION_INSTANTIATING_CLASS
								.concat(commandRegistry.get(interfaceName)),
						instantiationException);
			}
		}
		catch (IllegalAccessException illegalAccessException)
		{
			if (LOGGER.isLoggable(Level.SEVERE))
			{
				LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName,
						MessageConstants.ILLEGAL_ACCESS_EXCEPTION
								.concat(commandRegistry.get(interfaceName)),
						illegalAccessException);
			}
		}
		catch (ClassNotFoundException classNotFoundException)
		{
			if (LOGGER.isLoggable(Level.SEVERE))
			{
				LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName,
						MessageConstants.CLASS_NOT_FOUND.concat(commandRegistry
								.get(interfaceName)), classNotFoundException);
			}
		}
		return commandObj;
	}

	/**
	 * This method returns the implementation object for the interface name
	 * passed as input
	 * 
	 * @param interfaceName
	 *            the name of the interface
	 * @return object the implementation object for the interface
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	protected static Object getImplObjectForInterface(String interfaceName)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException
	{
		String methodName = "getImplObjectForInterface";
		if (LOGGER.isLoggable(Level.FINER))
		{
			LOGGER.entering(CLASS_NAME, methodName, interfaceName);
		}
		Object ImplObj = null;
		// checking whether the command registry hash map is loaded
		if (commandRegistry != null)
		{
			// checking whether the interface is registered in the
			// command registry file
			if (commandRegistry.containsKey(interfaceName))
			{
				// an object created for the interface s implementation class
				ImplObj = Class.forName(
						(String) commandRegistry.get(interfaceName))
						.newInstance();
			}
			else
			{
				if (LOGGER.isLoggable(Level.SEVERE))
				{
					LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName,
							MessageConstants.INTERFACE_NOT_FOUND_IN_CMDREG);
				}
			}
		}
		else
		{
			if (LOGGER.isLoggable(Level.SEVERE))
			{
				LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName,
						MessageConstants.NULL_VALUE.concat(COMMANDREGISTRY_VAR));
			}
		}
		if (LOGGER.isLoggable(Level.FINER))
		{
			LOGGER.exiting(CLASS_NAME, methodName, ImplObj);
		}
		return ImplObj;
	}
}
