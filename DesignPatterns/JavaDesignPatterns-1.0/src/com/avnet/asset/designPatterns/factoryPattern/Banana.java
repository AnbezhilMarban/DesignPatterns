package com.avnet.asset.designPatterns.factoryPattern;

/**
 * 
 * @author anbezhil
 * 
 *         The Banana class which is a Fruit
 *
 */
public class Banana extends Fruit
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
		return "This is Banana";
	}
}
