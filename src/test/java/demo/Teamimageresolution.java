package demo;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Teamimageresolution {
	public static WebDriverWait wait;
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static WebElement search_field;
	private String pop_up_Value;
	private String pop_up_visible = "block";
	private String pop_up_not_visible = "none";
	long currentLength;
	long intialLength;

	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		// driver.manage().window().setSize(new Dimension(1536, 864));

		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;
		driver.get("https://www.slideteam.net/professional-powerpoint-templates");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		while (true) {
			intialLength = (long) js.executeScript("return document.body.scrollHeight");
			System.out.println("initialLength = " + intialLength);

			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1200)", "");

			if (!(driver.findElements(By.xpath("//em[normalize-space()='Loading - please wait...']")).isEmpty()))
				;
			{
				Thread.sleep(10000);
				currentLength = (long) js.executeScript("return document.body.scrollHeight");

			}
			if (intialLength == currentLength) {
				break;
			}

			System.out.println("currentLength = " + currentLength);
			intialLength = currentLength;
		}

		for (int second = 0;; second++) {
			if (second >= 30) {
				break;
			}
			js.executeScript("window.scrollBy(0,1200)", "");
			Thread.sleep(3000);
			String url = driver.getCurrentUrl();
			String URL = "https://www.slideteam.net/professional-powerpoint-templates?p=2";
			if (URL.equals(url)) {
				Thread.sleep(8000);

				driver.findElement(By.xpath("//img[@title='Marketing process chart powerpoint icon cc']")).click();
				break;
			}

		}

		long intialLength = (long) js.executeScript("return document.body.scrollHeight");
		System.out.println("initialLength = " + intialLength);
		while (true) {
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			long currentLength = (long) js.executeScript("return document.body.scrollHeight");
			System.out.println("currentLength = " + currentLength);
			if (intialLength == currentLength) {
				break;
			}
			intialLength = currentLength;

		}

	}

}