package com.webdriver.test;
import org.testng.annotations.Test;
import com.webdriver.pages.FindMeetingPage;


public class FindMeetingTests {
	FindMeetingPage meetingPage= new FindMeetingPage();
			
	
	@Test (priority=3)
	public void searchAMeeting() throws Exception {
		System.out.println();
		meetingPage.searchMeeting();
	}
	
	@Test (priority=4)
	public void selectAMeeting() throws Exception {
		System.out.println();
		meetingPage.selectMeeting();
	}
	
	@Test (priority=5)
	public void printMeetingHours() throws Exception {
		System.out.println();
		meetingPage.printHours();
	}
	
	
}
