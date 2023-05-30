package demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import base.Base;

public class DynamicDataForm extends Base {
	
	@Test(groups = {"two"})
	public void popup() throws ParseException, InterruptedException, IOException {
		driver.get("http://demo.seleniumeasy.com/dynamic-data-loading-demo.html");
		WebElement getUser = driver.findElement(By.id("save"));
		JSONObject jsonObj = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		for(int i = 1; i < 3; i++) {
			getUser.click();
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("loading"), "First"));
			String[] name =  driver.findElement(By.id("loading")).getText().split("First Name :|Last Name : ");
			String url = driver.findElement(By.xpath("//*[@id='loading']//img")).getAttribute("src");
			JSONObject data = new JSONObject();
			data.put("id", i);
			data.put("fName", name[1].trim());
			data.put("lName", name[2].trim());
			data.put("url", url);
			jsonArr.put(data);
		}
		jsonObj.put("data", jsonArr);
//		File file = new File(System.getProperty("user.dir") + "//output.json");
//		FileWriter writer = new FileWriter(file);
//		writer.write(jsonObj.toString());
//		writer.close();
//		FileReader reader = new FileReader(file);
//		JsonObject  data = JsonParser.parseReader(reader).getAsJsonObject();
//		JsonArray arr = (JsonArray) data.get("data");
//		JsonObject obj = (JsonObject) arr.get(1);
//		System.out.println(obj.get("id"));
		
	}

}
