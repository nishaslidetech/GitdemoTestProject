package demo;

import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Rough {
	public static WebDriverWait wait;
	public static WebDriver driver;
	public static JavascriptExecutor js;
	@Test
	public void test() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	
	wait = new WebDriverWait(driver, 30);
	js = (JavascriptExecutor) driver;
	  driver.get("https://test:!test123!@www4.slideteam.net/" );
	  Thread.sleep(3000);
	    
	    WebElement sign_up_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("*//a[contains(@href,'https://www4.slideteam.net/customer/account/create/')]")));
	    Thread.sleep(4000);
	    sign_up_btn.click();
	    Thread.sleep(7500);
	

	
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	        (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    System.out.println(generatedString);
	    String signup_email=generatedString;
	    String full_email="selenium.testing."+generatedString+"@gmail.com";
	    System.out.println(full_email);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		
		Thread.sleep(4000);
	    WebElement new_email_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/main/div/div/div[2]/div/form/fieldset/div[4]/div/input")));
		Thread.sleep(4000);
	    new_email_signup.sendKeys(full_email);
		Thread.sleep(4000);
	


		WebElement new_fname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("firstname")));
		Thread.sleep(4000);
	    new_fname_signup.sendKeys("Selenium");
		Thread.sleep(4000);

	    WebElement new_lname_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("lastname")));
		Thread.sleep(4000);
	    new_lname_signup.sendKeys("Testing");
		Thread.sleep(4000);
	

	
		 WebElement new_pwd_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		 Thread.sleep(4000);
		 new_pwd_signup.sendKeys("selenium@123");
	     Thread.sleep(4000);

		 WebElement new_pwd1_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("password-confirmation")));
	         //Thread.sleep(4000);
		 new_pwd1_signup.sendKeys("selenium@123");
	     Thread.sleep(4000);
	


		WebElement new_captcha_signup = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_user_create")));
		//Thread.sleep(4000);
	    new_captcha_signup.sendKeys("Aj7W2mtf9namwf55");


		WebElement new_btn_signup = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit'][contains(.,'Sign Up')]")));
		//Thread.sleep(4000);
	        new_btn_signup.click();
		Thread.sleep(5000);
	  
	  try {
			WebElement free_Stuff = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//a[@class='menu-link'][normalize-space()='Free Stuff']")));
			Actions action = new Actions(driver);
			action.moveToElement(free_Stuff).perform();
			WebElement free_ppt = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Free Samples']")));
			action.moveToElement(free_ppt).click().perform();
			Thread.sleep(4000);
		} catch (NoSuchElementException e) {

		}

		
		WebElement selectProduct = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@title='Circular flow of process 4 stages free powerpoint templates slides']")));
		js.executeScript("arguments[0].scrollIntoView();",selectProduct);
		selectProduct.click();
		Thread.sleep(3000);
		WebElement download_p = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='clicking']")));
		js.executeScript("arguments[0].scrollIntoView();",download_p);
		Thread.sleep(4000);
	    download_p.click();
	        
		
	}
	}