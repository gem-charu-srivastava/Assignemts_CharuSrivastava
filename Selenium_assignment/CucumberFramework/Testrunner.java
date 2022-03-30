package Cucumberoptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/Login4.feature",
        glue = "stepdefinitions",
        monochrome = true,
          tags= "@SmokeTest")

public class Testrunner {

}
