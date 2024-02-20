package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectClass.UsedCar;
import testBase.BaseClass;
import utilites.ScreenShot;

public class TestCase03 extends BaseClass{
		
	@Test(groups= {"regression", "master"})
	public void Chennai() throws InterruptedException, IOException {
		logger.info("*****  Starting TestCase03  *****");
		ScreenShot ss = new ScreenShot();
		UsedCar uc = new UsedCar(driver);
		Thread.sleep(3000);
		logger.info("Scroll up to the top of the upcoming bikes page");
		uc.scrollup();
		Thread.sleep(3000);
		
		logger.info("Select Used Car header");
		uc.usedCar();
		Thread.sleep(3000);
		ss.screenshot(driver, "UsedCarHeaderSS");
		
		logger.info("Click on Chennai from Used Car drop down");
		uc.chennai();
		ss.screenshot(driver, "ClickChennaiSS");
		
		logger.info("Select all the CheckBoxes under the Popular Models ");
		uc.clickCheckboxes();
		
		logger.info("*****  Finished TestCase03  *****");

	}
}
