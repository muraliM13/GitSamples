package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
//import package pages;

public class LoginPage {
	@FindBy(id = "user-name")
	WebElement userId;
	@FindBy(name = "password")
	WebElement pwd;
	@FindBy(id = "login-button")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}
  //actions
	public void LoginIntoApp(String strUser, String strPwd) {
	  userId.sendKeys(strUser);
	  pwd.sendKeys(strPwd);
	  loginBtn.click();
	  
  }
}
