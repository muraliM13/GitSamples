package stepDefs;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageStepDef {
WebDriver driver;
	
	@Given("User is on Login Page")
	public void user_is_on_home_page() {
		String strBrowser = "chrome";
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		}
		//driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 driver.get("https://the-internet.herokuapp.com/login");		  
	}
//	//hardcoded
//	@When("User enters credentials")
//	public void user_enters_credentials() {
//		driver.findElement(By.id("username")).sendKeys("tomsmith");
//		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
//		driver.findElement(By.className("radius")).click();
//		
//	}
	//user enters creds Parameterisation and Scenario Outline
//	@When("User enters {string} and {string}")
//	public void user_enters_and(String strUsr, String strPwd) {
//		driver.findElement(By.id("username")).sendKeys(strUsr);
//		driver.findElement(By.id("password")).sendKeys(strPwd);
//		driver.findElement(By.className("radius")).click();
//		
//	}
//	@Then("Should Display success message")
//	public void should_display_sussess_message()	{
//		boolean isUserValid = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
//		Assert.assertTrue(isUserValid);
//	}
//	
	
	//DataTable
//		@When("User enters credentials")
//		public void user_enters_credentials(DataTable usrData) {
//			List<List<String>> data = usrData.asLists();
//			String strUsr = data.get(0).get(0);
//			String strPwd = data.get(0).get(1);
//			driver.findElement(By.id("username")).sendKeys(strUsr);
//			driver.findElement(By.id("password")).sendKeys(strPwd);
//			driver.findElement(By.className("radius")).click();
//		}
//	@Then("Should Display success message")
//	public void should_display_sussess_message(DataTable usrData)	{
//		List<String> msgList = usrData.asList();
//		String strMsg = msgList.get(0);	
//		boolean isUservalid = driver.findElement(By.xpath("//div[contains(text(),'"+strMsg+"')]")).isDisplayed();
//		Assert.assertTrue(isUservalid);
//	}
//	
	//DataTable using Maps
			@When("User enters credentials")
			public void user_enters_credentials(DataTable usrData) {
				List<Map<String, String>> data = usrData.asMaps();
				String strUsr = data.get(0).get("username");
				String strPwd = data.get(0).get("password");
				driver.findElement(By.id("username")).sendKeys(strUsr);
				driver.findElement(By.id("password")).sendKeys(strPwd);
				driver.findElement(By.className("radius")).click();
			}
		@Then("Should Display success message")
		public void should_display_sussess_message(DataTable usrData)	{
			List<String> msgList = usrData.asList();
			String strMsg = msgList.get(0);	
			boolean isUservalid = driver.findElement(By.xpath("//div[contains(text(),'"+ strMsg +"')]")).isDisplayed();
			Assert.assertTrue(isUservalid);
		}
		
	
	
}
