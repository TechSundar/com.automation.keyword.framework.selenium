package testScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import supportlibraries.CraftTestCase;
import supportlibrariesbackend.FrameworkParameters;

public class TC_01_VerifyLogin_the_application extends CraftTestCase{
	
	
	@Test
	public void executeTest() {
		FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
		String currentTestcase = frameworkParameters.getInstance().getCurrentTestCase();
		String checkStatus = frameworkParameters.getExecuteStatus(currentTestcase);
		if(checkStatus.equalsIgnoreCase("Yes")) {			
			System.out.println("Hello, you are executing the testcase");
			ExtentTest logger = extent.createTest(currentTestcase);
			//testParameters.
			
			
		}
		
		
	}
	
	
//	@DataProvider(name="testparameters", parallel=true)
//	public Object[][] dataTC1(){		
//		String browser = getCraftProperty("browser");
//		return new Object[][] {};
//	}
	
	
	
}
