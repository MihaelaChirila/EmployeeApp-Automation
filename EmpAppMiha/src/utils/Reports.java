package utils;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports extends TestWatcher {

	protected static ExtentReports extent;
	protected static ExtentTest test;
	
	
	public static void createReport() {
		extent = new ExtentReports();
	
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\src\\ExtentreporterResults"+Dates.GetCurrentTime()+".html");
		
		extent.attachReporter(htmlReporter);	
	}
	public static void flushReports() {
		extent.flush();
	}
	
	@Override
	protected void succeeded(Description description) {
		test = extent.createTest(description.getDisplayName());
		
		for(String step: Logger.steps) {
			test.info(step);
		}
		
		if(Logger.verification.size() == 0) {
			test.log(Status.PASS, "PASSED! "+description.getDisplayName());
		}else {
			for(String ver : Logger.verification) {
				test.warning(ver);
		}
			test.log(Status.WARNING, "PASSED with WARNINGS! "+ description.getDisplayName());
		}
		
		flushReports();
	}
	
	@Override
	protected void failed(Throwable e, Description description) {
		test = extent.createTest(description.getDisplayName());
		
		for(String step: Logger.steps) {
			test.info(step);
		}
		
		for(String ver : Logger.verification) {
			test.warning(ver);
		}
		
		test.log(Status.FAIL, "FAIL from test: "+description.getDisplayName()+"Exeption"+e.toString());
		flushReports();
	}
}
