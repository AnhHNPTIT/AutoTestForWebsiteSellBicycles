package TestSuite;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Constant;
import Common.Initialization;
import Common.Utilities;
import CommonScreen.HomeScreen;


public class DetailInformation extends Initialization{	
	@BeforeMethod()
	public void setUpMethod(Method method) throws Exception{	
		driver = HomeScreen.openScreen(browser);
		Utilities.testID = method.getName();
	}
		
	@Test()
	public void MODULE5_01() throws IOException{
		Utilities.clickObscuredElement(driver, HomeScreen.categoryProductLinkXpath.replace("INDEX", "1"), HomeScreen.productLinkXpath.replace("INDEX", "1"), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.productLinkXpath.replace("INDEX", "1"), HomeScreen.orderNowBtnXpath, Constant.WAIT_ELEMENT_EXIST);
	}	

	@Test()
	public void MODULE5_02() throws IOException{
		Utilities.clickObscuredElement(driver, HomeScreen.categoryProductLinkXpath.replace("INDEX", "1"), HomeScreen.productLinkXpath.replace("INDEX", "1"), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.productLinkXpath.replace("INDEX", "1"), HomeScreen.orderNowBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.addToCartBtnXpath, HomeScreen.quantityProductLbXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.wait(Constant.WAIT_INTERVAL);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.quantityProductLbXpath), "1");
	}	
	
	@Test()
	public void MODULE5_03() throws IOException{
		Utilities.clickObscuredElement(driver, HomeScreen.categoryProductLinkXpath.replace("INDEX", "1"), HomeScreen.productLinkXpath.replace("INDEX", "1"), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.productLinkXpath.replace("INDEX", "2"), HomeScreen.orderNowBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.addToCartBtnXpath, HomeScreen.quantityProductLbXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.wait(Constant.WAIT_INTERVAL);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.quantityProductLbXpath), "2");
	}	
	
	@Test()
	public void MODULE5_04() throws IOException{
		Utilities.clickObscuredElement(driver, HomeScreen.categoryProductLinkXpath.replace("INDEX", "1"), HomeScreen.productLinkXpath.replace("INDEX", "1"), Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.productLinkXpath.replace("INDEX", "2"), HomeScreen.orderNowBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.clickObscuredElement(driver, HomeScreen.addToCartBtnXpath, HomeScreen.quantityProductLbXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.wait(Constant.WAIT_INTERVAL);
		Utilities.assertTextValueVisible(driver, By.xpath(HomeScreen.quantityProductLbXpath), "3");
	}	
	
	@AfterMethod()  
	public void tearDownMethod(ITestResult result, Method method){
		afterMethod(result, method);
		Utilities.closeDriver(driver);
	}
}
