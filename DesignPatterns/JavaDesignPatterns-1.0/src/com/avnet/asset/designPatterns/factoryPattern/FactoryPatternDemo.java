package com.avnet.asset.designPatterns.factoryPattern;

import java.util.logging.Level;

import com.avnet.asset.designPatterns.commandFactory.CommandFactory;
import com.avnet.asset.designPatterns.util.logging.LoggingUtil;

public class FactoryPatternDemo
{

	public static void main(String[] args)
	{
		LoggingUtil LOGGER = (LoggingUtil) CommandFactory
				.getCommand("com.avnet.asset.designPatterns.util.logging.LoggingUtil");
		LOGGER.log(Level.INFO, "command factory working !!!");
	}

}
