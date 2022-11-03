package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class LoginScreen {
	// List of fields in Login screen
	// Text field
	public static String phoneTxtID				= "phone-number";
	public static String passwordTxtID			= "loginPassword";
	// Button
	public static String loginBtnXpath			= "//button[@class='btn-green btn-login']";
	
	// Error message
	public static String phoneErrMsgXpath 		= "//div[@class='input-phone-feedback']//p";
	public static String passwordErrMsgXpath 	= "//div[@class='input-password-feedback']//p";
	public static String errorMsgXpath 			= "//div[@class='input-feedback']//p";
	
	// List of messages
	public static String emptyPhoneMsg			= "Thông tin này là bắt buộc. Vui lòng nhập đầy đủ.";
	public static String emptyPasswordMsg		= "Thông tin này là bắt buộc. Vui lòng nhập đầy đủ.";
	public static String invalidPhoneMsg		= "Số điện thoại không hợp lệ, vui lòng thử lại.";
	public static String invalidPasswordMsg		= "Số điện thoại hoặc mật khẩu không đúng";
	public static String incorrectPhoneMsg		= "Số điện thoại chưa được đăng kí tài khoản";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
//			Utilities.waitForElementClickable(driver, By.xpath(HomeScreen.loginLinkXpath), Constant.WAIT_CLICKABLE);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, LoginScreen.loginBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void login(WebDriver driver, String phone, String password, String expectErrMsg) {
		Utilities.waitForElementVisibility(driver, By.id(LoginScreen.phoneTxtID));
		if (phone == "(@#$%^*~/\\,|)." || phone == "abcdefghij") {
			Utilities.inputValueAndValidate(driver, By.id(LoginScreen.phoneTxtID), phone, "");
		}
		else {
			Utilities.inputValueAndValidate(driver, By.id(LoginScreen.phoneTxtID), phone, phone.replace(" ", ""));
		}
		Utilities.inputValueAndValidate(driver, By.id(LoginScreen.passwordTxtID), password, password);
		if (expectErrMsg == "") {
			Utilities.clickObscuredElement(driver, By.xpath(LoginScreen.loginBtnXpath), By.xpath(HomeScreen.usernameLinkXpath), Constant.WAIT_ELEMENT_EXIST*3);
		}
		else if (password == "") {
			Utilities.clickObscuredElement(driver, By.xpath(LoginScreen.loginBtnXpath), By.xpath(LoginScreen.passwordErrMsgXpath), Constant.WAIT_ELEMENT_EXIST*3);
			Utilities.assertTextValue(driver, By.xpath(LoginScreen.passwordErrMsgXpath), expectErrMsg);		
		}
		else if (expectErrMsg == LoginScreen.emptyPhoneMsg || expectErrMsg == LoginScreen.invalidPhoneMsg) {
			Utilities.clickObscuredElement(driver, By.xpath(LoginScreen.loginBtnXpath), By.xpath(LoginScreen.phoneErrMsgXpath), Constant.WAIT_ELEMENT_EXIST*3);
			Utilities.assertTextValue(driver, By.xpath(LoginScreen.phoneErrMsgXpath), expectErrMsg);
		}
		else {
			Utilities.clickObscuredElement(driver, By.xpath(LoginScreen.loginBtnXpath), By.xpath(LoginScreen.errorMsgXpath), Constant.WAIT_ELEMENT_EXIST*3);
			Utilities.assertTextValue(driver, By.xpath(LoginScreen.errorMsgXpath), expectErrMsg);
		}
	}	
}
