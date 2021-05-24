package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
private WebDriver driver;

private By  usernameLocator= By.id("username");
private By  passwordLocator =By.id("password");
private  By   submitbuttonlocator = By.id("loginbutton" );
private  By  CantLogINLocator = By.id("errorcantlogin" );


public LoginPage( WebDriver driver)
{
	this.driver= driver;
}


public void Sendusername(String username) {
	this.driver.findElement(usernameLocator).sendKeys(username);
	
}

public void Sendpassword (String password)
{
	this.driver.findElement(passwordLocator).sendKeys(password);
}

public void clickLogin() {
	this.driver.findElement(submitbuttonlocator).click();
	
}

public String GetErrorLogInText() {
	return this.driver.findElement(CantLogINLocator).getText();
	
	
}



}
