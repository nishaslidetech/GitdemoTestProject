package stepDefination;



import java.io.Console;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConsoleError {
	static WebDriver driver;
	static JavascriptExecutor js;
	static String errorLog;

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.slidegeeks.com/ebooks");

		Thread.sleep(4000);
		
		String path = System.getProperty("user.dir");
		PrintStream printlog = new PrintStream(path + "\\console error.txt");
		// check console error
		LogEntries logs = driver.manage().logs().get("browser");

		for (LogEntry entry : logs) {

			errorLog = entry.getMessage().toString();

			System.out
					.println(driver.getCurrentUrl() + "   ---------------" + new Date(entry.getTimestamp())
							+ "-------- " + entry.getLevel() + "--- " + entry.getMessage());

			
				printlog.append(new Date(entry.getTimestamp()) + "---" + driver.getCurrentUrl() + "---" + entry.getLevel() + "---"
						+ entry.getMessage() + "---" + System.getProperty("line.separator"));
		}
		printlog.append(System.getProperty("line.separator"));
		printlog.append(System.getProperty("line.separator"));
		printlog.close();
		Thread.sleep(2000);

		// driver.findElement(By.linkText("FREE SLIDES")).click();

		// Thread.sleep(4000);

		/*
		 * LogEntries logEntries = driver.manage().logs().get("browser"); for (LogEntry
		 * entry : logEntries) { System.out.println(new Date(entry.getTimestamp()) + " "
		 * + entry.getLevel() + " " + entry.getMessage()); String errorLogType =
		 * entry.getLevel().toString(); String errorLog = entry.getMessage().toString();
		 * if (errorLog.contains("404 || 503 || 401 || 502 ")) {
		 * 
		 * System.out.println("Error LogType: " + errorLogType + " Error Log message: "
		 * + errorLog); }
		 * 
		 * }
		 */

// 2nd option
		/*
		 * PrintStream printlog = new
		 * PrintStream("D:\\console error\\console error.rtf");
		 * 
		 * LogEntries logs = driver.manage().logs().get("browser"); for (LogEntry entry
		 * : logs) { System.out.println(new Date(entry.getTimestamp()) + " " +
		 * entry.getLevel() + " " + entry.getMessage()); if (entry.getLevel() ==
		 * entry.getLevel().ALL) printlog.append(new Date(entry.getTimestamp()) + " " +
		 * entry.getLevel() + " " + entry.getMessage() + " " +
		 * System.getProperty("line.separator")); }
		 * printlog.append(System.getProperty("line.separator"));
		 * printlog.append(System.getProperty("line.separator")); printlog.close();
		 */

		// 3rd option
		/*
		 * LogEntries entry = driver.manage().logs().get(LogType.BROWSER); // Retrieving
		 * all log List<LogEntry> logs= entry.getAll(); // Print one by one for(LogEntry
		 * e: logs) { //System.out.println(e); }
		 * 
		 * // Printing details separately for(LogEntry e: logs) {
		 * System.out.println("Message is: " +e.getMessage());
		 * System.out.println("Level is: " +e.getLevel()); }
		 */
		// 4th option

		/*
		 * Logs logs = driver.manage().logs(); LogEntries logEntries =
		 * logs.get(LogType.BROWSER); for (LogEntry logEntry : logEntries) { //
		 * System.out.println("Console log found in Test- " + methodName);
		 * System.out.println(
		 * "__________________________________________________________"); if
		 * (logEntry.getMessage().toLowerCase().contains("error")) {
		 * System.out.println("Error Message in Console:" + logEntry.getMessage()); }
		 * else if (logEntry.getMessage().toLowerCase().contains("warning")) {
		 * System.out.println("Warning Message in Console:" + logEntry.getMessage()); }
		 * else { System.out.println("Information Message in Console:" +
		 * logEntry.getMessage()); } }
		 */

		// check pagination option - 1

		/*
		 * List<String> nameList = new ArrayList<String>(); List<WebElement>
		 * sizeofPagination =
		 * driver.findElements(By.xpath("//div[3]//div[1]//div[1]//div[1]//a"));
		 * 
		 * System.out.println(sizeofPagination.size() + " = size");
		 * 
		 * if (sizeofPagination.size() > 0) { System.out.println("pagination exists");
		 * 
		 * // click on pagination link
		 * 
		 * do {
		 * 
		 * if (!driver.findElements(By.
		 * xpath("//div[3]//div[1]//div[1]//div[1]//img[@alt = 'Next']")).isEmpty()) {
		 * 
		 * WebElement nextButton = driver.findElement(By.
		 * xpath("//div[3]//div[1]//div[1]//div[1]//img[@alt = 'Next']") );
		 * nextButton.click(); Thread.sleep(3000); // print console error PrintStream
		 * printlog = new PrintStream("D:\\console error\\console error.rtf"); // check
		 * console error LogEntries logs = driver.manage().logs().get("browser"); for
		 * 
		 * (LogEntry entry : logs) { System.out.println( new Date(entry.getTimestamp())
		 * + " " + entry.getLevel() + " " + entry.getMessage()); if (entry.getLevel() ==
		 * entry.getLevel().ALL) printlog.append(new Date(entry.getTimestamp()) + " " +
		 * entry.getLevel() + " " + entry.getMessage() + " " +
		 * System.getProperty("line.separator"));\ }
		 * printlog.append(System.getProperty("line.separator"));
		 * printlog.append(System.getProperty("line.separator")); printlog.close();
		 * Thread.sleep(2000); } else
		 * 
		 * { break; }
		 * 
		 * } while (true); } else { System.out.println("No pagination exists"); }
		 */
//geeks pagination - //div[@class = 'product-info']//ul//li 
		// slideteam pagination - //div[3]//div[1]//div[1]//div[1]//a
		// Slideteam next is empty - //div[3]//div[1]//div[1]//div[1]//img[@alt =
		// 'Next']
		// slideteam next - //div[3]//div[1]//div[1]//div[1]//img[@alt = 'Next']
		/*
		 * List<WebElement> sizeofPagination =
		 * driver.findElements(By.xpath("//div[@class = 'product-info']//ul//li"));
		 * 
		 * System.out.println(sizeofPagination.size() + " = size");
		 * 
		 * if (sizeofPagination.size() > 0) { System.out.println("pagination exists");
		 * 
		 * // click on pagination link for (int i = 1; i < 2; i++) {
		 * 
		 * if (!driver.findElements(By.
		 * xpath("//div[@class = 'product-info']//ul//li//a[@title = 'Next']"))
		 * .isEmpty()) {
		 * 
		 * WebElement nextButton = driver .findElement(By.
		 * xpath("//div[@class = 'product-info']//ul//li//a[@title = 'Next']"));
		 * nextButton.click();
		 * 
		 * Thread.sleep(3000); // print console error String path =
		 * System.getProperty("user.dir"); PrintStream printlog = new PrintStream(path +
		 * "\\console error.txt"); // check console error LogEntries logs =
		 * driver.manage().logs().get("browser");
		 * 
		 * for (LogEntry entry : logs) {
		 * 
		 * errorLog = entry.getMessage().toString();
		 * 
		 * System.out .println(driver.getCurrentUrl() + "   ---------------" + new
		 * Date(entry.getTimestamp()) + "-------- " + entry.getLevel() + "--- " +
		 * entry.getMessage());
		 * 
		 * 
		 * printlog.append(new Date(entry.getTimestamp()) + "---" +
		 * driver.getCurrentUrl() + "---" + entry.getLevel() + "---" +
		 * entry.getMessage() + "---" + System.getProperty("line.separator")); }
		 * printlog.append(System.getProperty("line.separator"));
		 * printlog.append(System.getProperty("line.separator")); printlog.close();
		 * Thread.sleep(2000);
		 * 
		 * } else
		 * 
		 * { break; }
		 * 
		 * } } else { System.out.println("No pagination exists"); }
		 */
	}
}
