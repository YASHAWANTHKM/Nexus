package ObjectRepositoryClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriver_Utility.WebDriver_UtilityClass;

public class Staion_details_Page extends WebDriver_UtilityClass {

	WebDriver driver;

	public Staion_details_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "name")
	private WebElement nametextfield;

	@FindBy(xpath = "//div[@id='company']")
	private WebElement companyDropDown;

	@FindBy(id = "address1")
	private WebElement addressTextfield1;

	@FindBy(id = "address2")
	private WebElement addressextfield2;

	@FindBy(id = "postalCode")
	private WebElement postalCodeTextfield;

	@FindBy(id = "lat")
	private WebElement latitudetextfield;

	@FindBy(id = "lng")
	private WebElement longitudetextfield;

	@FindBy(id = "maximumPower")
	private WebElement maximumPowerTextfield;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement publishCheckbox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addStationbtncreating;

	@FindBy(xpath = "//li[text()='Test 1']")
	private WebElement Testoption;

	public WebElement getTestoption() {
		return Testoption;
	}

	public WebElement getNametextfield() {
		return nametextfield;
	}

	public WebElement getCompanyDropDown() {
		return companyDropDown;
	}

	public WebElement getAddressTextfield1() {
		return addressTextfield1;
	}

	public WebElement getAddressextfield2() {
		return addressextfield2;
	}

	public WebElement getPostalCodeTextfield() {
		return postalCodeTextfield;
	}

	public WebElement getLatitudetextfield() {
		return latitudetextfield;
	}

	public WebElement getLongitudetextfield() {
		return longitudetextfield;
	}

	public WebElement getMaximumPowerTextfield() {
		return maximumPowerTextfield;
	}

	public WebElement getPublishCheckbox() {
		return publishCheckbox;
	}

	@FindBy(xpath = "(//button[contains(@class, 'MuiButtonBase-root')])[8]")
	private WebElement Editicon;

	public WebElement getEditicon() {
		return Editicon;
	}
	@FindBy(xpath = "//button[text()='Update Station']")
	private WebElement updatebutton;

	public WebElement getupdatebutton() {
		return updatebutton;
	}
	

	public void Edit_Name(String Name) throws InterruptedException {
		getEditicon().click();
		getNametextfield().sendKeys(Keys.COMMAND + "a");
		getNametextfield().sendKeys(Keys.DELETE);
		getNametextfield().sendKeys(Name);
		getupdatebutton().click();

	}

}
