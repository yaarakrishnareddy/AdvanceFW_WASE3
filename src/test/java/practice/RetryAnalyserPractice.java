package practice;

import org.testng.annotations.Test;
public class RetryAnalyserPractice {
@Test(retryAnalyzer=VtigerGenericUtility.RetryAnaliser.class )
	public void Practice()
	{
	System.out.println("hi");
	}
}
