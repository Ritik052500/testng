package demo;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class JQuerySelectForm extends Base {
	
	@Test(groups = {"four"})
	public void jQueryForm() {
		driver.get("http://demo.seleniumeasy.com/jquery-dropdown-search-demo.html");
		Select country = new Select(driver.findElement(By.id("country")));
		country.selectByValue("Japan");
		WebElement state = driver.findElement(By.xpath("//input[@class='select2-search__field']"));
		List<String> states = List.of("Alabama","Texas","Florida","Nevada");
		states.stream().forEach(val -> {
			state.sendKeys(val);
			state.sendKeys(Keys.ENTER);
		});
		WebElement territory = driver.findElement(By.xpath("//select[contains(@class,'disabled')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", territory);
		Select territories = new Select(territory);
		List<WebElement> allTerritories = territories.getOptions();
		List<String> disbaledTerritories = allTerritories.stream().filter(val -> !val.isEnabled()).map(val -> val.getText()).collect(Collectors.toList());
		Assert.assertTrue(disbaledTerritories.containsAll(List.of("Guam", "United States Minor Outlying Islands")));
		Select file = new Select(driver.findElement(By.id("files")));
		file.getOptions().stream().filter(s -> s.getText().equalsIgnoreCase("java")).forEach(s -> file.selectByVisibleText(s.getText()));
	
	}


}
