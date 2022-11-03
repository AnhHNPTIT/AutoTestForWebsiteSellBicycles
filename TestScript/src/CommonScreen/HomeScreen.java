package CommonScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Common.Constant;
import Common.Utilities;

public class HomeScreen {
	public static String loginLinkXpath 			= "//*[@class='btn btn-login-register']";
	public static String usernameLinkXpath 			= "//*[contains(text(),'" + Constant.BASE_USERNAME + "')]";
	public static String logoutLinkXpath 			= "//header/div[1]/div[1]/div[1]/div[3]/div[3]/div[1]/div[1]/a[7]";
	
	public static WebDriver openScreen(String browser) {
		WebDriver driver = null;
		if (!browser.isEmpty()) {
			driver = Utilities.getDriver(browser);
			driver.get(Constant.BASE_URL);
			Utilities.waitForElementClickable(driver, By.xpath(HomeScreen.loginLinkXpath), Constant.WAIT_CLICKABLE);
		}
		return driver;
	}
}
