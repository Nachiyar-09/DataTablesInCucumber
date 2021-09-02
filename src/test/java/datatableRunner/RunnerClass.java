package datatableRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features"
		,glue={"com.stepDefinitions"},
				 monochrome= true,
                 plugin={"com.cucumber.listener.ExtentCucumberFormatter:target/html/ExtentReport.html"})
		

public class RunnerClass {

	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig(new File("src/test/resources/configs-extent.xml"));
	//Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
	Reporter.setSystemInfo("User Name", "AJ");
	Reporter.setSystemInfo("Application Name", "Test App ");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Production");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
}
