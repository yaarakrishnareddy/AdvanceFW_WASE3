package Vtigeroorgnmoduletest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNg.BaseClass;
import TestNg.Baseclass_1;
import Vtiger.ObjectRepo.CreateOrgPage;
import Vtiger.ObjectRepo.Homepage;
import Vtiger.ObjectRepo.NeworgPage;
import Vtiger.ObjectRepo.OrgInfomPage;
//@Listeners(VtigerGenericUtility.ListenersImplementation.class)
public class CreateOragnitionstest extends Baseclass_1{
@Test
	public void CreOrg() throws IOException, InterruptedException {
	String org=	eutil.getreadExcelSheet("Org", 1, 2);
	Homepage hp=new Homepage(driver);
	hp.clickOnOrgLink();
	NeworgPage np=new NeworgPage(driver);
	np.neworgpage();
	CreateOrgPage cp=new CreateOrgPage(driver);
	cp.createOrgPage(org+jutil.getRandomNumber());
	
	Thread.sleep(4000);
	OrgInfomPage oi=new OrgInfomPage(driver);
	String s=oi.orgInfor();
	Assert.assertTrue(s.contains(org));
	
		}
	
}
	