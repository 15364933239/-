package com.lpt.servlet.test;

import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SeleniumLoginTest2 {
	private WebDriver driver;
	private static String directoryStr = URLDecoder.decode(System.getProperty("user.dir")+"\\src\\"
				+ SeleniumLoginTest.class.getPackage().getName().replace(".", "/"));
	
	@Test
	public void loginTest() throws InterruptedException {
		
		System.setProperty("webdriver.firefox.bin", "D:\\FireFox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", directoryStr + "/geckodriver.exe");  
		driver = new FirefoxDriver();
//		FirefoxBinary firefoxBinary = new FirefoxBinary();
//      firefoxBinary.addCommandLineOptions("--headless");
//      FirefoxOptions firefoxOptions = new FirefoxOptions();
//	    firefoxOptions.setBinary(firefoxBinary);
//	    FirefoxDriver driver =  new FirefoxDriver(firefoxOptions);
		
		//隐式等待
//		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		
		//在当前浏览器窗口以GET方式加载一个新的页面 
		driver.get("http://localhost:8080/ssms/index.jsp");
		driver.manage().window().setSize(new Dimension(1550, 848));
	    driver.findElement(By.name("account")).click();
	    driver.findElement(By.name("account")).sendKeys("admin");
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).sendKeys("111111");
	    driver.findElement(By.xpath(".//*[@class='mt-20 skin-minimal']/div[1]/div/ins")).click();;
	    driver.findElement(By.id("submitBtn")).click();
		
		
		
//		//找到账号框并点击
//		WebElement accountElement =  driver.findElement(By.id("account"));
//		System.out.println(3);
//		accountElement.click();
//		System.out.println(4);
//		//强制等待
//		Thread.sleep(1000);
//		//清空账号框
//		accountElement.clear();
//		Thread.sleep(1000);
//		//输入账号
//		System.out.println(5);
//		accountElement.sendKeys("admin");
//		Thread.sleep(1000);
//		
//		//找到密码框框并点击
//		System.out.println(6);
//		WebElement pwdElement =  driver.findElement(By.id("password"));
//		System.out.println(7);
//		pwdElement.click();
//		//强制等待
//		Thread.sleep(1000);
//		//清空密码框
//		pwdElement.clear();
//		Thread.sleep(1000);
//		//输入密码
//		pwdElement.sendKeys("111111");
//		System.out.println(8);
//		Thread.sleep(1000);
//		
//		//找到复选按钮根据id选择角色
//		WebElement typeElement =  driver.findElement(By.id("radio-1"));
//		System.out.println(9);
//		typeElement.click();
//		Thread.sleep(1000);
//		
//		//找到登录按钮并点击
//		WebElement submitElement =  driver.findElement(By.id("submitBtn"));
//		System.out.println(10);
//		submitElement.click();
		
		
	}
	
}
