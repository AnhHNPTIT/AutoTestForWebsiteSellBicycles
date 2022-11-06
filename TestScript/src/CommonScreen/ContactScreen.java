package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class ContactScreen {
	// List of fields in Contact screen
	// Text field
	public static String nameTxtID				= "feedbackName";
	public static String phoneTxtID				= "feedbackPhoneNumber";
	public static String emailTxtID 			= "feedbackEmail";
	public static String contentTxtID 			= "feedbackContent";
	
	// Button
	public static String contactBtnXpath		= "//button[contains(text(),'Gửi phản hồi')]";
	
	// Error message
	public static String nameErrMsgXpath 		= "//div[@class='fb-input-name-feedback']//p";
	public static String phoneErrMsgXpath 		= "//div[@class='fb-input-phone-feedback']//p";
	public static String emailErrMsgXpath 		= "//div[@class='fb-input-email-feedback']//p";
	public static String contentErrMsgXpath 	= "//div[@class='fb-input-content-feedback']//p";
	
	// List of messages
	public static String emptyNameMsg			= "Vui lòng nhập tên của bạn.";
	public static String emptyPhoneMsg			= "Vui lòng nhập số điện thoại của bạn.";
	public static String invalidPhoneMsg		= "Số điện thoại không hợp lệ, vui lòng thử lại.";
	public static String invalidEmailMsg		= "Email không đúng định dạng, vui lòng thử lại.";
	public static String emptyContentMsg		= "Vui lòng để lại lời nhắn của bạn.";
	public static String contactSuccessMsg 		= "Cảm ơn bạn đã để lại lời nhắn cho chúng tôi!";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.clickObscuredElement(driver, HomeScreen.loginLinkXpath, LoginScreen.loginBtnXpath, Constant.WAIT_ELEMENT_EXIST);
			LoginScreen.login(driver, Constant.BASE_PHONE, Constant.BASE_PASSWORD, "");
			Utilities.clickObscuredElement(driver, HomeScreen.contactLinkXpath, ContactScreen.contactBtnXpath, Constant.WAIT_ELEMENT_EXIST);
		}
		return driver;
	}
	
	public static void contact(WebDriver driver, String name, String phone, String email, String content, String expectErrMsg) {
		Utilities.inputValueAndValidate(driver, By.id(nameTxtID), name, name);
		Utilities.inputValueAndValidate(driver, By.id(phoneTxtID), phone, phone);
		if (email.lastIndexOf(" ") != email.length() - 1) {
			Utilities.inputValueAndValidate(driver, By.id(emailTxtID), email, email);
		}
		else {
			Utilities.inputValueAndValidate(driver, By.id(emailTxtID), email, email.replace(" ", ""));
		}
		Utilities.inputValueAndValidate(driver, By.id(contentTxtID), content, content);
		if (expectErrMsg == "") {
			Utilities.click(driver, By.xpath(contactBtnXpath));
			Utilities.assertElementNotVisible(driver, By.xpath(nameErrMsgXpath));
			Utilities.assertElementNotVisible(driver, By.xpath(phoneErrMsgXpath));
			Utilities.assertElementNotVisible(driver, By.xpath(emailErrMsgXpath));
			Utilities.assertElementNotVisible(driver, By.xpath(contentErrMsgXpath));
		}
		else if (expectErrMsg.equals(emptyNameMsg)) {
			Utilities.clickObscuredElement(driver, contactBtnXpath, nameErrMsgXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(nameErrMsgXpath), expectErrMsg);
		}
		else if (expectErrMsg.equals(emptyPhoneMsg) || expectErrMsg.equals(invalidPhoneMsg)) {
			Utilities.clickObscuredElement(driver, contactBtnXpath, phoneErrMsgXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(phoneErrMsgXpath), expectErrMsg);
		}
		else if (expectErrMsg.equals(invalidEmailMsg)) {
			Utilities.clickObscuredElement(driver, contactBtnXpath, emailErrMsgXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(emailErrMsgXpath), expectErrMsg);
		}
		else if (expectErrMsg.equals(emptyContentMsg)) {
			Utilities.clickObscuredElement(driver, contactBtnXpath, contentErrMsgXpath, Constant.WAIT_ELEMENT_EXIST);
			Utilities.assertTextValue(driver, By.xpath(contentErrMsgXpath), expectErrMsg);
		}
		Utilities.wait(Constant.WAIT_LOAD_SCREEN);
	}
	

}
