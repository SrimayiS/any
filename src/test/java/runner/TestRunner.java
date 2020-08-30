package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "./src/test/resources/Login.feature"
,glue = {"stepDefinition"}
,dryRun = false
,tags = "@functional or @smoke"

		)
public class TestRunner {

}
