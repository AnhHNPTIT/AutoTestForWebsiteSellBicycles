package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.ChangePasswordScreen;


public class ChangePassword extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = ChangePasswordScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void MODULE6_01() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "12345678901234567890", "12345678901234567890", ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, "12345678901234567890", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}	

	@Test()
	public void MODULE6_02() throws IOException{
		ChangePasswordScreen.changePassword(driver, "", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.emptyOldPasswordMsg);
	}	
	
	@Test()
	public void MODULE6_03() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "", Constant.BASE_PASSWORD, ChangePasswordScreen.emptyNewPasswordMsg);
	}	
	
	@Test()
	public void MODULE6_04() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, "", ChangePasswordScreen.emptyNewPasswordConfirmMsg);
	}	

	@Test()
	public void MODULE6_05() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD + "1", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.notCorrectPasswordMsg);
	}	
	
	@Test()
	public void MODULE6_06() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, Constant.BASE_PASSWORD + "1", Constant.BASE_PASSWORD + "2", ChangePasswordScreen.notMatchPasswordMsg);
	}	
	
	@Test()
	public void MODULE6_07() throws IOException{
		ChangePasswordScreen.changePassword(driver, "1234567", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.invalidPasswordMsg);
	}	
	
	@Test()
	public void MODULE6_08() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "12345678901234567890", "12345678901234567890", ChangePasswordScreen.changePasswordSuccessMsg);
	}	
		
	@Test()
	public void MODULE6_09() throws IOException{
		ChangePasswordScreen.changePassword(driver, "12345678901234567890", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}
	
	@Test()
	public void MODULE6_10() throws IOException{
		ChangePasswordScreen.changePassword(driver, "123456789012345678901", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.invalidPasswordMsg);
	}	
	
	@Test()
	public void MODULE6_11() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "1234567", "1234567", ChangePasswordScreen.invalidPasswordMsg);
	}	
	
	@Test()
	public void MODULE6_12() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "87654321", "87654321", ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, "87654321", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}	
		
	@Test()
	public void MODULE6_13() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "12345678901234567890", "12345678901234567890", ChangePasswordScreen.changePasswordSuccessMsg);
		ChangePasswordScreen.changePassword(driver, "12345678901234567890", Constant.BASE_PASSWORD, Constant.BASE_PASSWORD, ChangePasswordScreen.changePasswordSuccessMsg);
	}
	
	@Test()
	public void MODULE6_14() throws IOException{
		ChangePasswordScreen.changePassword(driver, Constant.BASE_PASSWORD, "123456789012345678901", "123456789012345678902", ChangePasswordScreen.invalidPasswordMsg);
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
