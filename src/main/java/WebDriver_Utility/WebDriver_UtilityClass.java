package WebDriver_Utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_UtilityClass {

	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public void waitForElementclickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void switchToTabOnurl(WebDriver driver, String partialurl) {
		Set<String> awin = driver.getWindowHandles();
		// iterator is pointing to awin collection
		Iterator<String> it = awin.iterator();
		// System.out.println("hii");
		while (it.hasNext()) {
			// cpature first data from the awin collection
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String acturl = driver.getCurrentUrl();
			// System.out.println(acturl);
			// to come out of parent win
			if (acturl.contains(partialurl)) {
				break;
			}
		}

	}

	public void switchToTabBasedonTitle(WebDriver driver, String partialTitle) {
		Set<String> awin = driver.getWindowHandles();
		// iterator is pointing to awin collection
		Iterator<String> it = awin.iterator();
		// System.out.println("hii");
		while (it.hasNext()) {
			// cpature first data from the awin collection
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			// System.out.println(acturl);
			// to come out of parent win
			if (actTitle.contains(partialTitle)) {
				break;
			}

		}

	}
	// for frames

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameId) {
		driver.switchTo().frame(nameId);
	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToDefaultFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	// for alert
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// select class======================

	// select by selectbyIndex
	public void selectbyIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	// select by selectbyVisibleText
	public void selectbyVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	// select by selectbyValue
	public void selectbyValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	// Actions class==============================
	// mouse over on ele
	public void mousemoveonelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	// double click on ele
	public void doubleclickonelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	// drag and drop
	public void draganddropelement(WebDriver driver, WebElement src, WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}

	// rightclick
	public void rightclickelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	// scrollbyamount
	public void scrollelefromto(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	// scroll
	public void scrolltoelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

	public void clickandholdelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	// Quit the Browser
	public void quitwindow(WebDriver driver) {
		driver.quit();
		System.err.println("--------------WINDOW QUIT ---------");
	}

	// close the Browser
	public void closewindow(WebDriver driver) {
		driver.close();
		System.err.println("--------------WINDOW Closed---------");
	}

	// to select browser
	public WebDriver browserselect(String browser) {
		WebDriver driver = null;
		System.out.println(browser);

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		
		return driver;
	}

	// Maximize the browser
	public void MaximiseBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// Minimise the browser
	public void minimiseBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	// TakeScreenShot
	public void getscreenshotofBrowser(WebDriver driver, String path) throws Throwable {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		FileHandler.copy(src, dst);

	}

	// takescreenshot of element
	public void getscreenshotofElement(WebElement element, String path) throws Throwable {
		Thread.sleep(3000);
		TakesScreenshot tss = (TakesScreenshot) element;
		File src = tss.getScreenshotAs(OutputType.FILE);

		File dst = new File(path);
		FileHandler.copy(src, dst);
		System.out.println("Screenshot Taken ");

	}

	// Navigate
	public void Navigateback(WebDriver driver) {
		driver.navigate().back();
	}

	public void Navigateforward(WebDriver driver) {
		driver.navigate().forward();

	}

	public void Refresh(WebDriver driver) {
		driver.navigate().refresh();

	}

	public void Scrollusingjs(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public void Screenrecorderstart() throws AWTException {
		Robot r = new Robot();

		// Press Command (⌘) + Shift + 5 (to open screen recording tool)
		r.keyPress(KeyEvent.VK_META); // ⌘ Command key on Mac
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyPress(KeyEvent.VK_5);

		// Release the keys in the same order
		r.keyRelease(KeyEvent.VK_5);
		r.keyRelease(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_META);
	}
	public void cleartextandsendtext(WebElement ele,String data) throws InterruptedException
	{
		ele.sendKeys(Keys.COMMAND + "a");
		  Thread.sleep(1000);
		  ele.sendKeys(Keys.DELETE);
		  Thread.sleep(1000);
		  ele.sendKeys(data);
	}
	public  ChromeOptions chromeoptionsDisableNotf()
	{
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		return option;
		
	}

}
