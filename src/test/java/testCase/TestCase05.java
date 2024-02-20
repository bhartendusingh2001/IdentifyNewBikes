package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectClass.LoginPage;
import testBase.BaseClass;
import utilites.ScreenShot;

public class TestCase05 extends BaseClass {
	@Test(groups= {"regression", "master"})
	public void verifyLoginPage() throws IOException, InterruptedException {
		
		logger.info("*****  Starting TestCase05 *****");
		ScreenShot ss = new ScreenShot();
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Send random emails into emailinputbox");	
		lp.setEmailInput();
		ss.screenshot(driver, "EmailInputSS");
		Thread.sleep(3000);
		
		logger.info("click on next button");
		lp.clickNextBtn();
		ss.screenshot(driver, "NextButtonSS");
		
		logger.info("Capturing the error message");
		lp.getErrorMsg();
		ss.screenshot(driver, "ErrorMessageSS");
		logger.info("*****  Finished TestCase05 *****");	
	}
}
