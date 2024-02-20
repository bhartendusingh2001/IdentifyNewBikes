package pageObjectClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utilites.ExcelUtility;
import utilites.JavaScriptManager;


public class UpcomingBikes extends BasePage{

	public UpcomingBikes(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	ExcelUtility excelutility = new ExcelUtility();
	
	JavaScriptManager jsm = new JavaScriptManager();
	
	//locator
	
	//XPath ManufacturerDropDown
	@FindBy(xpath="//select[@id='makeId']")
	WebElement Manufacturerbutton ;
	
	//XPath of ViewMore Button
	@FindBy(xpath="//li[@class=\"txt-c clr moreModels mb-20\"]//span")
	WebElement viewMore;
	
	//XPath of LatestBike WebElement
	@FindBy(xpath="//a[@data-track-label=\"upcoming-bikes-under-5-lakhs\"]")
	WebElement latestBike_loc;
	
	//XPath of Bike Name 
	@FindBy(xpath="//a[@data-track-label=\"model-name\"]")
	List<WebElement> BikeName;
	
	//XPath of Bike Prices
	@FindBy(xpath="//li[contains(@class,'modelItem')]")
	List<WebElement> Bike_Price;
	
	//XPath of Launch Date
	@FindBy(xpath="//div[@class=\"clr-try fnt-14\"]")
	List<WebElement> Launch_Date;

	
	//Action Methods
	
	//Select Honda 
	public void Manufacturerbutton() {
		Select s=new Select(Manufacturerbutton);
		s.selectByVisibleText("Honda");
	}
	
	//Click on ViewMoreButton
	public void viewMoreButton() throws InterruptedException {
		
		    jsm.scrollDownTillElementPresent(driver, latestBike_loc);
		    Thread.sleep(3000);
		    jsm.clickBtn(driver, viewMore);
	}
	
	//Fetching the BikeDetails 
	public void getBikeDetails() throws IOException {
		excelutility.setCellData("BikeDetails", 0, 0, "BikeName");
		excelutility.setCellData("BikeDetails", 0, 1, "Price");
		excelutility.setCellData("BikeDetails", 0, 2, "LunchDate");
		int row = 1;
		for(int i = 0; i < BikeName.size(); i++) {
			String bikeName = BikeName.get(i).getText();
			String lunchDate = Launch_Date.get(i).getText();
			int price = Integer.parseInt(Bike_Price.get(i).getAttribute("data-price"));
			if(price < 400000) {
				System.out.println(bikeName +"\n" + price + "\n" + lunchDate);
				System.out.println("--------------------------------");
				excelutility.setCellData("BikeDetails", row, 0, bikeName);
				excelutility.setCellData("BikeDetails", row, 1, price+"");
				excelutility.setCellData("BikeDetails", row, 2, lunchDate);
				row++;
			}
		}
	}
}
