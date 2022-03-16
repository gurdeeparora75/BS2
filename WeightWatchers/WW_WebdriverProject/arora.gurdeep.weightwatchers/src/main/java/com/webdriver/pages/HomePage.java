package com.webdriver.pages;



import org.testng.Assert;

import com.webdriver.base.BasePage;

public class HomePage extends BasePage{
	

	public String getTitle() {
		return driver.getTitle();
	}
	
	public void verifyTitle(String actualTitle, String expectedTitle ) {
		System.out.println("Expected Title =>"+expectedTitle);
		System.out.println("Actual Title =>"+actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title is correct !!!");	
	}
	
	public void click_findMeetingLink() throws Exception {
		click("xpath", utilObj.readPropertiesFile(OR, "LINK_FINDMEETING"));
		waitForLoad();
	}
	
		
			
}
	

