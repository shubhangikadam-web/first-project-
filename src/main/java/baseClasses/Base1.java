package baseClasses;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilClasses.Util1;

public class Base1 {
	
	static WebDriver driver;

	public static WebDriver getDriver(String browser) throws IOException {
		
		if(driver == null) {
			
			if(browser.equals("chrome")) {
				
				WebDriverManager.chromedriver().setup();
				
			//	System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
				driver = new ChromeDriver();
			}else {
				
				WebDriverManager.firefoxdriver().setup();
				
			//	System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver.exe");
				
				driver = new FirefoxDriver();
			}
		
			
//			if(Util1.getConfigData("env").equals("qa")) {
//				driver.get("https://www.flipkartqa.com/");
//			}else if(Util1.getConfigData("env").equals("dev")) {
//				driver.get("https://www.flipkartdev.com/");
//			}
			
			driver.get("https://www.flipkart.com/");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
			
			
		}	
		return driver;
	}
	
	public static void unloadDriver() {
		driver = null;
	}

}
