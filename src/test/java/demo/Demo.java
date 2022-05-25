package demo;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Demo extends BaseClass {
	/*
	 * WebDriver driver;
	 * 
	 * @Test(dataProvider = "mobileEmulations", enabled = false) public void
	 * setDriver(String emulation, int h, int w) { if
	 * (config.getProperty("browser").equals("chrome")) {
	 * WebDriverManager.chromedriver().setup();
	 * 
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "D:\\Selenium Live Projects\\ResponsiveTesting\\src\\test\\resources\\teamProperties\\chromedriver.exe"
	 * );
	 * 
	 * ChromeOptions options = new ChromeOptions();
	 * 
	 * Map<String, String> deviceMobEmu = new HashMap<>();
	 * deviceMobEmu.put("deviceName", emulation);
	 * 
	 * options.setExperimentalOption("mobileEmulation", deviceMobEmu); driver = new
	 * ChromeDriver(options);
	 * 
	 * Dimension d = new Dimension(w, h);
	 * 
	 * driver.manage().window().setSize(d); driver.manage().window().maximize();
	 * log.info("chrome Launched !!!");
	 * 
	 * driver.get("https://www.slideteam.net/professional-powerpoint-templates");
	 * 
	 * } }
	 * 
	 * @DataProvider public Object[][] mobileEmulations() {
	 * 
	 * return new Object[][] { // { "iPhone SE", 420, 600 }, { "Galaxy Fold", 280,
	 * 653 }, {"iPhone X", 375, // 812}, {"iPad Mini", 390, 844},{"iPhone 4", 375,
	 * 812} // {"Samsung Galaxy S21", 360, 800}, // {"Galaxy Tab S6", 712, 1038}, //
	 * {"iPhone 12Pro", 390, 844}, // // {"Galaxy S20", 384, 853},
	 * //{"Galaxy Tab S7", 753, 1037}, // {"iPhone xr", 414, 896},// {"iPhone 11",
	 * 393, 778}, // {"iPhone 11 Pro Max", 393, 778},
	 * 
	 * }; }
	 * 
	 * @Test(enabled = false) public void setdriver1() {
	 * 
	 * // WebDriverManager.chromedriver().setup();
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "D:\\Selenium Live Projects\\ResponsiveTesting\\src\\test\\resources\\teamProperties\\chromedriver.exe"
	 * );
	 * 
	 * ChromeDriver driver = new ChromeDriver();
	 * driver.manage().window().maximize(); DevTools devtools =
	 * driver.getDevTools(); devtools.createSession(); Map<String, Object>
	 * devicesMetrix = new HashMap<>(); devicesMetrix.put("width", 414);
	 * devicesMetrix.put("height", 896); devicesMetrix.put("deviceScaleFactor", 40);
	 * devicesMetrix.put("mobile", true);
	 * 
	 * 
	 * driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",
	 * devicesMetrix);
	 * driver.get("https://www.slideteam.net/professional-powerpoint-templates");
	 * 
	 * WebElement image1 = driver.findElement(By.xpath(
	 * "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]"
	 * ));
	 * 
	 * int width=image1.getSize().getWidth(); int
	 * hight=image1.getSize().getHeight();
	 * 
	 * System.out.println(width +">>>"+hight);
	 * 
	 * driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",
	 * devicesMetrix);
	 * driver.get("https://www.slideteam.net/new-powerpoint-templates/");
	 * 
	 * WebElement image1 = driver.findElement(By.xpath(
	 * "//img[@title='Corporate Training Organizations Ppt Powerpoint Presentation Ideas Slide Download Cpb']"
	 * ));
	 * 
	 * int width = image1.getSize().getWidth(); int hight =
	 * image1.getSize().getHeight();
	 * 
	 * System.out.println(width + ">>>" + hight);
	 * 
	 * }
	 * 
	 * @Test(enabled = false) public void setdriver2() {
	 * 
	 * WebDriverManager.chromedriver().setup();
	 * 
	 * 
	 * System.setProperty("webdriver.chrome.driver",
	 * "D:\\Selenium Live Projects\\ResponsiveTesting\\src\\test\\resources\\teamProperties\\chromedriver.exe"
	 * );
	 * 
	 * 
	 * ChromeDriver driver = new ChromeDriver();
	 * 
	 * DevTools devtools = driver.getDevTools(); devtools.createSession();
	 * 
	 * devtools.send(Emulation.setDeviceMetricsOverride(600, 1000, 30, true,
	 * Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
	 * Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
	 * Optional.empty()));
	 * 
	 * // devtools.send(Emulation.setdev)
	 * driver.get("https://www.slideteam.net/professional-powerpoint-templates");
	 * 
	 * }
	 * 
	 * @Test(enabled = false) public void setdriver3() throws InterruptedException {
	 * WebDriverManager.chromedriver().setup(); ChromeDriver driver = new
	 * ChromeDriver(); driver.manage().window().maximize(); js =
	 * (JavascriptExecutor) driver; wait = new WebDriverWait(driver, 30);
	 * driver.get("https://www.slideteam.net/professional-powerpoint-templates");
	 * 
	 * Dimension initial_size = driver.manage().window().getSize(); int height =
	 * initial_size.getHeight(); int width = initial_size.getWidth();
	 * System.out.println("Default Height " + height + " Default width " + width);
	 * 
	 * driver.manage().window().setSize(new Dimension(800,600));
	 * 
	 * initial_size = driver.manage().window().getSize(); height =
	 * initial_size.getHeight(); width = initial_size.getWidth();
	 * System.out.println(" Changed width "+ width+" Changed Height "+height );
	 * 
	 * WebElement image1 = driver.findElement( By.xpath(
	 * "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]"
	 * )); Boolean p = (Boolean) ((JavascriptExecutor)
	 * driver).executeScript("return arguments[0].complete " +
	 * "&& typeof arguments[0].naturalWidth != \"undefined\" " +
	 * "&& arguments[0].naturalHeight == 186", image1);
	 * 
	 * // verify if status is true if (p) { System.out.println("Logo present"); }
	 * else { System.out.println("Logo not present"); }
	 * 
	 * }
	 * 
	 * @Test(enabled = false) public void setdriver4() throws InterruptedException {
	 * // WebDriverManager.chromedriver().setup(); // DesiredCapabilities dc=new
	 * DesiredCapabilities(); // dc.setCapability("screen-resolution","414*896"); //
	 * ChromeDriver driver = new ChromeDriver();
	 * 
	 * // driver.manage().window().setSize(new Dimension(375,667)); //
	 * driver.manage().window().maximize(); // js = (JavascriptExecutor) driver; //
	 * wait = new WebDriverWait(driver, 30);
	 * 
	 * driver.get("https://www.slideteam.net/professional-powerpoint-templates");
	 * 
	 * WebElement image1 = driver.findElement(By.xpath(
	 * "/html[1]/body[1]/div[2]/main[1]/div[2]/div[1]/div[4]/div[1]/ol[1]/li[1]/div[1]/a[1]/img[1]"
	 * ));
	 * 
	 * int width=image1.getSize().getWidth(); int
	 * hight=image1.getSize().getHeight();
	 * 
	 * System.out.println(width +">>>"+hight); //Assert.assertEquals(width, 200);
	 * 
	 * 
	 * driver.get("https://www.slideteam.net/new-powerpoint-templates/");
	 * 
	 * WebElement image1 = driver.findElement(By.xpath(
	 * "//img[@title='Corporate Training Organizations Ppt Powerpoint Presentation Ideas Slide Download Cpb']"
	 * ));
	 * 
	 * int width = image1.getSize().getWidth(); int hight =
	 * image1.getSize().getHeight();
	 * 
	 * System.out.println(width + ">>>" + hight); }
	 */

}
