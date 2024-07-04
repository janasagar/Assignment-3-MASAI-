package test_suite;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class signup {
	
	WebDriver driver;
	
	@BeforeTest
	public void visit() throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/signup");
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
	}
	@Test
	public void register() {
		
		driver.findElement(By.name("reg_email__")).sendKeys("7098510151");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Annotations@testng");
		
		Select day = new Select(driver.findElement(By.id("day")));
		Select month = new Select(driver.findElement(By.id("month")));
		Select year = new Select(driver.findElement(By.id("year")));
		day.selectByVisibleText("17");
		month.selectByVisibleText("May");
		year.selectByVisibleText("1997");
		
		driver.findElement(By.xpath("//input[@value='2']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Sagar");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Jana");
		driver.findElement(By.name("websubmit")).click();
		
	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
