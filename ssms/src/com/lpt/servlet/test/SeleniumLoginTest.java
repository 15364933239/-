package com.lpt.servlet.test;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
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

public class SeleniumLoginTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  
  private static String directoryStr = URLDecoder.decode(System.getProperty("user.dir")+"\\src\\"
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
//    driver.quit();
  }
  
  @Test
  public void teacherloginTest() {
    driver.get("http://localhost:8080/ssms/index.jsp");
    driver.findElement(By.name("account")).click();
    driver.findElement(By.name("account")).sendKeys("1601");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("111111");
    driver.findElement(By.xpath(".//*[@class='mt-20 skin-minimal']/div[2]/div/ins")).click();;
    driver.findElement(By.id("submitBtn")).click();
    
    
  }
  
  @Test
  public void studentTest() {
    driver.get("http://localhost:8080/ssms/index.jsp");
//    driver.manage().window().setSize(new Dimension(1550, 848));
    driver.findElement(By.name("account")).click();
    driver.findElement(By.name("account")).sendKeys("162056114");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("111111");
    driver.findElement(By.xpath(".//*[@class='mt-20 skin-minimal']/div[1]/div/ins")).click();;
    driver.findElement(By.id("submitBtn")).click();
  }
  
  @Test
  public void adminTest() {
    driver.get("http://localhost:8080/ssms/index.jsp");
//    driver.manage().window().setSize(new Dimension(1550, 848));
    driver.findElement(By.name("account")).click();
    driver.findElement(By.name("account")).sendKeys("admin");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).sendKeys("111111");
    driver.findElement(By.xpath(".//*[@class='mt-20 skin-minimal']/div[3]/div/ins")).click();;
    driver.findElement(By.id("submitBtn")).click();
  }
}
