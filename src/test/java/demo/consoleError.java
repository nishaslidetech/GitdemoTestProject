package demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class consoleError {

	private WebElement select_ppt;
	private WebElement free_Stuff;
	private WebElement free_ppt;
	WebElement business_ppt;
	public static WebDriverWait wait;
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static WebElement search_field;
	private String pop_up_Value;
	private String pop_up_visible = "block";
	private String pop_up_not_visible = "none";
	long currentLength;
	long intialLength;

	static String errorLog;

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

	public static void checkConsoleError() throws InterruptedException, IOException {

		String path = System.getProperty("user.dir");
		// System.out.println("path = " + path);
		BufferedWriter printlog = new BufferedWriter(new FileWriter(path + "\\console error.txt"));
		// PrintStream printlog = new PrintStream(path + "\\console error.txt");
		// check console error
		List<LogEntry> logs = driver.manage().logs().get("browser").getAll();

		for (LogEntry entry : logs) {

			errorLog = entry.getMessage().toString();

			System.out.println(driver.getCurrentUrl() + "   ---------------" + new Date(entry.getTimestamp())
					+ "-------- " + entry.getLevel() + "--- " + entry.getMessage());

			printlog.append(new Date(entry.getTimestamp()) + "---" + driver.getCurrentUrl() + "---" + entry.getLevel()
					+ "---" + entry.getMessage() + "---" + System.getProperty("line.separator"));
		}

		printlog.append(System.getProperty("line.separator"));
		printlog.append(System.getProperty("line.separator"));
		printlog.close();
		Thread.sleep(2000);

	}

	@Test
	public void test() throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		// driver.manage().window().setSize(new Dimension(1536, 864));

		wait = new WebDriverWait(driver, 30);
		js = (JavascriptExecutor) driver;
		driver.get("https://www.slideteam.net/professional-powerpoint-templates");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		long intialLength = (long) js.executeScript("return document.body.scrollHeight");
		while (true) {
			js.executeScript("window.scrollBy(0,10500)", "");
			if (!(driver.findElements(By.xpath("//em[normalize-space()='Loading - please wait...']")).isEmpty())) {
				try {
					WebElement loader = driver
							.findElement(By.xpath("//em[normalize-space()='Loading - please wait...']"));
					js.executeScript("arguments[0].scrollIntoView();", loader);
					Thread.sleep(5000);
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (!(driver.findElements(By.xpath("//button[@type='submit']")).isEmpty())) {
				try {
					WebElement loadMorePPT = driver.findElement(By.xpath("//button[@type='submit']"));
					js.executeScript("arguments[0].scrollIntoView();", loadMorePPT);
					loadMorePPT.click();
					Thread.sleep(5000);
				} catch (NoSuchElementException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			long currentLength = (long) js.executeScript("return document.body.scrollHeight");
			System.out.println("currentLength = " + currentLength);
			if (intialLength == currentLength) {
				System.out.println("intialLength 1 = " + currentLength);
				System.out.println("currentLength 1 = " + currentLength);
				break;
			}
			intialLength = currentLength;

		}

	}

}
