package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class TableFilterForm extends Base {

	@Test(groups = {"five"})
	public void table() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/table-records-filter-demo.html");
		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='btn-group']//button"));
		List<Integer> expected = new ArrayList<Integer>();
		Collections.addAll(expected, 2,2,1,5);
		filters.stream().forEach(element -> {
			element.click();
			wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody//tr[not(contains(@style,'none'))]"), expected.get(count)));
			count++;
		});
	}
	
}
