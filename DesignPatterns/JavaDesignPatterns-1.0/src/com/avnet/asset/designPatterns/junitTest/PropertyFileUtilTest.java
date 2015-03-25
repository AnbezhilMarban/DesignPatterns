package com.avnet.asset.designPatterns.junitTest;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.junit.Test;

public class PropertyFileUtilTest
{
	String filePath = "src/com/avnet/asset/designPatterns/junitTest/TestPropertis.properties";
	File propertyFile = new File(filePath);

	@Test
	public void testFilePath()
	{
		assertEquals(propertyFile.exists(), true);
	}

	@Test
	public void testValidGetProperty()
	{
		// System.out.println("a: " +
		// PropertyFileUtil.getProperty("j",propertyFile));
		// assertEquals(PropertyFileUtil.getProperty("a",propertyFile),"1");

	}
}
