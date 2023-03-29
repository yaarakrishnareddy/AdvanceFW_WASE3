package practice;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestNg.Baseclass_1;
import Vtiger.ObjectRepo.ContactInfo1Page;
import Vtiger.ObjectRepo.CreateContactPage;
import Vtiger.ObjectRepo.CreateOrgPage;
import Vtiger.ObjectRepo.Homepage;

import Vtiger.ObjectRepo.NewContactLookupimgPage;
import Vtiger.ObjectRepo.NeworgPage;

import Vtiger.ObjectRepo.OrgInfomPage;


public class DemoContactWithOrgpomtest extends Baseclass_1 {
@Test
	public  void execut1() throws InterruptedException, IOException {
	String Org=eutil.getreadExcelSheet("Org",1 , 2);
	String Contact=eutil.getreadExcelSheet("Customer", 1, 2);
      Homepage h=new Homepage(driver);
      h.clickOnOrgLink();
      NeworgPage n=new NeworgPage(driver);
     n.neworgpage();
      CreateOrgPage cp=new CreateOrgPage(driver);
      cp.createOrgPage(Org+jutil.getRandomNumber(), "Banking");
      Thread.sleep(4000);
	OrgInfomPage o=new OrgInfomPage(driver);
	String s=o.orgInfor();
	Assert.assertTrue(s.contains(Org));
	System.out.println(s+"pass");
	/*if(s.contains(e))
			{
		System.out.println(s+"pass ino");
	}
	else
	{
		System.out.println(s+"fail");
	}*/
	Thread.sleep(4000);
      h.clcikOnContactLink();
      NewContactLookupimgPage nc=new NewContactLookupimgPage(driver);
      nc.newContactLookupImg();
  /*    CreateContactPage cc=new CreateContactPage(driver);
      cc.createcontactpage(e);*/
      CreateContactPage cc=new CreateContactPage(driver);
      cc.createContactPage(driver, Contact, Org);
      ContactInfo1Page con=new ContactInfo1Page(driver);
     String s1= con.infoCon();
     Assert.assertTrue(s1.contains(Contact));
     System.out.println(s1+"pass");

      
	}

}
