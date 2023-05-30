package demo;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
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

public class JQueryProgressBar extends Base {
	
	@Test(groups = {"three"})
	public void progress() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/bootstrap-download-progress-demo.html");
		driver.findElement(By.id("cricle-btn")).click();
		long start = System.currentTimeMillis();
		wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='percenttext']"), "100%"));
		System.out.println("Download was completed in " + ((System.currentTimeMillis() - start)/1000) + " seconds.");
}
}
