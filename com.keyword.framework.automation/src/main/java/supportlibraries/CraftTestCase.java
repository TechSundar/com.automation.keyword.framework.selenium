package supportlibraries;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.PropertiesConfigurationLayout;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import supportlibrariesbackend.ExcelDataManagerSS;
import supportlibrariesbackend.FrameworkParameters;

public abstract class CraftTestCase{
	FrameworkParameters frameworkParameters = FrameworkParameters.getInstance();
	//FrameworkParameters frameworkParameters = new FrameworkParameters();
	//TestParameter testparameters;
	protected Map<String, String> TestRunManager;
	public static ExtentReports extent;
	public ExtentSparkReporter htmlreporter;
	
	
	@BeforeSuite(alwaysRun=true)
	public void setUpTestSuite(ITestContext testContext){
		ExcelDataManagerSS.initialize_relativePath();
		TestRunManager = ExcelDataManagerSS.getRunInfo();	    
	    FrameworkParameters.getInstance().setRunmanager(TestRunManager);
//	    System.out.println("Runnable test classes: " + runnableTests);
//	    System.out.println("@Before suite ends");
		String xmlfile =testContext.getCurrentXmlTest().getSuite().getFileName();
		Path path=Paths.get(xmlfile);
		String Suitename = (String) testContext.getSuite().getName();
		System.out.println(path.getFileName());
		System.out.println("Suitename "+Suitename);
	}
	
	
	@BeforeMethod(alwaysRun = true)
	public void setCurrentTestCaseName() { 
	    String currentTestcase = this.getClass().getSimpleName();
	    FrameworkParameters.getInstance().setCurrentTestCase(currentTestcase);
	  
//	    System.out.println(">>> Current Test Case: " + currentClass);
//	    System.out.println("@Before method ends");
	}
	
	
	
	public String getCraftProperty(String propertyName) {

		String propertyFilePath = frameworkParameters.getRelativePath()+"/Global Settings.properties"; 
		PropertiesConfiguration config = new PropertiesConfiguration();
		PropertiesConfigurationLayout layout= new PropertiesConfigurationLayout(config);			
		String proValue="";

		try { 
			layout.load(new InputStreamReader(new FileInputStream(propertyFilePath)));
			if(config.containsKey(propertyName)) {
				proValue = config.getProperty(propertyName).toString().trim();

				if(!proValue.equalsIgnoreCase(System.getProperty(propertyName))& System.getProperty(propertyName)!=null & proValue !=null) {
					config.setProperty(propertyName, System.getProperty(propertyName));

					layout.save(new FileWriter(propertyFilePath, false)); 
					layout.load(new InputStreamReader(new FileInputStream(propertyFilePath))); 
					proValue = config.getProperty(propertyName).toString().trim();

					//System.setProperty (propertyName, proValue);
				
				}

		} } catch (Exception e) { 
			e.printStackTrace();
		}

		

		return proValue.trim();

		
	}
	
	
	
	
	

}
