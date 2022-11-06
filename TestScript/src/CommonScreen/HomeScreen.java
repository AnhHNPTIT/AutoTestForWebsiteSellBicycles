package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class HomeScreen {
	public static String loginLinkXpath 			= "//*[@class='btn btn-login-register']";
	public static String usernameLinkXpath 			= "//*[contains(text(),'" + Constant.BASE_USERNAME + "')]";
	public static String logoutLinkXpath 			= "//header/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/a[7]";
	public static String contactLinkXpath 			= "//a[contains(text(),'Góp ý, phản hồi')]";
	public static String keywordTxtXpath 			= "//*[@class='keyword']";
	public static String searchIconXpath 			= "//*[@class='btn-search-func']";
	public static String titleSearchLbXpath 		= "//h1[contains(text(),'#KEYWORD')]";
	public static String searchResultDivXpath 		= "//*[@class='products-item-content']";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, LoginScreen.loginBtnXpath, Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
		}
		return driver;
	}

	public static void search(WebDriver driver, String keyword, boolean isSuccess) {
		Utilities.inputValueAndValidate(driver, By.xpath(keywordTxtXpath), keyword, keyword);
		Utilities.clickObscuredElement(driver, searchIconXpath, titleSearchLbXpath.replace("KEYWORD", keyword), Constant.WAIT_ELEMENT_EXIST);
		int countSearchResult =  Utilities.getXpathCount(driver, searchResultDivXpath);
		if (isSuccess) {
			if (countSearchResult == 0) {
				Utilities.assertFail(driver, "Search result is incorrect");
			}
		} 
		else {
			Utilities.assertString("0",Integer.toString(countSearchResult));
		}
	}
}
