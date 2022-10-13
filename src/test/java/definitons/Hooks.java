package definitons;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.BaseClass;
import utils.GenericFunctions;

public class Hooks extends BaseClass {
	
	BaseClass bc=new BaseClass();
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	Scenario scenario;
	public ExtentTest logger;
	
	@Before
	public void setUp(Scenario scenario) throws InterruptedException, IOException, Exception {

		BaseClass.launchBrowser();
		this.scenario=scenario;
		//if((new File(screenshotdir)).exists())FileUtils.cleanDirectory(new File(screenshotdir));
		
	}
	
	/*
	 * @AfterStep public void captureScreenshotOnEachStep (Scenario scenario) throws
	 * IOException { //scenario.attach(GenericFunctions.getByteScreenshot(),
	 * "image/png", screenshotdir); }
	 */
	
	@After
	public void teardown(Scenario scenario) throws Exception {	
		if (scenario.isFailed()) {
		scenario.attach(GenericFunctions.getByteScreenshot(), "image/png", screenshotdir);
		//scenario.log("screenshot attached");
	}
		tearDown();
}
}