package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	// xpath for MyAccount
		@FindBy(xpath="//span[text()='My Account']")
		WebElement linkAccount;
		
		//xpath for Registration
		@FindBy(xpath="//a[normalize-space()='Register']")
		WebElement linkRegister;
		
		//xpath for login
		@FindBy(xpath="//a[normalize-space()='Login']")
		WebElement login;
		
		public void ClickMyAccount() {
			linkAccount.click();
		}
		public void ClickRegister() {
			linkRegister.click();
			
		}
		public void ClickOnlogin() {
			login.click();

}

}
