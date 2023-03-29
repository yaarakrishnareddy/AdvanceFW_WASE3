package VtigerContactTest;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestNg.Baseclass_1;

import Vtiger.ObjectRepo.ContactInfo1Page;
import Vtiger.ObjectRepo.CreateContactPage;
import Vtiger.ObjectRepo.Homepage;

import Vtiger.ObjectRepo.NewContactLookupimgPage;

public class CreateContacttest extends Baseclass_1
{@Test

	public void Createcontact() throws IOException, InterruptedException 
	{
		String con=eutil.getreadExcelSheet("Customer", 1, 2);
		String Org=eutil.getreadExcelSheet("Org", 1, 2);
		
		Homepage hp=new Homepage(driver) ;
		hp.clcikOnContactLink();
		NewContactLookupimgPage nc=new NewContactLookupimgPage(driver);
		nc.newContactLookupImg();
		CreateContactPage cc=new CreateContactPage(driver);
		cc.createContactPage(driver, con,Org );
		wutil.switchToWindow(driver, Org);
		ContactInfo1Page ci=new ContactInfo1Page(driver);
		String s=ci.infoCon();
		Assert.assertTrue(s.contains(con));
		}
}
	
	
	

	