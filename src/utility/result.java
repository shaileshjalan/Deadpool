package utility;

import java.util.HashSet;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class result implements ITestListener {
	WebDriver driver;
	ExtentTest logger;
capturescreenshot cap=new capturescreenshot();

	@Override
	public void onFinish(ITestContext arg0){
	
	}
	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		if(ITestResult.FAILURE==result.getStatus()){
String name=capturescreenshot.capturescreen(driver,result.getName());
logger.log(LogStatus.FAIL, "invalid",logger.addScreenCapture(name));
		
		}
		 }
		


	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
