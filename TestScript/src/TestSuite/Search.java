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


public class Search extends Initialization{	
	@BeforeClass()
	public void setUpClass() throws Exception{	
		driver = HomeScreen.openScreen(browser);
	}
	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void MODULE2_01() throws IOException{
		HomeScreen.search(driver, "Xe đạp địa hình MTB Giant LIV TEMPT 3 29 inch Size M", true);
	}	

	@Test()
	public void MODULE2_02() throws IOException{
		HomeScreen.search(driver, "demo test", false);
	}	
	
	@Test()
	public void MODULE2_03() throws IOException{
		HomeScreen.search(driver, "xe đạp thể thao", true);
	}	
	
	@Test()
	public void MODULE2_04() throws IOException{
		HomeScreen.search(driver, "Xe đạp đua Sava Pro 6.0", true);
	}	

	@Test()
	public void MODULE2_05() throws IOException{
		HomeScreen.search(driver, "XE ĐẠP ĐUA SAVA PRO 6.0", true);
	}	
		
	@AfterMethod()  
	public void tearDownMethod(ITestResult result, Method method){
		afterMethod(result, method);
	}
	
	@AfterClass()
	public void tearDownClass() throws Exception{	
		Utilities.closeDriver(driver);
	}
}
