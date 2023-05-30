package demo;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class InputForm extends Base  {

	@Test(groups = {"three"})
	public void inputForm() {
		driver.get("http://demo.seleniumeasy.com/input-form-demo.html");
		WebElement first_name = driver.findElement(By.name("first_name"));
		first_name.sendKeys("Ritik");
		WebElement last_name = driver.findElement(By.name("last_name"));
		last_name.sendKeys("Patel");
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("ritik@gmail.com");
		WebElement phone = driver.findElement(By.name("phone"));
		phone.sendKeys("1234567890");
		WebElement address = driver.findElement(By.name("address"));
		address.sendKeys("123 Circle Lane");
		WebElement city = driver.findElement(By.name("city"));
		city.sendKeys("Austin");
		WebElement zip = driver.findElement(By.name("zip"));
		zip.sendKeys("12345");
		WebElement website = driver.findElement(By.name("website"));
		website.sendKeys("austin.com");
		List<WebElement> radio = driver.findElements(By.xpath("//input[@type='radio']"));
		radio.get(0).click();
		WebElement projectDescription = driver.findElement(By.tagName("textarea"));
		projectDescription.sendKeys("This is a very fun project");
		WebElement submit = driver.findElement(By.xpath("//button[text()='Send ']"));
		Assert.assertTrue(submit.isEnabled());
		submit.click();
	
	}


}
