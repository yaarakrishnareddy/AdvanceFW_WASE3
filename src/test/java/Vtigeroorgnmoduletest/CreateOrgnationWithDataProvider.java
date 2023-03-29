package Vtigeroorgnmoduletest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNg.BaseClass;
import TestNg.Baseclass_1;
import Vtiger.ObjectRepo.CreateOrgPage;
import Vtiger.ObjectRepo.Homepage;
import Vtiger.ObjectRepo.NeworgPage;
import Vtiger.ObjectRepo.OrgInfomPage;

@Listeners(VtigerGenericUtility.ListenersImplementation.class)
public class CreateOrgnationWithDataProvider extends Baseclass_1{

	@Test(dataProvider =  "company")

	public void createOrgnationWithData() throws InterruptedException, IOException
	{
       String  org=  eutil.getreadExcelSheet("Org", 1, 2);
		Homepage hm=new Homepage(driver);
		hm.clickOnOrgLink();
		NeworgPage np=new NeworgPage(driver);
		np.getOrglookupimg();
		Thread.sleep(4000);
		CreateOrgPage cp=new CreateOrgPage(driver);
		cp.createOrgPage(org);
		OrgInfomPage oi=new OrgInfomPage(driver);
	    String com=	oi.orgInfor();
	Assert.assertTrue(com.contains(org));
	}
	@DataProvider(name="company")
 public Object[][] getData() throws IOException
 {
	 Object[][] data=eutil.getDataProvied("Multi");
	 
	         return data;
 }
}
