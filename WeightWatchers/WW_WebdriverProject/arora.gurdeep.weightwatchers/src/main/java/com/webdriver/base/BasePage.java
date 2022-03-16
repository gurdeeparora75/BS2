package com.webdriver.base;


import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.webdriver.util.utilMethods;

public class BasePage {

	public static WebDriver driver= null;
	String HOMEPATH= null;
	protected utilMethods utilObj =  new utilMethods();
	protected final String CONFIG= "Config.properties";
	protected final String OR= "ObjectRepository.properties";
	public static final int waitTime = 30;
	protected String browser=null;
	protected String URL= null;
	
	
	
	public void selectDriver() {
		try 
		 {
			browser= utilObj.readPropertiesFile(CONFIG, "Browser");	
			URL= utilObj.readPropertiesFile(CONFIG, "URL");
			System.out.println("Opening Browser.... "+browser);
			if (browser.equalsIgnoreCase("firefox")) {
				System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\geckodriver.exe");
				driver= new FirefoxDriver();
			}else if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");
				driver= new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
		 } catch (Exception e) { 
			e.printStackTrace();
		 }
	}
		
	public WebElement getElement(String locator, String elementName){
		WebElement element = null;
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		try 
		{
			if(locator.equalsIgnoreCase("id")){
				element = driver.findElement(By.id(elementName));
			}else if(locator.equalsIgnoreCase("xpath")){
				element = driver.findElement(By.xpath(elementName));
			}else if(locator.equalsIgnoreCase("className")){
				element = driver.findElement(By.className(elementName));
			}else if(locator.equalsIgnoreCase("name")){
				element = driver.findElement(By.name(elementName));
			}else if(locator.equalsIgnoreCase("css")){
				element = driver.findElement(By.cssSelector(elementName));
			}else if(locator.equalsIgnoreCase("linkText")){
				element = driver.findElement(By.linkText(elementName));
			}else if(locator.equalsIgnoreCase("partialLinkText")){
				element = driver.findElement(By.partialLinkText(elementName));
			}
		}catch(NoSuchElementException e) {
			System.out.println("Element Not Found");
			e.getMessage();
		}	
		return element;
	}
	
	public void enter_text(String elementName, String locator, String text) {
		WebElement element= getElement(elementName,locator);
		element.sendKeys(text);
	}
	
	public void click(String elementName, String locator) {
		WebElement element= getElement(elementName,locator);
		element.click();
	}
	
	public void waitForElementPresent(String elementName, String locator) {
		WebElement element= getElement(elementName,locator);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void pressEnter(String elementName, String locator) {
		WebElement element= getElement(elementName,locator);
		element.sendKeys(Keys.ENTER);
	}
	
	public void waitForLoad() {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}
	
	public String getElementText(String elementName, String locator) {
		WebElement element= getElement(elementName,locator);
		return element.getText();	
	}
	
		
}	