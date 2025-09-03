package Stations_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import ObjectRepositoryClass.AddStationPage;
import ObjectRepositoryClass.HomePage;
import ObjectRepositoryClass.Staion_details_Page;

//@Listeners(ListenerUtility.ListenerImplementationclass.class)
public class Edit_Statiion_Test extends BaseClass {

	@Test
	public void Edit_Station() throws Throwable {
		String Name = elib.getDataFromExcel("Create_Stations", 1, 0);
		hp = new HomePage(driver);
		hp.getStationtab().click();
		AddStationPage asp = new AddStationPage(driver);
		asp.getSearchtextfield().sendKeys(Name);
		WebElement searched_Station = driver.findElement(By.xpath("//p[text()='Automate Station_261edited]"));
		String serchedtext = searched_Station.getText();
		searched_Station.click();
		Staion_details_Page sdp = new Staion_details_Page(driver);

		sdp.Edit_Name(serchedtext);

	}

}
