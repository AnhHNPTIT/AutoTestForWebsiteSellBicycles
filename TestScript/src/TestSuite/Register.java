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
import CommonScreen.HomeScreen;


public class Register extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = HomeScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void MODULE4_01() throws IOException{
		HomeScreen.register(driver, "", HomeScreen.emptyEmailMsg);
	}	

	@Test()
	public void MODULE4_02() throws IOException{
		HomeScreen.register(driver, "test@gmail.com", HomeScreen.registerSuccessMsg);
	}	
	
	@Test()
	public void MODULE4_03() throws IOException{
		HomeScreen.register(driver, "test@gmail.com", HomeScreen.registerSuccessMsg);
	}	
	
	@Test()
	public void MODULE4_04() throws IOException{
		HomeScreen.register(driver, "(@#$%^*~/\\\\,|).", HomeScreen.invalidEmailMsg);
	}	

	@Test()
	public void MODULE4_05() throws IOException{
		HomeScreen.register(driver, "testgmail.com", HomeScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE4_06() throws IOException{
		HomeScreen.register(driver, "test@gmailcom", HomeScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE4_07() throws IOException{
		HomeScreen.register(driver, "te st@gmail.com", HomeScreen.invalidEmailMsg);
	}	
	
	@Test()
	public void MODULE4_08() throws IOException{
		HomeScreen.register(driver, "  test@gmail.com   ", HomeScreen.registerSuccessMsg);
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
