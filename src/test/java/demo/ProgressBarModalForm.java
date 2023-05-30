package demo;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class ProgressBarModalForm extends Base {
	
	@Test(groups = {"four"})
	public void popup() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

		driver.findElements(By.xpath("//div[@class='panel panel-primary']//button")).stream().forEach(button -> {
			button.click();
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			alert.accept();
		});
		
		
		
		
}
}
