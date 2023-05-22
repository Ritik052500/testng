package demo;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JenkinsCalcTest {

	WebDriver driver;
	
	@BeforeTest
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.setHeadless(true);
		op.addArguments("--start-maximized");
		driver = new ChromeDriver(op);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@Test
	public void test1() {
		driver.get("https://www.google.com/");
		String homeTitle = driver.getTitle();
		driver.findElement(By.id("APjFqb")).sendKeys("how to tie a tie");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		String newTitle = driver.getTitle();
		Assert.assertNotEquals(homeTitle, newTitle);
	}
	
	@Test
	public void test2() {
		driver.get("https://www.google.com/");
		String homeTitle = driver.getTitle();
		driver.findElement(By.id("APjFqb")).sendKeys("how to tie a shoe");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		String newTitle = driver.getTitle();
		Assert.assertNotEquals(homeTitle, newTitle);
	}
	
	@Test
	public void test3() {
		driver.get("https://www.google.com/");
		String homeTitle = driver.getTitle();
		driver.findElement(By.id("APjFqb")).sendKeys("how to tie a knot");
		driver.findElement(By.id("APjFqb")).sendKeys(Keys.ENTER);
		String newTitle = driver.getTitle();
		Assert.assertNotEquals(homeTitle, newTitle);
	}

}
