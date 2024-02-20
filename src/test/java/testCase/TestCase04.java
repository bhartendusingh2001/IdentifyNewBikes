package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectClass.LoginSignUp;
import testBase.BaseClass;
import utilites.ScreenShot;

public class TestCase04 extends BaseClass {
	
	@Test(groups= {"smoke","regression", "master"})
	public void loginsignup() throws InterruptedException, IOException {
		logger.info("*****  Starting  TestCase04  *****");
		ScreenShot ss = new ScreenShot();
		LoginSignUp ls = new LoginSignUp(driver);
		logger.info("Click on ZigWheels Logo");
		ls.clickOnLogo();
		ss.screenshot(driver, "ClickOnLogoSS");
		logger.info("Click on Login Button");
		ls.loginbutton();
		ss.screenshot(driver, "LoginButtonSS");
		logger.info("Click on Google");
		ls.clickOnGoogle();
		ss.screenshot(driver, "ClickOnGoogleSS");
		logger.info("Now switch to child window");
		ls.switchToWindow();
		
		logger.info("*****  Finished TestCase04 *****");	
	}
}
