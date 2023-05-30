package demo;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class AjaxForm extends Base {
	
	@Test(groups = {"one"})
	public void inputForm() {
		driver.get("http://demo.seleniumeasy.com/ajax-form-submit-demo.html");
		WebElement title = driver.findElement(By.id("title"));
		title.sendKeys("Billy Jane");
		WebElement comment = driver.findElement(By.id("description"));
		comment.sendKeys("I like to watch Manifest");
		WebElement submit = driver.findElement(By.id("btn-submit"));
		submit.click();
		WebElement submitMessage = driver.findElement(By.id("submit-control"));
		wait.until(ExpectedConditions.textToBePresentInElement(submitMessage, "Form submited Successfully!"));
		
	
	}


}
