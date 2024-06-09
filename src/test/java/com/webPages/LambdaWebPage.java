package com.webPages;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basemethods.BaseClass;

public class LambdaWebPage extends BaseClass

{
	private By seeAllIntegrationLink = By.xpath("//a[normalize-space()='See All Integrations']");
	private By githubimg             = By.xpath("//img[@title='GitHub']");
	private By testwhiz      = By.xpath("//h3[normalize-space()='Testing Whiz']");
    private By learnMoreButton  = By.xpath(".//*[text()='Integrate Testing Whiz with LambdaTest']");
    private By communityLink    = By.linkText("Community");
	
	


	
	

	public void clickSeeAllLink() 
	{
		sleep();
		scrollIntoView(githubimg);
		//clickTheElement(seeAllIntegrationLink);
		//openNewWindow(seeAllIntegrationLink);
		openNewTab(seeAllIntegrationLink);
		switchToTab(1);
		scrollIntoView(testwhiz);
		clickTheElement(learnMoreButton);
	  String actual =	getTitle();
	  System.out.println(actual);
	  String expected = "‘TestingWhiz Integration | LambdaTest’.";
	  SoftAssert soft = new SoftAssert();
	  soft.assertEquals(actual, expected);
	  
	if (actual.equals(expected)) 
	{
		System.out.println("Titles same");
	}
	else
	{
		System.out.println("Title are not same");
	}
	  closepresentbrowser();
	  
	  navigateURL("https://www.lambdatest.com/blog/");
	  
	  clickTheElement(communityLink);
	  
	  String expectedurl = "https://community.lambdatest.com/.";
	  
	  String actualURL = gettextURL();
	  SoftAssert soft2 = new SoftAssert();
	  soft2.assertEquals(actualURL, expectedurl);
	  
	  if (actualURL.equals(expectedurl)) 
		{
			System.out.println("URL are same");
		}
		else
		{
			System.out.println("URL are not same");
		}
	  
	  
	}
	
	
	

}
