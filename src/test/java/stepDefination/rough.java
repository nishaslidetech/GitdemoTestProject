package stepDefination;


import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import demo.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class rough {
	public static String pop_up_Value;
	public static String pop_up_visible = "block";
	public static String pop_up_not_visible = "none";
	public static WebElement search_field;
	static WebDriver driver;
	public static WebDriverWait wait;

	public static JavascriptExecutor js;

	public static WebElement elementToBeClickable(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement precenceOfElement(By locator) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				// Check for condition in every 2 seconds
				.pollingEvery(Duration.ofSeconds(2))
				// Till time out i.e. 30 seconds
				.withTimeout(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	@Test
	public static void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;

		driver.get("https://www.slidegeeks.com/");

		Thread.sleep(5000);

		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.sendKeys("HR");
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {

		}
		try {
			Thread.sleep(2000);
			pop_up_Value = precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");

			System.out.println("pop-up value before pressing Escape key1 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.moveByOffset(0, 83).click().perform();
			} else {

				System.out.println("pop-up is not displayed before pressing Escape key1 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}
		} catch (NoSuchElementException e) {
		}

		try {
			Thread.sleep(3000);
			pop_up_Value = precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after pressing Escape key1 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			search_field.sendKeys("HR");
			Thread.sleep(4000);

			// click on "hr report" in left navigation bar

			WebElement hr_Report = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@Class='sli_ac_suggestions']//ul//li[5]")));
			hr_Report.click();
			Thread.sleep(3000);

			// Clear the search field and enter "Management" on sli listing page
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			search_field.sendKeys("Software");
			Thread.sleep(3000);

			// Pressed ESC key after pop-up is visible else script got failed

			pop_up_Value = driver.findElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			Thread.sleep(2000);
			System.out.println("pop-up value before pressing Escape key2 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.moveByOffset(0, 83).click().perform();
				Thread.sleep(2000);

			} else {

				System.out.println("pop-up is not displayed before pressing Escape key2 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}

			// verify the pop-up should not visible after pressing Escape key

			Thread.sleep(3000);
			pop_up_Value = precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after pressing Escape key2 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(2000);

		} catch (NoSuchElementException e) {

		}
		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			Thread.sleep(2000);
			WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGIN")));
			Thread.sleep(3000);
			js.executeScript("arguments[0].click();", login);
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}

		Thread.sleep(3000);
		try {
			WebElement email = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='E-mail Address']")));
			email.sendKeys("qaslidegeeks@gmail.com");

			WebElement password_field = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
			password_field.sendKeys("Qwerty@1");
			Thread.sleep(2000);

			WebElement login_btn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Submit']")));
			login_btn.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {

		}

		try {
			Thread.sleep(3000);
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.sendKeys("Management");
			Thread.sleep(3000);
		} catch (InterruptedException e) {

		}

		try {
			Thread.sleep(3000);
			pop_up_Value = precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is not displayed before pressing Escape key3 " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.moveByOffset(0, 83).click().perform();
			} else {

				System.out.println("pop-up is not displayed before pressing Escape key3 " + pop_up_Value);
				// condition failed with none and block value
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}
		} catch (NoSuchElementException e) {
		}

		try {
			Thread.sleep(3000);
			pop_up_Value = precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after pressing Escape key3 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));

			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			Thread.sleep(3000);

		} catch (NoSuchElementException e) {

		}

		try {
			search_field = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search-input']")));
			search_field.clear();
			search_field.sendKeys("Management");
			Thread.sleep(3000);

			// click on "hr report" in left navigation bar

			WebElement change_Management_Decks = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@Class='sli_ac_suggestions']//ul//li[6]")));
			change_Management_Decks.click();
			System.out.println();

			// Clear the search field and enter "Management" on sli listing page
			Thread.sleep(2000);
			search_field = elementToBeClickable(By.xpath("//input[@id='search-input']"));
			search_field.clear();
			search_field.sendKeys("HR");
			Thread.sleep(4000);

			// Pressed ESC key after pop-up is visible else script got failed

			pop_up_Value = precenceOfElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up value before pressing Escape key4 =  " + pop_up_Value);
			if (pop_up_Value.equals(pop_up_visible)) {

				Actions action = new Actions(driver);
				action.moveByOffset(0, 83).click().perform();
				Thread.sleep(2000);

			} else {

				System.out.println("pop-up is not displayed before pressing Escape key4 " + pop_up_Value);
				assertTrue(pop_up_Value.equals(pop_up_visible));
			}

			// verify the pop-up should not visible after pressing Escape key

			Thread.sleep(3000);
			pop_up_Value = driver.findElement(By.xpath("//ul[@id='sli_autocomplete']")).getCssValue("display");
			System.out.println("pop-up is displayed after pressing Escape key4 " + pop_up_Value);
			assertTrue(pop_up_Value.equals(pop_up_not_visible));
			Thread.sleep(4000);

		} catch (NoSuchElementException e) {

		}
		try {
			// click on sign out button
			driver.navigate().refresh();
			WebElement sign_Out = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("LOGOUT")));
			js.executeScript("arguments[0].click();", sign_Out);
			Thread.sleep(3000);

		} catch (NoSuchElementException e) {

		}

	}

}
