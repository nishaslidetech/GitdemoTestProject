package demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class rouughClass extends BaseClass {
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static FileInputStream fis;
	public static WebDriverWait wait;

	@DataProvider
	public Object[][] windowResolution() {

		return new Object[][] { { 2560, 1440 },
				 { 1920, 1080 }, { 1280, 720 }, { 1536, 864 }, { 1366, 768 }, { 1680, 1050 },
				{ 1920, 1200 }, { 1440, 900 }
		};
	}
	

	@Test(dataProvider = "windowResolution")
	public static void initilizeDriver(int w, int h) throws InterruptedException {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();

			driver.manage().window().setSize(new Dimension(w, h));
			// driver.manage().window().maximize();
			js = (JavascriptExecutor) driver;
			wait = new WebDriverWait(driver, 30);

			// check resolution testing the Newly Products

			/*
			 * driver.get(config.getProperty("testsiteurl")); Thread.sleep(2000); WebElement
			 * newlyAdded = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "NewlyAdded")))); newlyAdded.click(); Thread.sleep(3000);
			 * checkResolutionForNewlyAndPopular(driver);
			 */

			// check resolution testing for popular PPts

			driver.get(config.getProperty("testsiteurl"));
			Thread.sleep(2000);
			WebElement popularPPts = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("PopularPPts"))));
			popularPPts.click();
			Thread.sleep(3000);
		//	BaseClass.checkResolutionForNewlyAndPopular(driver);

			// Check Resolution testing for the A4 Products
			/*
			 * driver.get(config.getProperty("testsiteurl")); WebElement onePager = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "onePager")))); onePager.click(); Thread.sleep(3000);
			 * 
			 * List<WebElement> sizeofPagination =
			 * driver.findElements(By.xpath(OR.getProperty("Pagination")));
			 * 
			 * System.out.println(sizeofPagination.size() + " = size");
			 * 
			 * if (sizeofPagination.size() > 0) { System.out.println("pagination exists");
			 * 
			 * // click on pagination link
			 * 
			 * do { BaseClass.checkResolutionForA4Pages(driver); if
			 * (!driver.findElements(By.xpath(OR.getProperty("NextButton"))).isEmpty()) {
			 * WebElement nextButton =
			 * driver.findElement(By.xpath(OR.getProperty("NextButton")));
			 * nextButton.click(); } else
			 * 
			 * { break; } } while (true); } else {
			 * System.out.println("No pagination exists"); }
			 */

			// Check Resolution for Emarsys pages

			/*
			 * driver.get(config.getProperty("testsiteurl")); Thread.sleep(3000);
			 * List<WebElement> listofImages =
			 * driver.findElements(By.xpath(OR.getProperty("EmarsysImages")));
			 * System.out.println("Number of elements:" + listofImages.size());
			 * 
			 * for (int i = 0; i < listofImages.size(); i++) {
			 * 
			 * float width = listofImages.get(i).getSize().getWidth(); float hight =
			 * listofImages.get(i).getSize().getHeight();
			 * System.out.println(listofImages.get(i).getAttribute("title") + " -" + width +
			 * "-" + hight); float roundedValue = width / hight;
			 * System.out.println((roundedValue) + "roundedValue"); DecimalFormat df = new
			 * DecimalFormat("#.###"); df.setRoundingMode(RoundingMode.CEILING);
			 * System.out.println(df.format(roundedValue)); Double value =
			 * Double.valueOf(roundedValue); System.out.println(value + "= value"); // // //
			 * // assertTrue(value.equals(actualValue) || value.equals(actualValue1), "image
			 * is // // not displayed properly");
			 * 
			 * }
			 * 
			 * // check Resolution testing for the sLi Pages
			 * driver.get(config.getProperty("testsiteurl")); WebElement strategy = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "strategy")))); strategy.click(); BaseClass.checkResolutionSliPages(driver);
			 * 
			 * WebElement proposals = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "proposals")))); proposals.click();
			 * BaseClass.checkResolutionSliPages(driver);
			 * 
			 * WebElement kpiDashooard = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "kpiDashooard")))); kpiDashooard.click();
			 * BaseClass.checkResolutionSliPages(driver);
			 * 
			 * WebElement professional = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "professional")))); professional.click();
			 * BaseClass.checkResolutionSliPages(driver);
			 * 
			 * WebElement management = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "management")))); management.click();
			 * BaseClass.checkResolutionSliPages(driver);
			 * 
			 * WebElement businessproposals = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "businessproposals")))); businessproposals.click();
			 * BaseClass.checkResolutionSliPages(driver);
			 * 
			 * WebElement orgCharts = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "orgCharts")))); orgCharts.click();
			 * BaseClass.checkResolutionSliPages(driver);
			 * 
			 * WebElement education = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "education")))); education.click();
			 * BaseClass.checkResolutionSliPages(driver);
			 * 
			 * WebElement digitalMarketing = wait
			 * .until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(
			 * "digitalMarketing")))); digitalMarketing.click();
			 * BaseClass.checkResolutionSliPages(driver);
			 */

		}
		
		
	}
	

}
