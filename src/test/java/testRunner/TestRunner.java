package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"//Users//rpkumar//IdeaProjects//SeleniumCucumber//Features//FilterSearch.feature", "//Users//rpkumar//IdeaProjects//SeleniumCucumber//Features//ProductSearch.feature"},
        glue = "stepDefinitions"

)
public class TestRunner {
}
