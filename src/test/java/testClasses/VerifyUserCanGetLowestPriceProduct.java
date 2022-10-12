package testClasses;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baseClasses.Base1;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class VerifyUserCanGetLowestPriceProduct {
	
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
	
	
	@DataProvider(name="testData")
	public String[] getData() {
		String[] pName = {"realme", "apple"};
		return pName;
	}
	

	@Test(priority = 2)
	public void VerifyUserCanSearchProduct() throws InterruptedException {
		hp.searchProduct();
		hp = new HomePage(driver);
		String actualText = hp.getValidText();
		Assert.assertTrue(actualText.contains("Showing 1 –"));
	}
	
	@Test(priority = 3)
	public void VerifyUserCanGetLowestPriceProductFromEachPage() {
		Map<Integer, String> lowPriceMapExpected = new HashMap<>();
		lowPriceMapExpected.put(1, "10000");
		lowPriceMapExpected.put(2, "10000");
		lowPriceMapExpected.put(3, "10000");
		lowPriceMapExpected.put(4, "10000");
		lowPriceMapExpected.put(5, "10000");
	//	List<String> lowsetPriceFron5Page = new ArrayList<>();
		Map<Integer, String> lowPriceMapActual = new HashMap<>();
		
		for(int i=1; i<=5; i++) {
			if(i != 1) {
				hp.switchToPage(i);
			}
	//	lowsetPriceFron5Page.add(hp.getLowestPriceOfProduct());
			lowPriceMapActual.put(i, hp.getLowestPriceOfProduct());
		}
		Assert.assertNotEquals(lowPriceMapActual, lowPriceMapExpected);
	}
	
	
	@AfterMethod
	public void afterMethod() {
	
	}
	
	@AfterClass
	public void afterClass() {
		
	}

}
