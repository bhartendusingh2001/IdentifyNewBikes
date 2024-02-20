package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObjectClass.HomePage;
import testBase.BaseClass;
import utilites.ScreenShot;

public class TestCase01 extends BaseClass{
	@Test(groups= {"smoke","regression","master"})
	public void Hover() throws  InterruptedException, IOException {
		
		logger.info("*****  Starting TestCase01  *****");
		ScreenShot ss = new ScreenShot();
		HomePage hp=new HomePage(driver);
		ss.screenshot(driver, "HomepageSS");
		logger.info("Go to New Bikes Header");
		hp.newBikes();
		ss.screenshot(driver, "NewBikesSS");
		
		Thread.sleep(2000);
		logger.info("Go to Upcoming Bikes");
		hp.upcomingBikes();
		ss.screenshot(driver, "UpcomingBikesSS");
		
		logger.info("*****  Finished TestCase01  *****");
		
	}

}
