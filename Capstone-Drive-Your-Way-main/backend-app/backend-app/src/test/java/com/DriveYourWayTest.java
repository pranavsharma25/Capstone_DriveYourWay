package com;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Function;

@Test

public class DriveYourWayTest {

	WebDriver wd;

	@BeforeClass
	public void startBrowser() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sharm\\Downloads\\chromedriver_win32\\chromedriver.exe");
		wd = new ChromeDriver();

		wd.get("http://localhost:4200/login");
		wd.manage().window().maximize();

	}

	
	

//Admin
	
	public void search() throws InterruptedException {
		// Search
		wd.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@gmail.com");
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@type='password']")).sendKeys("admin123");
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@value='admin']")).click();
		
		Thread.sleep(2000);
		
		wd.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		
		wd.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		Thread.sleep(2000);
		
		wd.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		Thread.sleep(2000);
		wd.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@type='text']")).sendKeys("Honda City");
		
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@type='number']")).sendKeys("546");
		
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@type='url']")).sendKeys("www.hondacity.com");
		
		
		Thread.sleep(2000);
		wd.findElement(By.xpath("//input[@value=' Add Product']")).click();
		
		
		
		
		
		
		
		

	

}