package supportlibrariesbackend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

public class FrameworkParameters {//implements IMethodInterceptor{
	

    private static final FrameworkParameters FRAMEWORK_PARAMETERS = new FrameworkParameters();
    private Map<String, String> runnableTests;
    private List<String> runnableTests1;
    private String currentTestCase;
    private String relativePath;
    private FrameworkParameters() {
        // Private constructor to enforce singleton
    }

    public static FrameworkParameters getInstance() {
        return FRAMEWORK_PARAMETERS;
    }

    // ====== Runnable Tests ======
    public void setRunnableTests(List<String> runnableTests1) {
        this.runnableTests1 = runnableTests1;
    }
    public List<String> getRunnableTests() {
        return runnableTests1;
    }

    public void setRunmanager(Map<String, String> runnableTests) {
        this.runnableTests = runnableTests;
    }

    public Map<String, String> getRunmanager() {
        return runnableTests;
    }
    public void setRelativePath(String path) {
    	this.relativePath=path;
    }
    public String getRelativePath() {

		String path = new File(System.getProperty("user.dir")).getAbsolutePath();
		if (path.contains("supportlibraries")) {
			path = new File(System.getProperty("user.dir")).getParent();
		}
	
    	return path;
    }
    public static void initialize_relativePath() {
		String path = new File(System.getProperty("user.dir")).getAbsolutePath();
		if (path.contains("supportlibraries")) {
			path = new File(System.getProperty("user.dir")).getParent();
		}
	}

    // ====== Current Test Case ======
    public String getCurrentTestCase() {
        return currentTestCase;
    }

    public void setCurrentTestCase(String currentTestCase) {
        this.currentTestCase = currentTestCase;
    }
    
    public String getExecuteStatus(String currentTestcase) {
		String status=null;
		Map<String,String>map = ExcelDataManagerSS.getRunInfo();
		for(Map.Entry<String,String>newMap: map.entrySet()){
			if(newMap.getKey().contains(currentTestcase)) {
				status=newMap.getValue();
				break;
			}
			
		}
		return status;
	}
    

//	 @Override
//	  public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
//		 	System.out.println("Triggered interceptor "+context.getSuite().getName());
//		 	System.out.println("Total methods "+methods.size());
//	        List<IMethodInstance> result = new ArrayList<>();
//	        //List<String> runnableTests = FrameworkParameters.getInstance().getRunnableTests();
//	        Map<String, String> runnableTests = FrameworkParameters.getInstance().getRunmanager();
//		    
//	        for (IMethodInstance method : methods) {
//	            String className = method.getMethod().getTestClass().getRealClass().getSimpleName();
//	            for(Map.Entry<String,String>entry:runnableTests.entrySet()) {
//	            	if(entry.getKey().contains(className)) {
//	            		result.add(method);
//	            	}
//	            }
////	            if (runnableTests.contains(className)) {
////	                result.add(method);
////	            }
//	        }
//	        //return result;
//	        System.out.println("intercept ends");
//			return result;
//	    }
	
    
    
    
    
}