package com.avnet.asset.designPatterns.factoryPattern;

/**
 * 
 * @author anbezhil
 * 
 *         The Apple class which is a fruit (extends Fruit class)
 *
 */
public class Apple extends Fruit
{
	/**
	 * Overriding the toString method of Object class
	 * 
	 * @return String the string to be returned when toString is called on this
	 *         object
	 */
	@Override
	public String toString()
	{
		return "This is Apple";
	}
}
