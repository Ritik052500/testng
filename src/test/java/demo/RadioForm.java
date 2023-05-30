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

public class RadioForm extends Base {
	
	@Test(groups = {"four"})
	public void radioForm() {
		driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		List <WebElement> buttons = driver.findElements(By.xpath("//div[text()='Radio Button Demo']/..//input"));
		WebElement submit = driver.findElement(By.id("buttoncheck"));
		buttons.get(0).click();
		submit.click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Radio Button Demo']/..//p[@class]")).getText().contains("'Male'"));
	}
	
	@Test
	public void groupRadioForm() {
		driver.get("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		List<WebElement> inputs = driver.findElements(By.xpath("//div[text()='Group Radio Buttons Demo']/..//input"));
		inputs.get(1).click();
		inputs.get(3).click();
		WebElement submit = driver.findElement(By.xpath("//button[text()='Get values']"));
		submit.click();
		String actualResult = driver.findElement(By.xpath("//div[text()='Group Radio Buttons Demo']/..//p[@class]")).getText();
		boolean rule = actualResult.contains("'Female'") && actualResult.contains("15 - 50");
		Assert.assertTrue(rule);
	}

}
