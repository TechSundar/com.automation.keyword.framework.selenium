package supportlibrariesbackend;

public class TestParameters {
	private final String currentTestcase;
	private final String currentBrowser;
	private String currentTestInstance;
	private int startIteration;
	private int endIteration;
	
	public TestParameters(String currentTestcase, String currentBrowser, String currentTestInstance) {
		this.currentTestcase = currentTestcase;
		this.currentBrowser = currentBrowser;
		this.currentTestInstance = currentTestInstance;
		this.currentTestInstance = "Instance1";
		
	}
	public String getCurrentTestcase(){
		return currentTestcase;
	}
	public String getCurrentBrowser(){
		return currentBrowser;
	}
	public String getCurrentTestInstance(){
		return currentTestInstance;
	}
	public void setCurrentTestInstance(String currentTestInstance){
		this.currentTestInstance=currentTestInstance;
	}
	

}
