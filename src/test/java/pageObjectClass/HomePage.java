package pageObjectClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	//constructor
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
     
	//locators
	
	//location of New Bikes header
	@FindBy(linkText="New Bikes")
	WebElement NewBikes;
	
	//location of UpcomingBikes 
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li[5]/span")
	WebElement UpcomingBikes;
	
	//action methods
	//click on New Bikes Header
	public void newBikes() {
		Actions act = new Actions(driver);
		act.moveToElement(NewBikes).build().perform();
	}
	
	//Click on Upcoming Bikes
	public void upcomingBikes() {
		Actions act = new Actions(driver);
		act.moveToElement(UpcomingBikes).click().build().perform();
	}
	
}
