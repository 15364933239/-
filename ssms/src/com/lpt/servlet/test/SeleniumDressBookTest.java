package com.lpt.servlet.test;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SeleniumDressBookTest {

	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	private static String directoryStr = URLDecoder.decode(System.getProperty("user.dir") + "\\src\\"
			+ SeleniumLoginTest.class.getPackage().getName().replace(".", "/"));
	
	@Before
	  public void setUp() {
		  System.setProperty("webdriver.firefox.bin", "D:\\FireFox\\firefox.exe");
		  System.setProperty("webdriver.gecko.driver"
						, directoryStr + "/geckodriver.exe");  
		  driver = new FirefoxDriver();
		  js = (JavascriptExecutor) driver;
		  vars = new HashMap<String, Object>();
	  }

	  
	  @After
	  public void tearDown() {
//	    driver.quit();
	  }
	  
	  @Test
	  public void dressBookTest() {
	    driver.get("http://localhost:8080/ssms/");
	    driver.manage().window().setSize(new Dimension(659, 681));
	    driver.findElement(By.name("account")).click();
	    driver.findElement(By.name("account")).sendKeys("162056114");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("111111");
	    driver.findElement(By.id("submitBtn")).click();
	    System.out.println(0);
	    driver.findElement(By.cssSelector(".panel:nth-child(2) .panel-title")).click();
	    System.out.println(1);
	    driver.findElement(By.partialLinkText("班级通讯录")).click();;
	  }
}
