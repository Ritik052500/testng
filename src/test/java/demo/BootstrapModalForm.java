package demo;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

public class BootstrapModalForm extends Base {
	
	@Test(groups = {"one"})
	public void modal() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/bootstrap-modal-demo.html");
		
		driver.findElements(By.xpath("//a[text()='Launch modal']")).get(0).click();
		WebElement save = driver.findElements(By.xpath("//a[text()='Save changes']")).get(0);
		wait.until(ExpectedConditions.visibilityOf(save));
		save.click();
		
		driver.findElements(By.xpath("//a[text()='Launch modal']")).get(1).click();
		WebElement launch = driver.findElements(By.xpath("//a[text()='Launch modal']")).get(2);
		wait.until(ExpectedConditions.visibilityOf(launch));
		launch.click();
		WebElement save3 = driver.findElements(By.xpath("//a[text()='Save changes']")).get(2);
		wait.until(ExpectedConditions.visibilityOf(save3));
		save3.click();
		
}
}
