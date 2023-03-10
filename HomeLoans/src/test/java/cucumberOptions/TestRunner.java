package cucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features", glue="stepDefinationEligibility",
monochrome=true,tags="@Eligibility")
public class TestRunner extends AbstractTestNGCucumberTests{

}
