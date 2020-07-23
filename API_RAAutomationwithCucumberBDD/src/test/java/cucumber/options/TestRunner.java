package cucumber.options;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/auto1/features",plugin ="json:target/jsonReports/cucumber-report.json",glue= {"com.auto1.stepDefinitions"})
public class TestRunner {

}
