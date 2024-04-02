package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement LastName;

	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement Agree;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement continueok;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confrmmsg;
	
	
	
	public void sendFirstName(String fname)
			 {
		firstname.sendKeys(fname);
		
	}
	public void sendLastName(String lname) {
		LastName.sendKeys(lname);
	}
	public void sendEmail(String email )
	{
		Email.sendKeys(email);
	}
	public void sendPasword(String pw) {
	password.sendKeys(pw);
	}
	public void selectAgree() {
		Agree.click();
	}
	public void ClickContinue() {
		continueok.click();
		
	}
	public String textVerify()
	{ 
		String text=confrmmsg.getText();
		return text;
		
	}

}
