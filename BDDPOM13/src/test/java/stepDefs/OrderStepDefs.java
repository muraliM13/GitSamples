package stepDefs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cartPage;
import pages.chkPage;
import pages.LoginPage;
import pages.productListPage;


public class OrderStepDefs {
	WebDriver driver;
	LoginPage loginPage;
	productListPage listPage;
	cartPage CartPage;
	chkPage chkoutPage;
	public OrderStepDefs() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver); 	
		listPage = new productListPage(driver);
		CartPage = new cartPage(driver);
		chkoutPage = new chkPage(driver);
	}
	@Given("User is on login page")
		public void user_is_on_login_page() {
			TestBase.openUrl("https://www.saucedemo.com/");
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String strUsr, String strPwd) {
	    loginPage.LoginIntoApp(strUsr, strPwd);
	}
	@Then("User shold be on Home page")
	public void user_shold_be_on_home_page() {
	Assert.assertTrue(listPage.isOnProducts());
	}

	@Given("User is on cart page")
	public void user_is_on_cart_page() {
	    listPage.viewCart();
	}
	@When("User do checkout")
	public void user_do_checkout() {
	    CartPage.checkoutItem();
	}
	@Then("Should navigate to checkout page")
	public void should_navigate_to_checkout_page() {
		chkoutPage.ProvideDetails("test","usr","34645");
		chkoutPage.checkOutOrder();
		Assert.assertTrue(chkoutPage.isOrderSuccess());

	}
//	@Given("cart must have items")
//	public void cart_must_have_items() {
//		
//	}

}
