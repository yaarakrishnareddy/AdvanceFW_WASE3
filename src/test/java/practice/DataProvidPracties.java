package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidPracties {
 @Test(dataProvider = "phone")
	public void adddata(String phone,int price)
	{
		System.out.println(phone+"---------"+price);
	}
 @DataProvider(name = "phone")
 public Object[][] getData()
 {
	 Object[][] data=new Object[3][2];
	 data[0][0]="iphone";
	 data[0][1]=100000;
	 data[1][0]="redmi";
	 data[1][1]=14000;
	 data[2][0]="sumsan";
	 data[2][1]=12000;
	 return data;
 }
}
