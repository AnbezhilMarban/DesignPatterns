package com.avnet.asset.designPatterns.factoryPattern;

/**
 * 
 * @author anbezhil
 * 
 *         The Mango class which is a fruit (extends fruit class)
 *
 */
public class Mango extends Fruit
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
		return "This is Mango";
	}
}
