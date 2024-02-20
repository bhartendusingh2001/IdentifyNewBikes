package pageObjectClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginSignUp extends BasePage{

	public LoginSignUp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators 
	
	//XPath for Logo 
	@FindBy(xpath="//a[@class='zw i-b mt-10 pt-2 zw-srch-logo']")
	WebElement logo_loc ;
		
	//XPath for Login Button
	@FindBy(xpath="//div[@id='forum_login_wrap_lg']")
	WebElement loginBtn_loc;
	
	//XPath for Google Login WebElement
	@FindBy(xpath="//div[@class=\"lgn-sc c-p txt-l pl-30 pr-30 googleSignIn\"]")
	WebElement loginWithGoogle_loc;
			
	//Actions	
	//Click on Zigwheels Logo
	public void clickOnLogo(){	
		logo_loc.click();
	}
			
	//Click on Login Button
	public void loginbutton() {
		loginBtn_loc.click();
	}
	
	//Click on Google 
	public void clickOnGoogle()
	{
		loginWithGoogle_loc.click();	
	}
	
	//Switch to Child WIndow 
	public void switchToWindow()
	{
		Set<String> windowIds = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windowIds);
		
		String childWindowId = windowsList.get(1);
		
		// Switch to child Window
		driver.switchTo().window(childWindowId);
		
	}
	
	

	
}
