package practice;
import java.io.IOException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import TestNg.BaseClass;
import TestNg.Baseclass_1;
import Vtiger.ObjectRepo.ContactInfo1Page;
import Vtiger.ObjectRepo.CreateContactPage;
import Vtiger.ObjectRepo.Homepage;
import Vtiger.ObjectRepo.NewContactLookupimgPage;
import VtigerGenericUtility.ListenersImplementation;
@Listeners(ListenersImplementation.class)
public class ASStest extends Baseclass_1{
@Test(groups = "SmokeSuite")
	public void ASS_01() throws IOException {
		String contact=eutil.getreadExcelSheet("Customer", 1, 2);
		Homepage h=new Homepage(driver);
		h.clcikOnContactLink();
		Reporter.log("contacthomepageSuccessfull");
		NewContactLookupimgPage nc=new NewContactLookupimgPage(driver);
		nc.newContactLookupImg();
		Reporter.log("NewContactpageSuccessfully Created");
		CreateContactPage cc=new CreateContactPage(driver);
		cc.createcontactpage(contact+jutil.getRandomNumber());
		ContactInfo1Page c=new ContactInfo1Page(driver);
		Assert.fail();
	     String con= c.infoCon();
	     Assert.assertTrue(con.contains(contact));
     	System.out.println(con+"pass");
}
       @Test(groups = "SmokeSuite")
         public void demo()
  {
	System.out.println("demo1");
}
}
