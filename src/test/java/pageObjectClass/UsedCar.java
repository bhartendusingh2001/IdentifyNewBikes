package pageObjectClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilites.ExcelUtility;
import utilites.JavaScriptManager;

public class UsedCar extends BasePage{

	public UsedCar(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	JavaScriptManager jsm = new JavaScriptManager();
	ExcelUtility excelutility = new ExcelUtility();
	
	//Locator
	
	//XPath of Used Car Header
	@FindBy(xpath="//a[@href='/used-car']")
	WebElement UsedCar;
	
	//XPath of Chennai 
	@FindBy(xpath="//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement Chennai;
	
	//XPath of BrandAndModel WebElement
	@FindBy(xpath="//span[normalize-space()='Brand and Model']")
	WebElement BrandAndModel_loc;
	
	//XPath of Checkboxes 
	@FindBy(xpath="//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li/label")
	List<WebElement> CheckBoxes; 
	
	//Action Method
	
	//ScrollUp to the top 
	public void scrollup()  {
		jsm.scrollUpPage(driver);
	}
	
	//Click on UsedCar
	public void usedCar() {
		Actions act = new Actions(driver);
		act.moveToElement(UsedCar).build().perform();
	}
	
	//Click on Chennai
	public void chennai() {
		Actions act = new Actions(driver);
		act.moveToElement(Chennai).click().build().perform();
	}
	
	//Fetching details of the cars
	public void clickCheckboxes() throws InterruptedException, IOException {
		System.out.println("Total Model Cars : "+ CheckBoxes.size());
		excelutility.setCellData("PopularModel", 0, 0, "Popular Model List");
		jsm.scrollDownTillElementPresent(driver, BrandAndModel_loc);
		int row = 1;
		for(WebElement checkbox : CheckBoxes) {
			try {
			    System.out.println(checkbox.getText());
			    excelutility.setCellData("PopularModel", row, 0, checkbox.getText());
			}catch(Exception e) {
				e.getStackTrace();
			}
			row++;
		}
	}
}