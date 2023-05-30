package base;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Set;

import org.junit.BeforeClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base {
	public static WebDriver driver;
	public static int count = 0;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	public static Set<String> handles;
	public static String status;
	public static Actions action;
	public static SimpleDateFormat onscreen = new SimpleDateFormat("MMMM yyyy");
	
	@BeforeTest(alwaysRun = true)
	public void startBrowser() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--start-maximized");
		op.addArguments("--headless");
		driver = new ChromeDriver(op);
		wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@AfterTest(alwaysRun = true)
	public void closeBrowser() {
		driver.close();
	}
}
