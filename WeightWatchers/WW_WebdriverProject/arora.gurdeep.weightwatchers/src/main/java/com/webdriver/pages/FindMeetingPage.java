package com.webdriver.pages;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.webdriver.base.BasePage;


public class FindMeetingPage extends BasePage {
	
	public void click_findMeetingLink() throws Exception {
		String ElementName= utilObj.readPropertiesFile(OR, "LINK_FINDMEETING");
		click("xpath", ElementName);
		waitForLoad();
		waitForElementPresent("xpath", ElementName);
	}

	public void searchMeeting() throws Exception {
		String zipInputBox= utilObj.readPropertiesFile(OR,"TEXTBOX_SEARCHZIP");
		waitForElementPresent("id", zipInputBox);
		click("id",zipInputBox);
		enter_text("id",zipInputBox, "10011");
		pressEnter("id",zipInputBox);
		waitForLoad() ;
	}
	
	public void selectMeeting() throws Exception {
		String location= utilObj.readPropertiesFile(OR, "LINK_LOCATION_1");
		String seachLocationTitle= getElementText("xpath",location);
		String locationDistance= getElementText("xpath",utilObj.readPropertiesFile(OR, "LINK_DISTANCE_1"));
		System.out.println("Location =>"+seachLocationTitle+ "  "+"Distance =>"+locationDistance);
		click("xpath",location );
		waitForLoad() ;
		String locationTitle= getElementText("xpath",utilObj.readPropertiesFile(OR, "LINK_MEETINGLOCATION"));
		Assert.assertEquals(locationTitle, seachLocationTitle);
		System.out.println("Location title matches with first searched location title !!!");	
	}
	
	public void printHours() throws Exception {
		waitForLoad() ;
		Date dt= new Date();
		SimpleDateFormat dtFormat= new SimpleDateFormat("EEE");
		String day= dtFormat.format(dt);
		
		List<WebElement> daysList= driver.findElements(By.xpath("//div[@class='schedule-detailed-day-label']"));
	
		for(int i=0; i<daysList.size();i++) {
			
			if (day.equalsIgnoreCase(daysList.get(i).getText())){
				String xpath1= utilObj.readPropertiesFile(OR, "BOX_DAYHOURS_1");
				String xpath2= (i+1)+utilObj.readPropertiesFile(OR, "BOX_DAYHOURS_2");
				String xpath= xpath1+xpath2;
				WebElement dayHours= getElement("xpath",xpath);
				List<WebElement> hoursList= dayHours.findElements(By.className(utilObj.readPropertiesFile(OR, "HOURSLIST")));
				System.out.println("Operation hours details are =>");
				for(int j=0; j<hoursList.size();j++) 
					{
						System.out.print(hoursList.get(j).getText()+"  ");
					}
				System.out.println();
			break;
			}
		}
	}
}
	
	
	

