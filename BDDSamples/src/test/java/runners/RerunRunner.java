package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/FailedScenarios.txt",
		glue = {"stepDefs"},
		monochrome = true,
		plugin = {"pretty",
				"html:target/Reports/HtmlReport.html"
		}
		)

public class RerunRunner extends AbstractTestNGCucumberTests {

}

