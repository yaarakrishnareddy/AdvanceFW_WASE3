package practice;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNg.Baseclass_1;
import Vtiger.ObjectRepo.CreateOrgPage;
import Vtiger.ObjectRepo.Homepage;
import Vtiger.ObjectRepo.NeworgPage;
//import Vtiger.ObjectRepo.OrgInfom;
import Vtiger.ObjectRepo.OrgInfomPage;
import VtigerGenericUtility.ListenersImplementation;
@Listeners(ListenersImplementation.class)
public class ASS1_test extends Baseclass_1 {
@Test(groups = "RegrestionSuite")
	public void Ass_2() throws IOException, InterruptedException {
		String Org=eutil.getreadExcelSheet("Org", 1, 2);
		Homepage h=new Homepage(driver);
		h.clickOnOrgLink();
		NeworgPage n=new NeworgPage(driver);
		n.neworgpage();
		CreateOrgPage cr=new CreateOrgPage(driver);
		cr.createOrgPage(Org+jutil.getRandomNumber());
		Thread.sleep(4000);
		OrgInfomPage inf=new OrgInfomPage(driver);
		Assert.fail();
		String orgin=inf.orgInfor();
		Assert.assertTrue(orgin.contains(Org));
		System.out.println(Org+"pass");
		
	}
@Test(groups = "RegrestionSuite")
public void demo()
{
	System.out.println("demo");
}
}
