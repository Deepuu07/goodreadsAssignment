package goodreads.com;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
	
	long timeOuts=10;
	long maxWaitTime =10;
	
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	public void setUp(String url) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOuts));
		driver.get(url);
		wait = new WebDriverWait(driver, Duration.ofSeconds(maxWaitTime));
	}
	
	public void close() {
		driver.close();
	}
	
	public void quit() {
		driver.quit();
	}
	
	public WebElement element(String type, String value) {
		switch (type) {
		case "id":
			return driver.findElement(By.id(value));
		case "name":
			return driver.findElement(By.name(value));
		case "classname":
			return driver.findElement(By.className(value));
		case "xpath":
			return driver.findElement(By.xpath(value));
		case "linkText":
			return driver.findElement(By.linkText(value));
		default:
			break;
		}
		return null;
	}
	
	public void click(WebElement ele) {
		WebElement element=wait.withMessage("Element is not clickable").until(ExpectedConditions.elementToBeClickable(ele));
		element.click();
	}
	
	public void type(WebElement ele, String testData) {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(ele));
		element.clear();
		element.sendKeys(testData);
	}
	public void typeAndpressEnter(WebElement ele, String testData) {
		WebElement element=wait.until(ExpectedConditions.visibilityOf(ele));
		element.clear();
		element.sendKeys(testData, Keys.ENTER);
	}
		
	public void Screenshot(String filename) throws IOException {
		File firstSrc=driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./TestScreenShots/"+filename+".png");
		FileHandler.copy(firstSrc, dest);
	}
	
	

}
