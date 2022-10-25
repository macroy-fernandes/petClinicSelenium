package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.opencsv.CSVReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PetClinic {
	
	
	
	private WebDriver driver;
	
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	
	
	//Image on Homepage
	 @FindBy(xpath = "//img[contains(@src,'pets.png')]")
	  private WebElement homePageImage;
	 
	 //Home button
	 @FindBy(xpath = "//a[contains(@title,'home')]")
	 private WebElement homeButton;
	 
	 
	 //findownsers button
	 @FindBy(xpath = "//a[contains(@title,'find owners')]")
	 private WebElement findOwners;
	 
	 
	 //Add owner button
	 @FindBy(xpath = "//a[contains(text(),'Add Owner')]")
	 private WebElement addOwners;
	 
	 //Add new pet
	 @FindBy(xpath = "//a[contains(text(),'Add')]")
	 private WebElement addNewPet;
	 
	 //pet name
	 @FindBy(xpath = "//input[@id='name']")
	 private WebElement petName; 
	 
	 //pet birth date
	 @FindBy(xpath = "//input[@id='birthDate']")
	 private WebElement petBirthDate; 
	 
	 //pet type
	 @FindBy(xpath = "//select[@id='type']")
	 private WebElement petType; 
	 
	//first name
	 @FindBy(xpath = "//input[@id='firstName']")
	 private WebElement firstName; 
	 
	 //last name
	 @FindBy(xpath = "//input[@id='lastName']")
	 private WebElement lastName; 
	 
	 //address
	 @FindBy(xpath = "//input[@id='address']")
	 private WebElement address; 
	 
	 //city
	 @FindBy(xpath = "//input[@id='city']")
	 private WebElement city; 
	 
	 //telephone
	 @FindBy(xpath = "//input[@id='telephone']")
	 private WebElement telephone; 
	 
	 //Submit
	 @FindBy(xpath = "//button[text()='Add Owner']")
	 private WebElement addOwner; 
	 
	//Search Owner
	 @FindBy(xpath = "//button[text()='Find Owner']")
	 private WebElement searchOwner; 

	 
	 //added full name
	 @FindBy(xpath = "//table[@class='table table-striped']//tr/th[text()='Name']/following-sibling::td")
	 private WebElement addedFullName;
	 
	//added address
	 @FindBy(xpath = "//table[@class='table table-striped']//tr/th[text()='Address']/following-sibling::td")
	 private WebElement addedAddress;
		 
	 //added city
	 @FindBy(xpath = "//table[@class='table table-striped']//tr/th[text()='City']/following-sibling::td")
	 private WebElement addedCity;
	
	 //added telephone
	 @FindBy(xpath = "//table[@class='table table-striped']//tr/th[text()='Telephone']/following-sibling::td")
	 private WebElement addedTelephone;
	 
	 
	 //added pet Name
	 @FindBy(xpath = "//tbody//dt[text()='Name']/following-sibling::dd[1]")
	 private WebElement addedPetname;
	 
	 //added pet birth date
	 @FindBy(xpath = "//tbody//dt[text()='Birth Date']/following-sibling::dd[1]")
	 private WebElement addedPetBirthDate;
	 
	//added pet Type
	 @FindBy(xpath = "//tbody//dt[text()='Type']/following-sibling::dd[1]")
	 private WebElement addedPetType;
		 
	
	 
	 public PetClinic(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
	 }

	public boolean getHomePageImagedisplayed() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		String title = driver.getTitle();
	    System.out.println(title); 
	    homeButton.click();
		return homePageImage.isDisplayed();
	}

	public void selectAddownertab() {
		// TODO Auto-generated method stub
		
		findOwners.click();
		
		
	}

	public void AddOwner(String firstName, String lastName, String address, String city, String telephone) {
		// TODO Auto-generated method stub
		addOwners.click();
		
	
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.address.sendKeys(address);
		this.city.sendKeys(city);
		this.telephone.sendKeys(telephone);
		this.addOwner.click();
		
	}

	public String getAddedName() {
		// TODO Auto-generated method stub
		return this.addedFullName.getText();
	}

	public String getAddedAddress() {
		// TODO Auto-generated method stub
		return this.addedAddress.getText();
	}

	public String getCity() {
		// TODO Auto-generated method stub
		return this.addedCity.getText();
	}

	public String getTelephone() {
		// TODO Auto-generated method stub
		return this.addedTelephone.getText();
	}

	public void EnterPetDetails(String petName, String petBirthdate, String pettype) {
		// TODO Auto-generated method stub
		
		this.addNewPet.click();
		
		this.petName.sendKeys(petName);
		this.petBirthDate.clear();
		this.petBirthDate.sendKeys(petBirthdate);

		//js.executeScript("arguments[0].value = arguments[1].value",
			//   driver.findElement(By.id("birthDate")), "22-10-2022");
		//WebElement element = driver.findElement(By.xpath("//input[@id='birthDate']")); 
		// js.executeScript("arguments[0].value='22-10-2022;",element);
		
		Select objSelect = new Select(this.petType);
		objSelect.selectByValue(pettype);
	}

	public String getPetName() {
		// TODO Auto-generated method stub
		return this.addedPetname.getText();
	}

	public String getpetBirthDate() {
		// TODO Auto-generated method stub
		return this.addedPetBirthDate.getText();
	}

	public String getPetType() {
		// TODO Auto-generated method stub
		return this.addedPetType.getText();
	}

	
	

}
