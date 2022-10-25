package testcases;

import org.openqa.selenium.WebDriver;

import webDriver.ChromeWebdriverClass;
import pages.PetClinic;
import  org.junit.Assert;
import org.junit.Test;
import org.junit.Assert;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.*;

public class TestCasePets {

	

	public static  ChromeWebdriverClass testwebdriver = new ChromeWebdriverClass();
	public static 	WebDriver driver = testwebdriver.createWebdriver();
	public static PetClinic petClinicPage= new PetClinic(driver);
	
	String CSV_PATH="C:\\Users\\u724763\\Documents\\csv\\owner.csv";
	
	private CSVReader csvReader;
	String[] csvCell;
	
	@BeforeClass
	public static void SetUp()
	{   
		//ChromeWebdriverClass testwebdriver = new ChromeWebdriverClass();
	 
	    
		testwebdriver.openWebPage(driver);;
	 	
	}
	
	@AfterClass
	public static void quit()
	{   
	
	    
	 	testwebdriver.closeBrowser(driver);
	 	
	}

	@Test
	public  void validateImageOnHome()
	{
		
		//PetClinic clinicPage = new PetClinic(driver);
		
		boolean imageDisplayed = petClinicPage.getHomePageImagedisplayed();
		assertTrue(imageDisplayed);
	 }
	
	@Test
	public  void AddNewOwnerAndValidate()
	{
		 petClinicPage.selectAddownertab();
		 
		 try {
			csvReader = new CSVReader(new FileReader(CSV_PATH));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			while((csvCell = csvReader.readNext()) !=null){
				 String firstName=csvCell[0];
				 String lastName = csvCell[1];
				 String address = csvCell[2];
				 String city = csvCell[3];
				 String telephone = csvCell[4];
			
				 petClinicPage.AddOwner(firstName,lastName,address,city,telephone);
				String FullName = firstName+" "+lastName;
				 assertEquals(FullName, petClinicPage.getAddedName());
				 assertEquals(address, petClinicPage.getAddedAddress());
				 assertEquals(city, petClinicPage.getCity());
				 assertEquals(telephone, petClinicPage.getTelephone());
				 
				 
				 
				 String petName=csvCell[5];
				 String petBirthdate=csvCell[6];
				 String pettype=csvCell[7];
				 
				 
				 //add pet details
				 petClinicPage.EnterPetDetails(petName,petBirthdate,pettype);
				 assertEquals(petName,petClinicPage.getPetName());
				 assertEquals(petBirthdate,petClinicPage.getpetBirthDate());
				 assertEquals(pettype,petClinicPage.getPetType());
			 }
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
	
}


