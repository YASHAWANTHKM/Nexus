package ObjectRepositoryClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import JavaUtility.JavaUtilityClass;
import WebDriver_Utility.WebDriver_UtilityClass;

public class AddStationPage extends WebDriver_UtilityClass {
	JavaUtilityClass jlib = new JavaUtilityClass();
	WebDriver driver;
	WebDriver_UtilityClass wlib = new WebDriver_UtilityClass();

	public AddStationPage(WebDriver driver) {
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

	public WebElement getAddStationbtncreating() {
		return addStationbtncreating;
	}

	public void addStationmethod(WebDriver driver, String Name, String Company, String Address, String PostalCode,
			String latitude, String longitude, String MaxPower) throws InterruptedException {

		Thread.sleep(2000);
		nametextfield.sendKeys(Name);
		companyDropDown.click();
		Testoption.click();
		addressTextfield1.sendKeys(Address);
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 1000).perform();
		postalCodeTextfield.sendKeys(PostalCode);
		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		latitudetextfield.click();
		wlib.cleartextandsendtext(latitudetextfield, latitude);
		wlib.cleartextandsendtext(longitudetextfield, longitude);
		wlib.cleartextandsendtext(maximumPowerTextfield, MaxPower);

//		js.executeScript("document.getElementById('lat').value='" + latitude + "';");
//		Thread.sleep(1000);
//		longitudetextfield.click();
//		js.executeScript("document.getElementById('lng').value='" + longitude + "';");
//		Thread.sleep(10000);
//		maximumPowerTextfield.click();
//
//		js.executeScript("arguments[0].value='" + MaxPower + "'", maximumPowerTextfield);

		Thread.sleep(1000); // Wait for changes to take effect

		publishCheckbox.click();
		Thread.sleep(1000);
		//addStationbtncreating.click();

	}

}
