package stepDefs;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	@BeforeAll
	public static void setupDriver() {
		TestBase.initDriver();
	}
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			WebDriver driver;
			TakesScreenshot screen = (TakesScreenshot)driver;
			byte[] img = screen.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img,"image/png","FailedScenarioImage");
		}
	}

}
