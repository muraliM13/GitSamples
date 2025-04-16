package testScripts;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import pages.productListPage;
import pages.cartPage;
import pages.chkPage;
public class PlaceOrderTest {
	WebDriver driver;
	LoginPage loginPage;
	productListPage listPage;
	cartPage CartPage;
	chkPage chkoutPage;
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver); 	
		listPage = new productListPage(driver);
		CartPage = new cartPage(driver);
		chkoutPage = new chkPage(driver);
	}
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://www.saucedemo.com/");
		loginPage.LoginIntoApp("standard_user", "secret_sauce");
	}
  @Test (priority=1)
  public void validLoginTest() {
	  listPage.addItemToCart();
	  listPage.viewCart();
	  Assert.assertTrue(CartPage.isItemsAdded());
	  
  }
  @Test (priority=2)
  public void checkoutItems() {
	  CartPage.checkoutItem();
	  chkoutPage.ProvideDetails("Murali","one","123456");
	  chkoutPage.checkOutOrder();
	  Assert.assertTrue(chkoutPage.isOrderSuccess());
  }
  
  @AfterTest
  public void tearDown() {
	  
  }
}
