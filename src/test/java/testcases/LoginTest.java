package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPageClass;

public class LoginTest extends BaseClass {
	
	@Test
	public void LoginFailureTest() {
		LoginPageClass login = new LoginPageClass();
		login.LoginFunction("xyz@abc.com","Abc@12345");
		
		WebElement ErrorMsg = driver.findElement(By.xpath("//*[starts-with(text(),'Epic sadface')]"));
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "Epic sadface: Username and password do not match any user in this service";
		
		Assert.assertEquals(ActualMsg, ExpMsg, "Invalid credentials, Please Login using valid credentials");
		
	}
	
	
	@Test
	@Parameters({"Param1","Param2"})
	public void LoginSuccessTest(String UserNameVal, String PasswordVal) {
		LoginPageClass login = new LoginPageClass();
		login.LoginFunction(UserNameVal, PasswordVal);
	}

	@Test
	public void LoginSuccessTest_ExcelData() {
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPageClass login = new LoginPageClass();
		login.LoginFunction(UserNameVal,PasswordVal);	
		
	}
}
