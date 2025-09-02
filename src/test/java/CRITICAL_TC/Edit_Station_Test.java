package CRITICAL_TC;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseUtility.BaseClass;
import ObjectRepositoryClass.AddStationPage;
import ObjectRepositoryClass.HomePage;

@Listeners(ListenerUtility.ListenerImplementationclass.class)
public class Edit_Station_Test extends BaseClass {

	
	
	@Test
	public void Create_Station() throws Throwable {
	
		
		String stationName = elib.getDataFromExcel("sheet1", 1, 0)+jlib.getRandomNumber(100);
		String company = elib.getDataFromExcel("sheet1", 1, 1);
		String address = elib.getDataFromExcel("sheet1", 1, 2);
		String postalcode = elib.getDataFromExcel("sheet1", 1, 3);
		String latitude = elib.getDataFromExcel("sheet1", 1, 4);
		String longitude = elib.getDataFromExcel("sheet1", 1, 5);
		String maxpower = elib.getDataFromExcel("sheet1", 1, 6);
		HomePage hpp=new HomePage(driver);
		
		hpp.getStationtab().click();
		System.out.println("Tc end ");
		
			

	}

}
