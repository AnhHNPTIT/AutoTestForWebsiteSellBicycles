package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class ChangePasswordScreen {
	public static String oldPasswordTxtID 				= "oldPassword";
	public static String newPasswordTxtID 				= "newPasswordChange";
	public static String newPasswordConfirmTxtID 		= "newPasswordConfirm";
	public static String updateBtnXpath					= "//button[contains(text(),'Cập nhật')]";
	public static String validateMsgXpath 				= "//div[contains(@class,'alert-message-error')][INDEX]//p";
	public static String msgOnDlgXpath 					= "//div[contains(@class,'swal-text')]";
	public static String emptyOldPasswordMsg 			= "Mật khẩu cũ là bắt buộc";
	public static String emptyNewPasswordMsg 			= "Mật khẩu mới là bắt buộc";
	public static String emptyNewPasswordConfirmMsg 	= "Nhập lại mật khẩu mới là bắt buộc";
	public static String invalidPasswordMsg 			= "Mật khẩu phải có độ dài từ 8 đến 20 ký tự";
	public static String notMatchPasswordMsg 			= "Mật khẩu mới không khớp";
	public static String notCorrectPasswordMsg 			= "Mật khẩu cũ không đúng";
	public static String changePasswordSuccessMsg 		= "Cập nhật mật khẩu thành công";

	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, HomeScreen.loginLinkXpath, Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
			Utilities.clickObscuredElement(driver, By.id(HomeScreen.dropdownMenuBtnID), By.xpath(HomeScreen.accountMntLinkXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.accountMntLinkXpath), By.xpath(HomeScreen.changePasswordLinkXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.changePasswordLinkXpath), By.xpath(ChangePasswordScreen.updateBtnXpath), Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void changePassword(WebDriver driver, String oldPassword, String newPassword, String newPasswordConfirm, String expectErrMsg) {
		Utilities.inputValueAndValidate(driver, By.id(oldPasswordTxtID), oldPassword, oldPassword);
		Utilities.inputValueAndValidate(driver, By.id(newPasswordTxtID), newPassword, newPassword);
		Utilities.inputValueAndValidate(driver, By.id(newPasswordConfirmTxtID), newPasswordConfirm, newPasswordConfirm);
		Utilities.click(driver, By.xpath(updateBtnXpath));
		if (expectErrMsg.equals(changePasswordSuccessMsg) || expectErrMsg.equals(notCorrectPasswordMsg)) {
			Utilities.assertTextValueVisible(driver, By.xpath(msgOnDlgXpath), expectErrMsg);
		}
		else if (expectErrMsg.equals(emptyOldPasswordMsg) || oldPassword.length() < 8 || oldPassword.length() > 20) {
			Utilities.assertTextValueVisible(driver, By.xpath(validateMsgXpath.replace("INDEX", "1")), expectErrMsg);
		}
		else if (expectErrMsg.equals(emptyNewPasswordMsg) || newPassword.length() < 8 || newPassword.length() > 20) {
			Utilities.assertTextValueVisible(driver, By.xpath(validateMsgXpath.replace("INDEX", "2")), expectErrMsg);
		}
		else if (expectErrMsg.equals(emptyNewPasswordConfirmMsg) || newPasswordConfirm.length() < 8 || newPasswordConfirm.length() > 20 || expectErrMsg.equals(notMatchPasswordMsg)) {
			Utilities.assertTextValueVisible(driver, By.xpath(validateMsgXpath.replace("INDEX", "3")), expectErrMsg);
		}
		if (expectErrMsg.equals(changePasswordSuccessMsg)) {
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, HomeScreen.loginLinkXpath, Constant.WAIT_ELEMENT_EXIST);
			if (newPasswordConfirm.equals("12345678901234567890") || newPasswordConfirm.equals("87654321")) {
				LoginScreen.login(driver, Constant.BASE_PHONE, newPasswordConfirm, "");
			}
			else {
				LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
			}
			Utilities.clickObscuredElement(driver, By.id(HomeScreen.dropdownMenuBtnID), By.xpath(HomeScreen.accountMntLinkXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.accountMntLinkXpath), By.xpath(HomeScreen.changePasswordLinkXpath), Constant.WAIT_ELEMENT_EXIST);
			Utilities.clickObscuredElement(driver, By.xpath(HomeScreen.changePasswordLinkXpath), By.xpath(ChangePasswordScreen.updateBtnXpath), Constant.WAIT_ELEMENT_EXIST);
		}
	}
}
