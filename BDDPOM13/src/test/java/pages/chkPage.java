package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//WebElement SuccessMsg = "Thank you for your order!";

public class chkPage {
	
	@FindBy(css="input[data-test='firstName']")
	WebElement frstName;
	
	@FindBy(css="input[data-test='lastName']")
	WebElement lastName;
	
	@FindBy(css="input[data-test='postalCode']")
	WebElement postCode;
	
	@FindBy(id="continue")
	WebElement cntBtn;
	
	@FindBy(css="button[data-test='finish']")
	WebElement finshBtn;
	
	@FindBy(css="button[data-test='cancel']")
	WebElement cnclBtn;
	@FindBy(css="h2.complete-header")
	WebElement successMsg;
	
	public chkPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ProvideDetails(String strFName, String strLName, String strPCode){
		frstName.sendKeys(strFName);
		lastName.sendKeys(strLName);
		postCode.sendKeys(strPCode);
		cntBtn.click();
	}
	public void checkOutOrder() {
		finshBtn.click();
	}
	public boolean isOrderSuccess() {
		return successMsg.isDisplayed();
	}
}