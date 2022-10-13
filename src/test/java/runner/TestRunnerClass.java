package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//if you want to run all scenarios, leave the tags as null (i.e., tags="")
//purposefully failed two test cases (in order to pass all test cases: Change the locators for WebElements such as GmailLink and ImagesLink from 'css' to 'partialLinkText').

@RunWith(Cucumber.class)
@CucumberOptions(
				//plugin = {"pretty", "html:test-output/HtmlReport/cucumber-reports.html"},
				plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
				monochrome=true,
				dryRun=false,
				tags = (""), 
				features = "src\\test\\java\\features", 
				glue = "definitons"
				)
public class TestRunnerClass{

}
