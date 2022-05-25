package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class geeksPopup {
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

		driver.get(
				"https://www.slidegeeks.com/business/product/up-skilling-vector-with-progress-in-content-writing-ppt-powerpoint-presentation-styles-professional-pdf");
		Thread.sleep(3000);

		WebElement download_Ppt = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='download_product']")));
		js.executeScript("arguments[0].scrollIntoView();", download_Ppt);

		download_Ppt.click();
		Thread.sleep(2000);

		// with Google

		WebElement existingUser = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Existing Users']")));

		js.executeScript("arguments[0].click();", existingUser);
		Thread.sleep(2000);
		WebElement sign_in_with_Google = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class ='is-selected']//ul//li[2]//img")));

		js.executeScript("arguments[0].click();", sign_in_with_Google);
		Thread.sleep(3000);
		// with facebook

		/*
		 * WebElement existingUser = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//a[normalize-space()='Existing Users']")));
		 * 
		 * js.executeScript("arguments[0].click();", existingUser); Thread.sleep(2000);
		 * WebElement sign_in_with_Facebook = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//div[@class ='is-selected']//ul//li[1]"))); Thread.sleep(2000);
		 * sign_in_with_Facebook.click();
		 * 
		 * Thread.sleep(3000)
		 */;

		// div[@class ='is-selected']//input[@name='site_signin_email']
		/*
		 * WebElement existingUser = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//a[normalize-space()='Existing Users']"))); Thread.sleep(2000);
		 * js.executeScript("arguments[0].click();", existingUser); Thread.sleep(2000);
		 * WebElement email_Address = wait.until(ExpectedConditions
		 * .elementToBeClickable(By.
		 * xpath("//div[@class ='is-selected']//input[@name='site_signin_email']")));
		 * Thread.sleep(2000); email_Address.clear();
		 * email_Address.sendKeys("sumit.kumar@slidetech.in"); WebElement password =
		 * wait.until(ExpectedConditions .elementToBeClickable(By.
		 * xpath("//div[@class ='is-selected']//input[@name='site_signin_password']")));
		 * password.clear(); password.sendKeys("redhat2090");
		 * 
		 * WebElement login = wait.until(ExpectedConditions .elementToBeClickable(By.
		 * xpath("	//div[@class ='is-selected']//button[@id = 'site_signin_btn']")));
		 * login.click(); Thread.sleep(3000);
		 */
	}
}