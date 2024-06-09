package com.TestMethods;




import basemethods.BaseClass;

import org.testng.annotations.*;


import com.webPages.LambdaWebPage;

public class SeleniumAdvanceTest  extends BaseClass
{
	LambdaWebPage webpage = new LambdaWebPage();
	

    @Test
	public void Testmethod()
	{
	  //init("chrome");
	 geturl("https://www.lambdatest.com/");
	 waitForAllElementsToBeAvailable();
	 webpage.clickSeeAllLink();
	 
	 
	 
		
	}
}
