package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class UpdateAccountScreen {
	public static String usernameTxtID 					= "updateUsername";
	public static String emailTxtID 					= "updateEmail";
	public static String addressTxtID 					= "updateAddress";
	public static String saveBtnXpath					= "//button[contains(text(),'Lưu')]";
	public static String validateMsgXpath 				= "//div[contains(@class,'error-message')][INDEX]//p";
	public static String msgOnDlgXpath 					= "//div[contains(@class,'swal-text')]";
	public static String emptyUsernameMsg 				= "Vui lòng nhập tên của bạn.";
	public static String emptyAddressMsg	 			= "Vui lòng nhập địa chỉ của bạn.";
	public static String invalidEmailMsg 				= "Email không đúng định dạng, vui lòng thử lại.";
	public static String updateAccountSuccessMsg 		= "Cập nhật hồ sơ thành công";

	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, HomeScreen.loginLinkXpath, Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
			Utilities.clickObscuredElement(driver, By.id(HomeScreen.dropdownMenuBtnID), By.xpath(HomeScreen.accountMntLinkXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.accountMntLinkXpath), By.xpath(HomeScreen.changePasswordLinkXpath), Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void updateAccount(WebDriver driver, String username, String email, String address, String expectErrMsg) {
		if (username != null) {
			Utilities.inputValueAndValidate(driver, By.id(usernameTxtID), username, username);
		}
		if (email != null) {
			Utilities.inputValueAndValidate(driver, By.id(emailTxtID), email, email);
		}
		if (address != null) {
			Utilities.inputValueAndValidate(driver, By.id(addressTxtID), address, address);
		}
		Utilities.click(driver, By.xpath(saveBtnXpath));
		if (expectErrMsg.equals(updateAccountSuccessMsg)) {
			Utilities.assertTextValueVisible(driver, By.xpath(msgOnDlgXpath), expectErrMsg);
		}
		else if (expectErrMsg.equals(emptyUsernameMsg)) {
			Utilities.assertTextValueVisible(driver, By.xpath(validateMsgXpath.replace("INDEX", "1")), expectErrMsg);
		}
		else if (expectErrMsg.equals(invalidEmailMsg)) {
			Utilities.assertTextValueVisible(driver, By.xpath(validateMsgXpath.replace("INDEX", "2")), expectErrMsg);
		}
		else if (expectErrMsg.equals(emptyAddressMsg)) {
			Utilities.assertTextValueVisible(driver, By.xpath(validateMsgXpath.replace("INDEX", "4")), expectErrMsg);
		}
	}
}
