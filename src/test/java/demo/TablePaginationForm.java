package demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
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

public class TablePaginationForm extends Base {

	@Test(groups = {"six"})
	public void table() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/table-pagination-demo.html");
		for (int i = 1; i < 4; i++) {
			WebElement page = driver.findElement(By.xpath("//a[text()='"+i+"']"));
			page.click();
			List<WebElement> displayedTableElements = driver.findElements(By.xpath("//tbody//tr[not(contains(@style,'none'))]"));
			Assert.assertTrue(displayedTableElements.size() < 6);
		}
	
	}


}
