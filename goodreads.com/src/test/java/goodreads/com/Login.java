package goodreads.com;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login extends Base {
	

	
	@BeforeTest
	public void BeforeTest() {
	setUp("https://www.goodreads.com/");
	
	//Click Sign in button
	click(element("linkText", "Sign In"));

	//Click Sign in with email button
	click(element("linkText", "Sign in with email"));
	}
	
	@Test(priority=1)
	public void LoginWithEmptyFields() throws IOException{

		//Click Sign in button
		click(element("id", "signInSubmit"));
		
		//Take the ScreenShot of Test Result
		Screenshot("LoginWithEmptyFields");
		
		//Validate title
		String Signintitle=driver.getTitle();
		Assert.assertEquals(Signintitle, "Goodreads Sign in");
			
	}
	
	@Test(priority=2)
	public void IncorrectLoginEmail() throws IOException, InterruptedException {
		
		//Enter LoginEmail
		WebElement Email=element("id", "ap_email");
		type(Email, "deepakrao@gmail.com");
		
		//Enter LoginPassword
		WebElement password=element("id", "ap_password");
		type(password, "Deepak@1");
		
		//Click Sign in button
		click(element("id", "signInSubmit"));
		
		
		//This code will wait for captcha to enter manually
		WebElement captcha=element("id", "image-captcha-section");
		if(captcha.isDisplayed()==true){
			//Enter LoginPassword Again
			WebElement password2=element("id", "ap_password");
			type(password2, "Deepak@1");
			
			//Wait for Captcha
			//If a captcha appears, enter the captcha manually and then click sign in.
			Thread.sleep(30000);
			
			//Again Click Sign in button
			click(element("id", "signInSubmit"));
			}
		
	    
	    //Validate title
	    String Signintitle2=driver.getTitle();
	    Assert.assertEquals(Signintitle2, "Goodreads Sign in");
	    
	    //Validate Pop up Message
	    String InvalidEmail=element("classname", "a-list-item").getText();
	    Assert.assertEquals(InvalidEmail, "We cannot find an account with that email address");
	    
	  //Take the ScreenShot of Test Result
	    Screenshot("IncorrectLoginEmail");
			
	}
	@Test(priority=3)
	public void IncorrectLoginPassword() throws IOException, InterruptedException {
		
		//Enter LoginEmail
		WebElement Email=element("id", "ap_email");
		type(Email, "deepakrao9786@gmail.com");

		//Enter LoginPassword
		WebElement password=element("id", "ap_password");
		type(password, "deepak@1");
		
		//Click Sign in button
		click(element("id", "signInSubmit"));
		
		
		//This code will wait for captcha to enter manually
		WebElement captcha=element("id", "image-captcha-section");
		if(captcha.isDisplayed()==true){
				//Enter LoginPassword Again
				WebElement password2=element("id", "ap_password");
				type(password2, "deepak@1");
				
				//Wait for Captcha
				//If a captcha appears, enter the captcha manually and then click sign in.
				Thread.sleep(30000);
				
				//Click Sign in button
				click(element("id", "signInSubmit"));
			}
		

		
		
		//Validate title
		String Signintitle2=driver.getTitle();
		Assert.assertEquals(Signintitle2, "Goodreads Sign in");
		
		//Validate Pop up Message
		String InvalidPassword=element("classname", "a-list-item").getText();
		Assert.assertEquals(InvalidPassword, "Your password is incorrect");
		
		//Take the ScreenShot of Test Result
		Screenshot("IncorrectLoginPassword");
	}


	@Test(priority=4)
	public void ForgotPassword() throws IOException, InterruptedException {

		//Click forgot password button
		click(element("linkText", "Forgot your password?"));

		//Take the ScreenShot of Test Result
		Screenshot("ForgotPassword");

		//Validate title
		String ForgotPasswordtitle=driver.getTitle();
		Assert.assertEquals(ForgotPasswordtitle, "Goodreads Password Assistance");	
		
		//Return to sign in page
		driver.navigate().to("https://www.goodreads.com/user/sign_in");
		click(element("linkText", "Sign in with email"));

	}
	@Test(priority=5)
	public void CorrectLoginEmail_and_Password() throws IOException, InterruptedException {

		//Enter LoginEmail
		WebElement Email=element("id", "ap_email");
		type(Email, "deepakrao9786@gmail.com");

		//Enter LoginPassword
		WebElement password=element("id", "ap_password");
		type(password, "Deepak@1");
		
		//Click Sign in button
		click(element("id", "signInSubmit"));
		
		//This code will wait for captcha to enter manually
		WebElement captcha=element("id", "image-captcha-section");
		if(captcha.isDisplayed()==true){
			
				//Enter LoginPassword Again
				WebElement password2=element("id", "ap_password");
				type(password2, "Deepak@1");
				
				//Wait for Captcha
				//If a captcha appears, enter the captcha manually and click sign in.
				Thread.sleep(40000);

				//Click Sign in button
				click(element("id", "signInSubmit"));
		}
		
	

		//Validate title
		String Signintitle2=driver.getTitle();
		Assert.assertEquals(Signintitle2, "Recent updates | Goodreads");

		//Validate URL
		String HomePageUrl=driver.getCurrentUrl();
		Assert.assertEquals(HomePageUrl,"https://www.goodreads.com/");
		
		//Take the ScreenShot of Test Result
		Screenshot("CorrectLoginEmail_and_Password");
	}
	
	@AfterTest
	public void AfterTest() {
		quit();
	}
	
	

}
