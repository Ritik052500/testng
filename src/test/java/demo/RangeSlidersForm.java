package demo;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.Base;

public class RangeSlidersForm extends Base {
	
	@Test(groups = {"four"})
	public void progress() throws ParseException, InterruptedException {
		driver.get("http://demo.seleniumeasy.com/drag-drop-range-sliders-demo.html");
		List<WebElement> sliders = driver.findElements(By.xpath("//div[contains(@id,'slider')]"));
		int id = 1;
		sliders.forEach(slider -> {
			js.executeScript("arguments[0].value = 75", slider.findElement(By.tagName("input")));
			js.executeScript("arguments[0].innerHTML = 75", slider.findElement(By.tagName("output")));
		});
}
}
