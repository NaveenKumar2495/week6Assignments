package week6.Assign.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/week6/Assign/Feature/LeafTaps.feature", 
glue ={"week6/Assign/Stepdefinition","week6/Assign/Hooks"}, publish=true , monochrome =true )




public class LeafTapsHooks extends AbstractTestNGCucumberTests {

}
