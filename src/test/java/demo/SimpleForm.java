package demo;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class SimpleForm extends Base {
	
	@Test(groups = {"five"})
	public void simpleInputForm() {
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
		String expectedMessage = "Batman";
		WebElement input = driver.findElement(By.id("user-message"));
		input.sendKeys(expectedMessage);
		WebElement submit = driver.findElement(By.xpath("//button[text()='Show Message']"));
		submit.click();
		String actualMessage = driver.findElement(By.id("display")).getText();
		Assert.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	public void doubleInputForm() {
		driver.get("http://demo.seleniumeasy.com/basic-first-form-demo.html");
		List<WebElement> inputs = driver.findElements(By.xpath("//form[@id='gettotal']//input"));
		inputs.get(0).sendKeys("12");
		inputs.get(1).sendKeys("8");
		WebElement submit = driver.findElement(By.xpath("//button[text()='Get Total']"));
		submit.click();
		String actualResult = driver.findElement(By.id("displayvalue")).getText();
		Assert.assertEquals("20", actualResult);
	}

}
