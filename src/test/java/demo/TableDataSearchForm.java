package demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

public class TableDataSearchForm extends Base {

	@Test(groups = {"five"})
	public void tasks() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");
		WebElement tableFilter = driver.findElement(By.id("task-table-filter"));
		String[][] filters = { { "in progress", "3" }, { "Jane Doe", "1" }, { "B", "5" } };
		for (String[] filter : filters) {
			tableFilter.clear();
			tableFilter.sendKeys(filter[0]);
			List<WebElement> tableItems = driver
					.findElements(By.xpath("//table[@id='task-table']//tbody//tr[not(contains(@style,'none'))]"));
			Assert.assertTrue(tableItems.size() == Integer.parseInt(filter[1]));
		}
	}

	@Test
	public void listUsers() throws ParseException, InterruptedException {
		// table[@class='table']//tbody//tr[not(contains(@style,'none'))]
		driver.get("http://demo.seleniumeasy.com/table-search-filter-demo.html");
		WebElement filter = driver.findElement(By.xpath("//button[text()=' Filter']"));
		driver.findElements(By.xpath("//table[@class='table']//input")).forEach(e -> Assert.assertTrue(!e.isEnabled()));
		filter.click();
		List<List<String>> data = new ArrayList<List<String>>();
		Collections.addAll(data, List.of("1", "", "", ""), List.of("", "jacobs", "", ""), List.of("", "", "Byron", ""));
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < data.get(i).size(); j++) {
				driver.findElements(By.xpath("//table[@class='table']//input")).get(j).sendKeys(data.get(i).get(j));
			}
			List<String> filteredTable = driver
					.findElements(By.xpath("//table[@class='table']//tbody//tr[not(contains(@style,'none'))]//td"))
					.stream().map(e -> e.getText()).collect(Collectors.toList());
			boolean flag = false;
			for (int j = 0; j < data.get(i).size(); j++) {
				if (filteredTable.contains(data.get(i).get(j))) {
					flag = true;
				}
			}
			Assert.assertTrue(flag);
			driver.findElements(By.xpath("//table[@class='table']//input")).forEach(e -> e.clear());
		}

	}

}
