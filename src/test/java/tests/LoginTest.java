package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Base;
import pages.LoginPage;

public class LoginTest extends Base{
	
	@BeforeClass
	public void setup() throws InterruptedException {
		initialization();
	}
	
	@Test(dataProvider = "testdata")
	public void VerifyValidUserLogin(String username, String password) throws InterruptedException {
		
		logger.info("click on Accept_cookies");
		LoginPage.Accept_cookies(driver).click();
		
		logger.info("click on sign in link");
		LoginPage.login_link(driver).click();
		
		logger.info("Enter Valid Credentials");
		LoginPage.textbox_username(driver).sendKeys(username);
		LoginPage.textbox_password(driver).sendKeys(password);
		
		logger.info("click on submit button");
		LoginPage.login_button(driver).click();
		Thread.sleep(2000);
		
	    logger.info(" Verify Valid Users"); 
	    boolean SuccessMessage=LoginPage.welcome_Message(driver).isDisplayed();
		Assert.assertTrue(SuccessMessage, "Login was not successful");
		 
		logger.info("Home Page");
		String Actualtitle = driver.getTitle();
		String Expectedtitle ="Viral Nation";
		Assert.assertEquals(Actualtitle, Expectedtitle, "title is not matched");
	}
	  @DataProvider(name="testdata")
	  	public Object [][] tData(){
	  		return new Object[][] 
	  		{
					/*
					 * {"Rahul@","Rahul@123"},// valid username and invalid password
					 * {"Vishal@","Zxcvbnm1"},// invalid username and valid password
					 * {"Amol@","Rahul@123"},//invalid username and password
					 */	  		
	  			{"thorat959@gmail.com","Zxcvbnm1@"},// valid username and password
	  	   };
	  	}
}
