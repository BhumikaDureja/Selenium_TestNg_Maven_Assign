package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.ExtentTest;

import testcases.BaseClass;

public class LoginPageClass {
	
	
 WebDriver driver = BaseClass.driver;
 ExtentTest test = BaseClass.test;
	

	
//============================== Web Elements =============================	
	
	@FindBy(id = "user-name")
	WebElement Username;
	
	
	@FindBy(id = "password")
	WebElement Password;

	
	@FindBy(id = "login-button")
	WebElement LoginBtn;
	
	
	public LoginPageClass() {
		
		PageFactory.initElements(driver, this);
		
	}
	
//============================ Functions =============================
	
public void LoginFunction(String UserNameVal, String PasswordVal){
		
		Username.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter Username", "Username entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter Password", "Password entered successfully");
		
		LoginBtn.click();	
		test.log(LogStatus.PASS, "Click Login Button", "Login button clicked successfully");
		
	}
	
	

}
