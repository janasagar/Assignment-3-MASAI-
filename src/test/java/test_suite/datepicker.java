package test_suite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class datepicker {
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		
		driver.manage().window().maximize();
		Thread.sleep(8000);
		
	}
	@Test
	public void pick1() throws InterruptedException {
		driver.findElement(By.xpath("//img[@class='imgdp']")).click();
		Thread.sleep(8000);
		
		WebElement el = driver.findElement(By.id("ui-datepicker-div"));
		WebDriverWait exwait =  new WebDriverWait(driver,Duration.ofSeconds(30));
		exwait.until(ExpectedConditions.visibilityOf(el));
		
		
		String actualmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		
		String actualyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		
		
		while(!(actualmonth.equals("May")&&actualyear.equals("2024"))) {
			
			
			driver.findElement(By.xpath("//a[@data-handler='prev']")).click();
			 actualmonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			
			 actualyear = driver.findElement(By.className("ui-datepicker-year")).getText();
		}
		
		driver.findElement(By.xpath("//a[normalize-space()='17']")).click();
		
	}
	
	@Test(dependsOnMethods = "pick1")
	public void pick2() throws InterruptedException {
		driver.findElement(By.id("datepicker2")).click();
		Thread.sleep(8000);
		

		
		Select year = new Select(driver.findElement(By.xpath("//select[@title='Change the year']")));
		year.selectByVisibleText("2024");
		
		Select month = new Select(driver.findElement(By.xpath("//select[@title='Change the month']")));
		month.selectByVisibleText("May");
		driver.findElement(By.xpath("//a[@title='Select Friday, May 17, 2024']")).click();
		
		
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}

}
