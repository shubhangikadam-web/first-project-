package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClasses.Base1;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class VerifyUserCanLogin {
	
	
static WebDriver driver;
	
	LoginPage lp;
	HomePage hp;
	
	
	@BeforeClass
	@Parameters("browser")
	public void beforeClass(String browser) throws IOException {
		driver = Base1.getDriver(browser);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
	}
	
	
	@Test
	public void test1() throws InterruptedException, IOException {
		lp.enterEmailID();	
		
		lp.enterPassword();
		lp.clickOnSubmitBtn();
		
		String profileName = hp.getProfileName();
		
		Assert.assertEquals(profileName, "Bhuvanesh","Profile name is not matching");
		

	}
	
	@AfterMethod
	public void afterMethod(){
		
	}
	
	
	@AfterClass
	public void afterClass() {
		
	}

}
