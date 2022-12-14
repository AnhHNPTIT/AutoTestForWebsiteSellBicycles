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
	
	public static String msgOnDlgXpath 				= "//div[contains(@class,'swal-text')]";
	public static String emailTxtID 				= "email-input";
	public static String registerBtnXpath 			= "//button[contains(text(),'Đăng ký')]";
	public static String registerSuccessMsg 		= "Cảm ơn bạn đã đăng ký nhận thông báo";
	public static String invalidEmailMsg 			= "Email không đúng định dạng!";
	public static String emptyEmailMsg 				= "Vui lòng nhập email của bạn";
	
	public static String dropdownMenuBtnID 			= "dropdownMenuButton";
	public static String accountMntLinkXpath 		= "//header/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/a[1]";
	public static String changePasswordLinkXpath 	= "//h2[contains(text(),'Đổi mật khẩu')]";
	
	
	public static String categoryProductLinkXpath 	= "//div[contains(@class,'category-products-item')][INDEX]";
	public static String productLinkXpath 			= "//body/div[4]/div[3]/div[2]/div[2]/div[INDEX]/div[1]";
	public static String addToCartBtnXpath 			= "//body/div[4]/div[1]/div[2]/div[2]/div[5]/button[1]";
	public static String orderNowBtnXpath 			= "//button[contains(text(),'Mua ngay')]";
	public static String orderBtnXpath 				= "//button[contains(text(),'Đặt hàng')]";
	public static String quantityProductLbXpath 	= "//span[contains(@class,'bag-amount')]";
	
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
	
	public static void register(WebDriver driver, String email, String expectErrMsg) {
		if (email.lastIndexOf(" ") != email.length() - 1) {
			Utilities.inputValueAndValidate(driver, By.id(emailTxtID), email, email);
		}
		else {
			Utilities.inputValueAndValidate(driver, By.id(emailTxtID), email, email.replace(" ", ""));
		}
		Utilities.clickObscuredElement(driver, registerBtnXpath, msgOnDlgXpath, Constant.WAIT_ELEMENT_EXIST);
		Utilities.assertTextValueVisible(driver, By.xpath(msgOnDlgXpath), expectErrMsg);
	}
}
