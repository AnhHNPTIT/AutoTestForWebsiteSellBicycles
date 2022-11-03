package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;
import CommonScreen.LoginScreen;


public class Login extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = LoginScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void MODULE1_01() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
	}	

	@Test()
	public void MODULE1_02() throws IOException{
		LoginScreen.login(driver, "", Constant.BASE_PASSWORD, LoginScreen.emptyPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_03() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
	}	
	
	@Test()
	public void MODULE1_04() throws IOException{
		LoginScreen.login(driver, "01234567890", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}	

	@Test()
	public void MODULE1_05() throws IOException{
		LoginScreen.login(driver, "0978 478 178", Constant.BASE_PASSWORD, "");
	}	
	
	@Test()
	public void MODULE1_06() throws IOException{
		LoginScreen.login(driver, "(@#$%^*~/\\,|).", Constant.BASE_PASSWORD, LoginScreen.emptyPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_07() throws IOException{
		LoginScreen.login(driver, "0000000000", Constant.BASE_PASSWORD, LoginScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_08() throws IOException{
		LoginScreen.login(driver, "abcdefghij", Constant.BASE_PASSWORD, LoginScreen.emptyPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_09() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, "", LoginScreen.emptyPasswordMsg);
	}	
	
	@Test()
	public void MODULE1_10() throws IOException{
		LoginScreen.login(driver, "0978478100", Constant.BASE_PASSWORD, LoginScreen.incorrectPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_11() throws IOException{
		LoginScreen.login(driver, Constant.BASE_PHONE, "123456789", LoginScreen.invalidPasswordMsg);
	}	
	
	@Test()
	public void MODULE1_12() throws IOException{
		LoginScreen.login(driver, "0978478100", "123456789", LoginScreen.incorrectPhoneMsg);
	}	
	
	@AfterMethod()  
	public void tearDownMethod(ITestResult result, Method method){
		afterMethod(result, method);
		if (method.getName() == "MODULE1_01" || method.getName() == "MODULE1_03" || method.getName() == "MODULE1_05") {
			Utilities.clickObscuredElement(driver, HomeScreen.usernameLinkXpath, HomeScreen.logoutLinkXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElementToNotVisible(driver, By.xpath(HomeScreen.logoutLinkXpath), By.xpath(HomeScreen.logoutLinkXpath), Constant.WAIT_ELEMENT_NOT_EXIST);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, LoginScreen.loginBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		}
	}
	
	@AfterClass()
	public void tearDownClass() throws Exception{	
		Utilities.closeDriver(driver);
	}
}
