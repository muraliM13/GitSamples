package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//src//test//resources//features//", // give particular feature file name to run alone or it will run all the files in the project  
		glue = {"stepDefs"},
		monochrome = true,
		dryRun = false,	//if true then it will not open chrome/any browser, it will just run the code and provides result,      if false it will execute all the code
		plugin = {"pretty",
				"html:target/Reports/HtmlReport.html",
				//"usage:target/Reports/UsageReport",
				//"json:target/Reports/JsonReport.json",
				//"rerun:target/FailedScenarios.txt"	//to rerun the test methos where the execution failed
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"   //faid scenario image to be added in extentrepost of html
		}
		)

public class BookSearchRunner extends AbstractTestNGCucumberTests {

	@DataProvider(parallel=true)
	//to run list of users getting method from AbstractTestNGCucumberTests
	public Object[][] scenarios(){
	return super.scenarios();
	}
	
}
