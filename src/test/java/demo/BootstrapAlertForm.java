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

public class BootstrapAlertForm extends Base {
	
	@Test(groups = {"one"})
	public void alert() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");
		
		driver.findElement(By.id("autoclosable-btn-success")).click();
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='alert alert-success alert-autocloseable-success']"), "style", "none"));
		
		driver.findElement(By.id("normal-btn-success")).click();
		driver.findElements(By.className("close")).get(0).click();
		
		driver.findElement(By.id("autoclosable-btn-warning")).click();
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='alert alert-warning alert-autocloseable-warning']"), "style", "none"));
		
		driver.findElement(By.id("normal-btn-warning")).click();
		driver.findElements(By.className("close")).get(1).click();;
		
		driver.findElement(By.id("autoclosable-btn-danger")).click();
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='alert alert-danger alert-autocloseable-danger']"), "style", "none"));
		
		driver.findElement(By.id("normal-btn-danger")).click();
		driver.findElements(By.className("close")).get(2).click();

		driver.findElement(By.id("autoclosable-btn-info")).click();
		wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='alert alert-info alert-autocloseable-info']"), "style", "none"));
		
		driver.findElement(By.id("normal-btn-info")).click();
		driver.findElements(By.className("close")).get(3).click();
		
		
}
}
