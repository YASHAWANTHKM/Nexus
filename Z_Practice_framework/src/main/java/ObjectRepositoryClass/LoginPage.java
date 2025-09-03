package ObjectRepositoryClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import WebDriver_Utility.WebDriver_UtilityClass;

public class LoginPage extends WebDriver_UtilityClass {

	
		WebDriver driver;
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements( driver,this);
		}
		@FindBy(id="email")
		private WebElement usernametextfield;
		@FindBy(id="password")
		private WebElement passwordtextfield;
		@FindBy(xpath ="//button[@type='submit']")
		private WebElement Loginbtn;
		
		
		
		public void LoginToApp(String url,String un,String pwd)
		{
			waitForPageToLoad(driver);
			driver.get(url);
			usernametextfield.sendKeys(un);
			passwordtextfield.sendKeys(pwd);
			Loginbtn.click();
		}
		
		

	}

	
	
	

