package WebDriver_Utility;

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
		Iterator<String> it = awin.iterator();
		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String acturl = driver.getCurrentUrl();
			if (acturl.contains(partialurl)) {
				break;
			}
		}

	}

	public void switchToTabBasedonTitle(WebDriver driver, String partialTitle) {
		Set<String> awin = driver.getWindowHandles();
		Iterator<String> it = awin.iterator();

		while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialTitle)) {
				break;
			}

		}

	}

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

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();

	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void selectbyIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void selectbyVisibleText(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void selectbyValue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void mousemoveonelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleclickonelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	public void draganddropelement(WebDriver driver, WebElement src, WebElement dst) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}

	public void rightclickelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public void scrollelefromto(WebDriver driver, int x, int y) {
		Actions act = new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}

	public void scrolltoelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
	}

	public void clickandholdelement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	public void quitwindow(WebDriver driver) {
		driver.quit();
		System.err.println("--------------WINDOW QUIT ---------");
	}

	public void closewindow(WebDriver driver) {
		driver.close();
		System.err.println("--------------WINDOW Closed---------");
	}

	public WebDriver browserselect(String browser) {
		WebDriver driver = null;
		System.out.println(browser);

		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}

		return driver;
	}

	public void MaximiseBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimiseBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void getscreenshotofBrowser(WebDriver driver, String path) throws Throwable {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		FileHandler.copy(src, dst);

	}

	public void getscreenshotofElement(WebElement element, String path) throws Throwable {
		Thread.sleep(3000);
		TakesScreenshot tss = (TakesScreenshot) element;
		File src = tss.getScreenshotAs(OutputType.FILE);

		File dst = new File(path);
		FileHandler.copy(src, dst);
		System.out.println("Screenshot Taken ");

	}

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

	public void cleartextandsendtext(WebElement ele, String data) throws InterruptedException {
		ele.sendKeys(Keys.COMMAND + "a");
		Thread.sleep(1000);
		ele.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		ele.sendKeys(data);
	}

}
