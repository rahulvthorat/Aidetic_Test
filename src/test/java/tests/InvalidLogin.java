package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pages.LoginPage;

public class InvalidLogin extends Base {


	@BeforeClass
	public void setup() throws InterruptedException {
		initialization();
	}

	@Test(dataProvider = "testdata")
	public void VerifyInValidUserLogin(String username, String password) throws InterruptedException {

		logger.info("click on Accept_cookies");
		LoginPage.Accept_cookies(driver).click();

		logger.info("click on sign in link");
		LoginPage.login_link(driver).click();

		logger.info("Enter InValid Credentials");
		LoginPage.textbox_username(driver).sendKeys(username);
		LoginPage.textbox_password(driver).sendKeys(password);

		logger.info("click on submit button");
		LoginPage.login_button(driver).click();
		Thread.sleep(2000);

		logger.info(" Verify Invalid Users"); 
		boolean SuccessMessage=LoginPage.welcome_Message(driver).isDisplayed();
		Assert.assertTrue(SuccessMessage, "Wrong Password");

	}
	@DataProvider(name="testdata")
	public Object [][] tData(){
		return new Object[][] 
				{

			{"thorat99@gmail.com","12345678"},// valid username and invalid password

				};
	}

}
