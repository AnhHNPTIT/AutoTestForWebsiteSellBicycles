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
	public void MODULE3_01() throws IOException{
		ContactScreen.contact(driver, "MODULE3_01", "0978478178", "test@gmail.com", "test", "");
	}	

	@Test()
	public void MODULE3_02() throws IOException{
		ContactScreen.contact(driver, "", "0978478178", "test@gmail.com", "test", ContactScreen.emptyNameMsg);
	}	
	
	@Test()
	public void MODULE3_03() throws IOException{
		ContactScreen.contact(driver, "MODULE3_03", "", "test@gmail.com", "test", ContactScreen.emptyPhoneMsg);
	}	
	
	@Test()
	public void MODULE3_04() throws IOException{
		ContactScreen.contact(driver, "MODULE3_04", "0978478178", "test@gmail.com", "test", "");
	}	

	@Test()
	public void MODULE3_05() throws IOException{
		ContactScreen.contact(driver, "MODULE3_05", "01234567890", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE3_06() throws IOException{
		ContactScreen.contact(driver, "MODULE3_06", "0978 478 178", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE3_07() throws IOException{
		ContactScreen.contact(driver, "MODULE3_07", "(@#$%^*~/\\,|).", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE3_08() throws IOException{
		ContactScreen.contact(driver, "MODULE3_08", "0000000000", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE3_09() throws IOException{
		ContactScreen.contact(driver, "MODULE3_09", "abcdefghij", "test@gmail.com", "test", ContactScreen.invalidPhoneMsg);
	}	
	
	@Test()
	public void MODULE3_10() throws IOException{
		ContactScreen.contact(driver, "MODULE3_10", "0978478178", "", "test", "");
	}	
	
	@Test()
	public void MODULE3_11() throws IOException{
		ContactScreen.contact(driver, "MODULE3_11", "0978478178", "(@#$%^*~/\\,|).", "test", ContactScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE3_12() throws IOException{
		ContactScreen.contact(driver, "MODULE3_12", "0978478178", "testgmail.com", "test", ContactScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE3_13() throws IOException{
		ContactScreen.contact(driver, "MODULE3_13", "0978478178", "test@gmailcom", "test", ContactScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE3_14() throws IOException{
		ContactScreen.contact(driver, "MODULE3_14", "0978478178", "te st@gmail.com", "test", ContactScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE3_15() throws IOException{
		ContactScreen.contact(driver, "MODULE3_15", "0978478178", " test@gmail.com ", "test", "");
	}	
	
	@Test()
	public void MODULE3_16() throws IOException{
		ContactScreen.contact(driver, "MODULE3_16", "0978478178", "test@gmail.com", "", ContactScreen.emptyContentMsg);
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
