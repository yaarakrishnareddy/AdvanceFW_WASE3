package VtigerGenericUtility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import TestNg.BaseClass;
import TestNg.Baseclass_1;

public class ListenersImplementation implements ITestListener {

	public void onTestStart(ITestResult result) {
	 String methodname=  result.getMethod().getMethodName();
	 System.out.println(methodname);
		
	}

	public void onTestSuccess(ITestResult result) {
		String methodname= result.getMethod().getMethodName();
     System.out.println(methodname);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wutil=new WebDriverUtility();
		JavaUtility jutil=new JavaUtility();
		String methodname=  result.getMethod().getMethodName();
		System.out.println(methodname);
	String ScreenName= methodname+" "+jutil.getSystemDateFormet();

			try {
				wutil.takeScreenShort(Baseclass_1.driver,ScreenName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
                   String methodname=result.getMethod().getMethodName()	;
                   System.out.println(methodname);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("SuiteExecution Strated");
	}

	public void onFinish(ITestContext context) {
		System.out.println("SuiteExecutionFinshed");
		
	}

}