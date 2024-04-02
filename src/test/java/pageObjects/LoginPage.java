package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver) {
		
		super(driver);  // super calling statement will always call parent constructor
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement email; // address of email
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;  // address of password
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton; // address of login button
	
	public void sendEmail(String email1) {
		email.sendKeys(email1);;
	}
	public void sendPassword(String pw) {
		password.sendKeys(pw);
		
	}
	public void clickOnLogin() {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].click()", loginbutton);
	}
	

}
