package com.avnet.asset.designPatterns.util.logging;

import java.util.logging.Level;

/**
 * 
 * @author anbezhil
 *
 *         This interface exposes the utility methods required for logging
 */
public interface LoggingUtil
{

	/**
	 * This method logs the method entry
	 * 
	 * @param className
	 *            the name of the class where the logging takes place
	 * @param methodName
	 *            the name of the method where the logging takes place
	 */
	void entering(String className, String methodName);

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
	void entering(String className, String methodName, Object param);

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
	void entering(String className, String methodName, Object[] params);

	/**
	 * This method logs the method exit
	 * 
	 * @param className
	 *            the name of the class where the logging takes place
	 * @param methodName
	 *            the name of the method where the logging takes place
	 */
	void exiting(String className, String methodName);

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
	void exiting(String className, String methodName, Object result);

	/**
	 * This method logs the info messages
	 * 
	 * @param msg
	 *            the message to be logged
	 */
	void info(String msg);

	/**
	 * This method logs a message with the specified level
	 * 
	 * @param level
	 *            the logging level
	 * @param msg
	 *            the message to be logged
	 * 
	 */
	void log(Level level, String msg);

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
	void log(Level level, String msg, Object var);

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
	void logException(Level level, String msg, Throwable exception);

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
	void logp(Level level, String className, String methodName, String msg);

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
	void logp(Level level, String className, String methodName, String msg,
			Object var);

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
	void logpException(Level level, String className, String methodName,
			String msg, Throwable exception);

}
