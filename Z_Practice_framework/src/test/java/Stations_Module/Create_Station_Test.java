package Stations_Module;

import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import ObjectRepositoryClass.AddStationPage;
import ObjectRepositoryClass.HomePage;

//@Listeners(ListenerUtility.ListenerImplementationclass.class)
public class Create_Station_Test extends BaseClass {

	@Test
	public void add_Station() throws Throwable {

		String Name = elib.getDataFromExcel("Create_Stations", 1, 0);
		String Company = elib.getDataFromExcel("Create_Stations", 1, 1);
		String Address = elib.getDataFromExcel("Create_Stations", 1, 2);
		String PostalCode = elib.getDataFromExcel("Create_Stations", 1, 3);
		String latitude = elib.getDataFromExcel("Create_Stations", 1, 4);
		String longitude = elib.getDataFromExcel("Create_Stations", 1, 5);
		String MaxPower = elib.getDataFromExcel("Create_Stations", 1, 6);
		hp = new HomePage(driver);
		hp.getStationtab().click();
		hp.getAddStationtbtn().click();
		AddStationPage asp = new AddStationPage(driver);
		asp.addStationmethod(Name, driver, Company, Address, PostalCode, latitude, longitude, MaxPower);
		String actualmsg = hp.getConfirmationmsg().getText();
		Thread.sleep(5000);
		System.out.println(actualmsg);
		hardobj.hardAssertforboolean(actualmsg, "Your station has been created successfully");

	}

}
