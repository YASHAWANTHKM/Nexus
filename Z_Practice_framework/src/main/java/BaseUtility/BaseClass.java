package BaseUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import AssertUtility.HardAssertClass;
import AssertUtility.SoftAssertClass;
import FileUtility.ExcelUtilityClass;
import FileUtility.FileUtilityclass;
import JavaUtility.JavaUtilityClass;
import ObjectRepositoryClass.HomePage;
import ObjectRepositoryClass.LoginPage;
import UtilityClassObject.UtilityclassObjectClass;
import WebDriver_Utility.WebDriver_UtilityClass;

public class BaseClass {

	public WebDriver driver = null;

	public SoftAssertClass softobj = new SoftAssertClass();
	public HardAssertClass hardobj = new HardAssertClass();

	public WebDriver_UtilityClass wlib = new WebDriver_UtilityClass();
	public FileUtilityclass flib = new FileUtilityclass();
	public ExcelUtilityClass elib = new ExcelUtilityClass();
	public JavaUtilityClass jlib = new JavaUtilityClass();
	public static WebDriver sdriver;
	public HomePage hp;

	@BeforeSuite
	public void BeforeSuite() throws Throwable {

		System.out.println("executed BeforeSuite");

	}

	@Parameters("BROWSER")
	@BeforeClass
	public void BeforeClass(@Optional("chrome") String browser) throws Throwable {

		String BROWSER = System.getProperty("browser", browser);
		driver = wlib.browserselect(BROWSER);
		sdriver = driver;
		System.out.println("D:" + driver + " SD:" + sdriver);
		UtilityclassObjectClass.setDriver(driver);
		driver = UtilityclassObjectClass.getDriver();
		wlib.MaximiseBrowser(driver);
		wlib.waitForPageToLoad(driver);

		System.out.println("executed BeforeClass");
	}

	@BeforeMethod
	public void executeBefore() throws Throwable {

		String URL = System.getProperty("url", flib.getDataFromPropertiesFile("url"));
		String PWD = System.getProperty("pwd", flib.getDataFromPropertiesFile("pwd"));
		String UN = System.getProperty("un", flib.getDataFromPropertiesFile("un"));

		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(URL, UN, PWD);
		System.out.println("executed beforemethod");
	}

	@AfterMethod
	public void executeAfter() throws Throwable {
//		hp = new HomePage(driver);
//		hp.LogoutformApp();

		System.out.println("executed Aftermethod");
	}

	@AfterClass
	public void Afterclass() {
//		wlib.quitwindow(driver);

		System.out.println("executed Afterclass");
	}

	@AfterSuite
	public void AfterSuite() throws Throwable {

		System.out.println("executed AfterSuite");

	}

}
