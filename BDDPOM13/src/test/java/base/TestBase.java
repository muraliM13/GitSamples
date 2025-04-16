package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestBase{
	
	private static TestBase testBase;
	private static WebDriver driver;
	private TestBase() {
	String strBrowser = "chrome";
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--incognito");
	if(strBrowser.equalsIgnoreCase("chrome")) {
		driver = new ChromeDriver(options);
	}
	else if(strBrowser.equalsIgnoreCase("edge")){
		driver = new EdgeDriver();
	}
	driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	 driver.manage().deleteAllCookies();
  }
  @Test
  public static void initDriver() {
	  if(testBase==null) {
		  testBase= new TestBase();
	  }
  }
  public static WebDriver getDriver() {
	  return driver;
  }
  
  public static void openUrl(String url) {
	  driver.get(url);
  }
  public static void tearDown() {
	  if(driver!=null) {
		  driver.close();
		  driver.quit();
	  }
	  testBase=null;
  }
}
