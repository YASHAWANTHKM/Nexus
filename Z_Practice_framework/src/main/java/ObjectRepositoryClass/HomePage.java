package ObjectRepositoryClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriver_Utility.WebDriver_UtilityClass;

public class HomePage extends WebDriver_UtilityClass {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[text()='Logout']")
	private WebElement Logoutbtn;

	@FindBy(xpath = "//div[@class='MuiBox-root css-1ksgvl']")
	private WebElement Profilebtn;

	@FindBy(xpath = "//button[contains(@class,'t MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-colorPrimary css-9a1zl')]")
	private WebElement cancelbutton;

	@FindBy(xpath = "//button[text()='Add Station']")
	private WebElement addStationtbtn;

	@FindBy(xpath = "//div[@class='MuiAlert-message css-1xsto0d']")
	private WebElement confirmationmsg;

	@FindBy(xpath = "//a[@aria-label='Stations']")
	private WebElement stationtab;

	public WebElement getStationtab() {
		return stationtab;
	}

	public WebElement getConfirmationmsg() {
		return confirmationmsg;
	}

	public WebElement getLogoutbtn() {
		return Logoutbtn;
	}

	public WebElement getProfilebtn() {
		return Profilebtn;
	}

	public WebElement getAddStationtbtn() {
		return addStationtbtn;
	}
	

	public void LogoutformApp() throws InterruptedException {
		
		Profilebtn.click();
		Logoutbtn.click();
	}
	

}
