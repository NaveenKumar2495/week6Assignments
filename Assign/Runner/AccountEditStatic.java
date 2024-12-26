package week6.Assign.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/week6/Assign/Feature/AccountEdit.feature", glue ="week6/Assign/Stepdefinition", publish=true , monochrome =true )


public class AccountEditStatic extends AbstractTestNGCucumberTests {

}
