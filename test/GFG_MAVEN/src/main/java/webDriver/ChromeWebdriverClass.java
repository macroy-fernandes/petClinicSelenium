package webDriver;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;



public class ChromeWebdriverClass {
	
	private  WebDriver driver;
	
	public WebDriver  createWebdriver() {
		
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();   
	    driver.manage().window().maximize();
		return driver;

	}

	public void openWebPage(WebDriver driver) {
		// TODO Auto-generated method stub
		
		driver.get("http://localhost:8080/");
	}
	
	public void closeBrowser(WebDriver driver) {
		driver.quit();  
	}


	
}
