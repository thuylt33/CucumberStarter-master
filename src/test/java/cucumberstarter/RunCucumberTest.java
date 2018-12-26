package cucumberstarter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty","html:target\\HtmlReport" },
		features= "src\\test\\resources\\cucumberstarter\\fontMaster.feature",tags = {"@tag"},
		monochrome = true, glue = "stepdefinitions")//, dryRun=true
public class RunCucumberTest {
}