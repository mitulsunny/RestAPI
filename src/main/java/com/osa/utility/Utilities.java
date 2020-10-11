package com.osa.utility;

import org.testng.Assert;

public class Utilities {

	public static void verifyString(String expectedV, String actualV) {
		if(expectedV.equals(actualV)) {
			System.out.println("The test is passed");
	
		}else {
			System.out.println("The test is Failed");
			System.out.println("Expected value is : "+ expectedV);
			System.out.println("Actual value is : "+ actualV);
			Assert.assertEquals(actualV, expectedV);
		}
	}
}
