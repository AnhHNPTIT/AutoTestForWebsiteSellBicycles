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
import CommonScreen.ContactScreen;


public class Contact extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = ContactScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void MODULE1_01() throws IOException{
		ContactScreen.contact(driver, "MODULE1_01", "0978478178", "test@gmail.com", "test", "");
	}	

	@Test()
	public void MODULE1_02() throws IOException{
		ContactScreen.contact(driver, "", "0978478178", "test@gmail.com", "test", ContactScreen.emptyNameMsg);
	}	
	
	@Test()
	public void MODULE1_03() throws IOException{
		ContactScreen.contact(driver, "MODULE1_03", "", "test@gmail.com", "test", ContactScreen.emptyPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_04() throws IOException{
		ContactScreen.contact(driver, "MODULE1_04", "0978478178", "test@gmail.com", "test", "");
	}	

	@Test()
	public void MODULE1_05() throws IOException{
		ContactScreen.contact(driver, "MODULE1_05", "01234567890", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_06() throws IOException{
		ContactScreen.contact(driver, "MODULE1_06", "0978 478 178", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_07() throws IOException{
		ContactScreen.contact(driver, "MODULE1_07", "(@#$%^*~/\\,|).", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_08() throws IOException{
		ContactScreen.contact(driver, "MODULE1_08", "0000000000", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_09() throws IOException{
		ContactScreen.contact(driver, "MODULE1_09", "abcdefghij", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE1_10() throws IOException{
		ContactScreen.contact(driver, "MODULE1_10", "0978478178", "", "test", "");
	}	
	
	@Test()
	public void MODULE1_11() throws IOException{
		ContactScreen.contact(driver, "MODULE1_11", "0978478178", "(@#$%^*~/\\,|).", "test", ContactScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE1_12() throws IOException{
		ContactScreen.contact(driver, "MODULE1_12", "0978478178", "testgmail.com", "test", ContactScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE1_13() throws IOException{
		ContactScreen.contact(driver, "MODULE1_13", "0978478178", "test@gmailcom", "test", ContactScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE1_14() throws IOException{
		ContactScreen.contact(driver, "MODULE1_14", "0978478178", "te st@gmail.com", "test", ContactScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE1_15() throws IOException{
		ContactScreen.contact(driver, "MODULE1_15", "0978478178", " test@gmail.com ", "test", "");
	}	
	
	@Test()
	public void MODULE1_16() throws IOException{
		ContactScreen.contact(driver, "MODULE1_16", "0978478178", "test@gmail.com", "", ContactScreen.emptyContentMsg);
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
