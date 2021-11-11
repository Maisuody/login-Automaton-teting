package mod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mian{
	static WebDriver driver;
   static String URL = "https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html";
   static String emailXpath= "//input[@id='email-input']";
   static String passwordXpath = "//input[@id='password-input']";
   static String loginXpath = "//button[@id='login-button']";
   static String DataPass = "password";
   
   
   
		
     
   @Test(priority = 1)
	public static void startBrowsing(String URL) {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Desktop\\chromedriver.exe");
		    driver = new ChromeDriver();		    
		    driver.get(URL);
		    
		   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	  }
   
   
	
   
   @Test(priority = 2)
	 public static void testLoginFormPresent() {
	      // below you can find already setup webDriver
	      boolean t1= false;
	      boolean t2 = false;
	      boolean t3 = false;

	      t1 = driver.findElement(By.id("email-input")).isDisplayed();
	      t2 =driver.findElement(By.id("password-input")).isDisplayed();
	      t3 = driver.findElement(By.id("login-button")).isDisplayed();
	      Assert.assertTrue(t1 && t2 && t3);  
	     System.out.println("seccess");
	    }
	 public static void valCredentials() {
	      String DataEmail = "login@codility.com";
	      driver.findElement(By.xpath(emailXpath)).sendKeys(DataEmail);
	      driver.findElement(By.xpath(passwordXpath)).sendKeys(DataPass);
	      driver.findElement(By.xpath(loginXpath)).click();
	      
	       List<WebElement> msg = driver.findElements(By.xpath("//div[@class='message success'][contains(text(), 'Welcome to Codility')]"));

	      	if(msg.isEmpty()) {
	   		   System.out.println("Test not passed");
	      	}else {
	   		   System.out.println("Test passed");
	      	}

	 }
	 
	  public static void inValidCredentials() {
		   String DataEmail = "unknown@codility.com";
		      driver.findElement(By.xpath(emailXpath)).sendKeys(DataEmail);
		      driver.findElement(By.xpath(passwordXpath)).sendKeys(DataPass);
		      driver.findElement(By.xpath(loginXpath)).click();
		      

		 List<WebElement> msg = driver.findElements(By.xpath("//div[@class='message error'][contains(text(), 'You shall not pass! Arr!')]"));

		      	if(msg.isEmpty()) {
		   		   System.out.println("Test not passed");
		      	}else {
		   		   System.out.println("Test passed");
		      	}
		   }

	  public static void emailValidationCredentials() {
		    String DataEmail = "unknowcodility.com";
		      driver.findElement(By.xpath(emailXpath)).sendKeys(DataEmail);
		      driver.findElement(By.xpath(passwordXpath)).sendKeys(DataPass);
		      driver.findElement(By.xpath(loginXpath)).click();

		   List<WebElement> msg = driver.findElements(By.xpath("//div[@class='validation error'][contains(text(), 'Enter a valid email')]"));

		      	if(msg.isEmpty()) {
		   		   System.out.println("Test not passed");
		      	}else {
		   		   System.out.println("Test passed");
		      	}

		   }
	  
	  public static void EmptyCredentials() {
	      driver.findElement(By.xpath(loginXpath)).click();
	      
	       List<WebElement> msg = driver.findElements(By.xpath("//div[@class='validation error'][contains(text(), 'Email is required')]"));
	  	 List<WebElement> msg1 = driver.findElements(By.xpath("//div[@class='validation error'][contains(text(), 'Password is required')]"));

	      	if(msg.isEmpty() && msg1.isEmpty()) {
	   		   System.out.println("Test not passed");
	      	}else {
	   		   System.out.println("Test passed");
	      	}


	   }
	 
	
	  /**
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startBrowsing( URL);
		//testLoginFormPresent();
		//valCredentials();
		//inValidCredentials();
		//emailValidationCredentials();
		EmptyCredentials();
	}
	
	
**/
}
