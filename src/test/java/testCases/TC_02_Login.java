package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_02_Login extends BaseClass{
	@Test()
	public void testLogin()throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.ClickMyAccount();
		hp.ClickOnlogin();
		
		LoginPage lp=new LoginPage(driver);
		
		// get the values from config file and pass it
		
		
		lp.sendEmail(rb.getString("email")); // email will get from config file
		lp.sendPassword(rb.getString("password")); // password will get from config file
		Thread.sleep(3000);
		lp.clickOnLogin();
		Thread.sleep(3000);
		
		/*MyAccountPage ma=new MyAccountPage(driver);
		
		boolean target = ma.isMyAccountExists();
		Assert.assertEquals(target, true);
		logger.info("Finished TC_02Login");*/
		
	}

}
