package supportlibrariesbackend;

import com.aventstack.extentreports.ExtentTest;

public class SeleniumTestParameters extends TestParameters{
	
	//private Browser browser;
	private ExtentTest extentlog;
	
	public SeleniumTestParameters(String currentTestcase, String currentBrowser, String currentTestInstance) {
		super(currentTestcase,currentBrowser,currentTestInstance);
	}
	
	public void setExtentreport(ExtentTest logger) {
		this.extentlog=logger;
	}
	
	public ExtentTest getExtentlog() {
		return this.extentlog;
	}

}
