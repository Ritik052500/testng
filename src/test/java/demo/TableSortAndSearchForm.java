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

public class TableSortAndSearchForm extends Base {
	
	@Test(groups = {"six"})
	public void table() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/table-sort-search-demo.html");
		Select numResults = new Select(driver.findElement(By.xpath("//select")));
		numResults.selectByVisibleText("25");
		int numTableRows = driver.findElements(By.xpath("//tbody//tr")).size();
		Assert.assertTrue(numTableRows <= 25);
		driver.findElement(By.xpath("//div[@id='example_filter']//input")).sendKeys("Software");
		Assert.assertTrue(driver.findElements(By.cssSelector("tbody tr")).size() == 3);
}
}
