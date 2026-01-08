package testScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import supportlibraries.CraftTestCase;
import supportlibrariesbackend.FrameworkParameters;

public class TC_03_verifyuserAccout_in_the_application extends CraftTestCase{
	
	@Test
	public void executeTest() {
		FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
		String currentTestcase = frameworkParameters.getCurrentTestCase();
		frameworkParameters.getExecuteStatus(currentTestcase);		
		String checkStatus = frameworkParameters.getExecuteStatus(currentTestcase);
		if(checkStatus.equalsIgnoreCase("Yes")) {
			System.out.println("Hello, you are executing the testcase3");
		}
		else {
			System.out.println("test case 3 skipped");
		}
	}
		
}
	