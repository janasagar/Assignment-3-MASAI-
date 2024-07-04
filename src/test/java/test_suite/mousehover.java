package test_suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mousehover {
	
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
	}
	@Test
	public void hover() throws InterruptedException {
		WebElement electronics = driver.findElement(By.linkText("Electronics"));
		
		
		
		Actions action = new Actions(driver);
		action.moveToElement(electronics).build().perform();;
		Thread.sleep(3000);
		WebElement refurbished = driver.findElement(By.linkText("Refurbished"));
		action.moveToElement(refurbished).build().perform();;
		Thread.sleep(3000);
		WebElement fashion = driver.findElement(By.linkText("Fashion"));
		action.moveToElement(fashion).build().perform();;
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
