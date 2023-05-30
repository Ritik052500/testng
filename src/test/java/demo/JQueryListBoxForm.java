package demo;

import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

public class JQueryListBoxForm extends Base {

	@Test(groups = {"three"})
	public void popup() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/jquery-dual-list-box-demo.html");
		
		Select leftBox = new Select(driver.findElements(By.tagName("select")).get(0));
		Select rightBox = new Select(driver.findElements(By.tagName("select")).get(1));
		List<String> allItems = leftBox.getOptions().stream().map(WebElement::getText).toList();
		
		List<String> data = List.of("Alice","Helena","Laura","Julia");
		
		data.stream().forEach(val -> {
			leftBox.selectByVisibleText(val);
		});
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		List<String> actual = rightBox.getOptions().stream().map(WebElement::getText).toList();
		Assert.assertTrue(actual.containsAll(data));
		
		driver.findElement(By.xpath("//button[text()='Add All']")).click();
		actual = rightBox.getOptions().stream().map(WebElement::getText).toList();
		Assert.assertTrue(actual.containsAll(allItems));
		
		data.stream().forEach(val -> {
			rightBox.selectByVisibleText(val);
		});
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		actual = leftBox.getOptions().stream().map(WebElement::getText).toList();
		Assert.assertTrue(actual.containsAll(data));
		
		driver.findElement(By.xpath("//button[text()='Remove All']")).click();
		actual = leftBox.getOptions().stream().map(WebElement::getText).toList();
		Assert.assertTrue(actual.containsAll(allItems));
		
		
		
	}

}
