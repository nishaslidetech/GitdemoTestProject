package demo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class new_user_Geeks_popup {

	WebDriver driver;
	public static WebDriverWait wait;

	public static JavascriptExecutor js;

	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;

		driver.get("https://www.slidegeeks.com/");
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		 options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		Thread.sleep(3000);

		WebElement pricing = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Pricing']")));
		pricing.click();
		Thread.sleep(2000);
		WebElement Join_now = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(
				"div[id='Individual'] form[name='hikashop_product_form_205548_hikashop_category_information_menu_117']")));

		Join_now.click();
		Thread.sleep(2000);

		WebElement name = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='site_signup_name']")));
		Thread.sleep(3000);
		name.sendKeys("Automated Program");
		Thread.sleep(3000);

		// Generate Random Email Address
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String generatedString = buffer.toString();

		System.out.println(generatedString);

		String signup_email = generatedString;
		String full_email = "selenium.testing." + generatedString + "@gmail.com";
		System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);

		WebElement new_email = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='site_signup_email']")));

		new_email.sendKeys(full_email);
		Thread.sleep(3000);

		WebElement password = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='site_signup_password']")));

		password.sendKeys("Geeks@123");

		WebElement captcha = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='captchtext']")));

		captcha.sendKeys("Y3Tt6bfwI");

		WebElement selectRadioBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='site_signup_checkbox']")));

		selectRadioBtn.click();

		WebElement register_btn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='site_signup_btn']")));
		Thread.sleep(3000);
		register_btn.click();
		Thread.sleep(5000);
	}
}
