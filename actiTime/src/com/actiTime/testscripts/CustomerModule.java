package com.actiTime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actTime.pom.HomePage;
import com.actTime.pom.TaskListPage;
import com.actiTime.generic.BaseClass;
import com.actiTime.generic.FileLib;
 
@Listeners(com.actiTime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass {
	@Test
	public void testCustomerModule() throws EncryptedDocumentException, IOException, InterruptedException {
	Reporter.log("create customer",true);
	FileLib f=new FileLib();
	String expectedCustName=f.getExcelData("create customer", 1, 2);
	String custDescp = f.getExcelData("create customer", 1, 3);
	HomePage h=new HomePage(driver);
	Thread.sleep(2000);
	h.setTasktab(null);
	Thread.sleep(2000);
	TaskListPage t=new TaskListPage(driver);
	t.getAddNewBtn().click();
	t.getNewCustomerBtn().click();
	Thread.sleep(2000);
	t.getCustomerNameTbx().sendKeys(expectedCustName);
	
	t.getCustomerDescriptionTbx().sendKeys(custDescp);
	t.getSelectCustomerDD().click();
	t.getOurCompanyOption().click();
	t.getCreateCustomerBtn().click();
	Thread.sleep(4000);
	
	

}
}
