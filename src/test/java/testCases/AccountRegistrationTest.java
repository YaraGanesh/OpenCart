package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class AccountRegistrationTest extends BaseClass {
	
	
	@Test()
	public void Test_Account_Registration() throws InterruptedException {
		try {
		logger.info("*** Starting AccountRegistrationTest ***");
		 
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on my account link");
		Thread.sleep(3000);
		hp.ClickRegister();
		logger.info("Clicked on register link");
		Thread.sleep(3000);
		 
		
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("providing customer data");
		Thread.sleep(3000);
		
		rp.sendFirstName(randomeString());  //gtyui
		Thread.sleep(2000);
		rp.sendLastName(randomeString()); // abcd
		Thread.sleep(2000);
		rp.sendEmail(randomeString()+"@gmail.com"); //ghjuk@gmail.com
		Thread.sleep(2000);
		rp.sendPasword(randomAlphaNumeric()); // abcd@123
		Thread.sleep(5000);
		rp.selectAgree();
		Thread.sleep(2000);
		rp.ClickContinue();
		logger.info("clicked on continue");
		String confmsg=rp.textVerify();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			logger.error("test failed");
			e.printStackTrace();
			//Assert.fail();
		
		}
		logger.info("*** finished TC_OO1_AccountRegistrationTest ***");
		
	}
}
	


