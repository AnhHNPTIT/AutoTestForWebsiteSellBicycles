package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Initialization;
import Common.Utilities;
import CommonScreen.UpdateAccountScreen;


public class UpdateAccount extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = UpdateAccountScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void MODULE7_01() throws IOException{
		UpdateAccountScreen.updateAccount(driver, "test", "test1@gmail.com", "test", UpdateAccountScreen.updateAccountSuccessMsg);
	}	

	@Test()
	public void MODULE7_02() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, null, null, UpdateAccountScreen.updateAccountSuccessMsg);
	}	
	
	@Test()
	public void MODULE7_03() throws IOException{
		UpdateAccountScreen.updateAccount(driver, "", null, null, UpdateAccountScreen.emptyUsernameMsg);
	}	
	
	@Test()
	public void MODULE7_04() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, "", null, UpdateAccountScreen.updateAccountSuccessMsg);
	}	

	@Test()
	public void MODULE7_05() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, null, "", UpdateAccountScreen.emptyAddressMsg);
	}	
	
	@Test()
	public void MODULE7_06() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, "test@gmail.com", null, UpdateAccountScreen.updateAccountSuccessMsg);
	}	
	
	@Test()
	public void MODULE7_07() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, "test@gmail.com", null, UpdateAccountScreen.updateAccountSuccessMsg);
	}	
	
	@Test()
	public void MODULE7_08() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, "(@#$%^*~/\\\\,|).", null, UpdateAccountScreen.invalidEmailMsg);
	}	
		
	@Test()
	public void MODULE7_09() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, "testgmail.com", null, UpdateAccountScreen.invalidEmailMsg);
	}
	
	@Test()
	public void MODULE7_10() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, "test@gmailcom", null, UpdateAccountScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE7_11() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, "te st@gmail.com", null, UpdateAccountScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE7_12() throws IOException{
		UpdateAccountScreen.updateAccount(driver, null, "  test@gmail.com   ", null, UpdateAccountScreen.updateAccountSuccessMsg);
	}	
				
	@AfterMethod()  
	public void tearDownMethod(ITestResult result, Method method){
		afterMethod(result, method);
		Utilities.refreshScreen(driver);
	}
	
	@AfterClass()
	public void tearDownClass() throws Exception{	
		Utilities.closeDriver(driver);
	}
}
