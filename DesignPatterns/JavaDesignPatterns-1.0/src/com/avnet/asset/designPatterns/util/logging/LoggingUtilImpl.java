package com.avnet.asset.designPatterns.util.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author anbezhil
 * 
 *         This class is a wrapper over the Java Logger class to enable checking
 *         whether it is loggable at the mentioned level , before the logging
 *         operation is called
 *
 */
public class LoggingUtilImpl implements LoggingUtil
{
	/** The logger object to log the messages */
	private static final Logger LOGGER = Logger.getAnonymousLogger();

	/**
	 * This method logs the method entry
	 * 
	 * @param className
	 *            the name of the class where the logging takes place
	 * @param methodName
	 *            the name of the method where the logging takes place
	 */
	@Override
	public void entering(String className, String methodName)
	{
		if (LOGGER.isLoggable(Level.FINER))
		{
			LOGGER.entering(className, methodName);
		}
	}

	/**
	 * This method logs the method entry along with a parameter
	 * 
	 * @param className
	 *            the name of the class where loggging takes place
	 * @param methodName
	 *            the name of the method where logging takes place
	 * @param param
	 *            the parameter to be logger while method entry
	 */
	@Override
	public void entering(String className, String methodName, Object param)
	{
		if (LOGGER.isLoggable(Level.FINER))
		{
			LOGGER.entering(className, methodName, param);
		}
	}

	/**
	 * This method logs the method entry along with a parameter
	 * 
	 * @param className
	 *            the name of the class where loggging takes place
	 * @param methodName
	 *            the name of the method where logging takes place
	 * @param param
	 *            the array of parameters to be logger while method entry
	 */
	@Override
	public void entering(String className, String methodName, Object[] params)
	{
		if (LOGGER.isLoggable(Level.FINER))
		{
			LOGGER.entering(className, methodName, params);
		}
	}

	/**
	 * This method logs the method exit
	 * 
	 * @param className
	 *            the name of the class where the logging takes place
	 * @param methodName
	 *            the name of the method where the logging takes place
	 */
	@Override
	public void exiting(String className, String methodName)
	{
		if (LOGGER.isLoggable(Level.FINER))
		{
			LOGGER.exiting(className, methodName);
		}
	}

	/**
	 * This method logs the method exit along with the result
	 * 
	 * @param className
	 *            the name of the class where the logging takes place
	 * @param methodName
	 *            the name of the method where the logging takes place
	 * @param result
	 *            the result to be logged on method exit
	 */
	@Override
	public void exiting(String className, String methodName, Object result)
	{
		if (LOGGER.isLoggable(Level.FINER))
		{
			LOGGER.exiting(className, methodName, result);
		}
	}

	/**
	 * This method logs the info messages
	 * 
	 * @param msg
	 *            the message to be logged
	 */
	@Override
	public void info(String msg)
	{
		if (LOGGER.isLoggable(Level.INFO))
		{
			LOGGER.info(msg);
		}
	}

	/**
	 * This method logs a message with the specified level
	 * 
	 * @param level
	 *            the logging level
	 * @param msg
	 *            the message to be logged
	 * 
	 */
	@Override
	public void log(Level level, String msg)
	{
		if (LOGGER.isLoggable(level))
		{
			LOGGER.log(level, msg);
		}
	}

	/**
	 * This method logs a message along with a variable when needed
	 * 
	 * @param level
	 *            the logging level
	 * @param msg
	 *            the message to be logged
	 * @param var
	 *            the variable to be logged with the message
	 */
	@Override
	public void log(Level level, String msg, Object var)
	{
		if (LOGGER.isLoggable(level))
		{
			LOGGER.log(level, msg, var);
		}
	}

	/**
	 * This method is used to log an exception along with a message
	 * 
	 * @param level
	 *            the logging level
	 * @param msg
	 *            the message to be logged
	 * @param exception
	 *            the throwable object to be logged
	 */
	@Override
	public void logException(Level level, String msg, Throwable exception)
	{
		if (LOGGER.isLoggable(level))
		{
			LOGGER.log(level, msg, exception);
		}
	}

	/**
	 * This method logs the message specifying the source class and source
	 * method
	 * 
	 * @param level
	 *            the logging level
	 * @param className
	 *            the source class where the logging takes place
	 * @param methodName
	 *            the source method where the logging takes place
	 * @param msg
	 *            the message to be logged
	 */
	@Override
	public void logp(Level level, String className, String methodName,
			String msg)
	{
		if (LOGGER.isLoggable(level))
		{
			LOGGER.logp(level, className, methodName, msg);
		}
	}

	/**
	 * This method logs the message specifying the source class and source
	 * method along with an argument
	 * 
	 * @param level
	 *            the logging level
	 * @param className
	 *            the source class where the logging takes place
	 * @param methodName
	 *            the source method where the logging takes place
	 * @param msg
	 *            the message to be logged
	 * @param var
	 *            the variable to be logged along with the message
	 */
	@Override
	public void logp(Level level, String className, String methodName,
			String msg, Object var)
	{
		if (LOGGER.isLoggable(level))
		{
			LOGGER.logp(level, className, methodName, msg, var);
		}
	}

	/**
	 * This method logs the exception specifying the source class and source
	 * method along with a message
	 * 
	 * @param level
	 *            the logging level
	 * @param className
	 *            the source class where the logging takes place
	 * @param methodName
	 *            the source method where the logging takes place
	 * @param msg
	 *            the message to be logged
	 * @param exception
	 *            the exception to be logged
	 */
	@Override
	public void logpException(Level level, String className, String methodName,
			String msg, Throwable exception)
	{
		if (LOGGER.isLoggable(level))
		{
			LOGGER.logp(level, className, methodName, msg, exception);
		}
	}
}
