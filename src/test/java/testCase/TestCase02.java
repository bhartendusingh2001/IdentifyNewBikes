package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectClass.UpcomingBikes;
import testBase.BaseClass;
import utilites.ScreenShot;

public class TestCase02 extends BaseClass{
	
	@Test(groups= {"regression", "master"})
	public void Run() throws InterruptedException, IOException {
		logger.info("*****  Starting TestCase02  *****");
		ScreenShot ss = new ScreenShot();
		UpcomingBikes mp = new UpcomingBikes(driver);
		ss.screenshot(driver, "UpcomingBikesPageSS");
		logger.info("Selecting Honda from Manufacturer Drop Down");
		mp.Manufacturerbutton();
		ss.screenshot(driver, "SelectingHondaSS");
		
		logger.info("Click on ViewMore Button");
		mp.viewMoreButton();
		ss.screenshot(driver, "ViewMoreButtonSS");
		
		logger.info("Get all bike details under 4 lakhs");
		mp.getBikeDetails();
		ss.screenshot(driver, "BikeDetailsSS");
		
		logger.info("*****  Finished TestCase02  *****");

	}	
}
