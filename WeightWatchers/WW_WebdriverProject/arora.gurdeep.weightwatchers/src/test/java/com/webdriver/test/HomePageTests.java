package com.webdriver.test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.webdriver.base.BasePage;
import com.webdriver.pages.HomePage;

public class HomePageTests {
	HomePage homePage= new HomePage();
	
	
	@BeforeSuite
	public void setup() {
		homePage.selectDriver();
	}
	
		
	@Test (priority=1)
	public void verifyHomePageTitle() {
		System.out.println();
		String expectedTitle = "Weight Loss Program, Recipes & Help | Weight Watchers";	
		String actualTitle= homePage.getTitle();
		homePage.verifyTitle(actualTitle, expectedTitle);
	}
	
	@Test (priority=2)
	public void verifyFindMeetingTitle() throws Exception {
		System.out.println();
		homePage.click_findMeetingLink() ;
		String expectedTitle = "Find A Meeting: Get Schedules & Times Near You | Weight Watchers";	
		String actualTitle= homePage.getTitle();
		homePage.verifyTitle(actualTitle, expectedTitle);
	}	
	
	@AfterSuite
	public void tearDown() {
		BasePage.driver.quit();
	}
	
}
