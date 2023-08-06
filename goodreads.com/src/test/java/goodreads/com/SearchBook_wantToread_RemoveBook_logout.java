package goodreads.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchBook_wantToread_RemoveBook_logout extends Login {
	
	@Test(priority=6)
	public void SearchBook_wantToread_RemoveBook() throws IOException, InterruptedException {
		
		//Search Book
		WebElement searchbox=element("xpath", "(//input[@name='q'])[1]");
		typeAndpressEnter(searchbox, "Chip War: The Fight for the World's Most Critical Technology");
		
		//Validate whether the searched book appears in the first place.
		String FirstResult=element("xpath", "(//a[@class='bookTitle'])[1]").getText();
		Assert.assertEquals(FirstResult, "Chip War: The Fight for the World's Most Critical Technology");
		
		//Take the ScreenShot of Test Result
		Screenshot("SearchBookResult");
		
		//Click Want to Read button
		click(element("xpath", "(//button[@class='wtrToRead'])[1]"));
		
		//Click My Books
		Thread.sleep(2000);
		click(element("linkText", "My Books"));
		
		//Validate whether the "wanted to read" book appears in the first place
		String Firstres=element("xpath", "(//div[@class='value'])[4]").getText();
		Assert.assertEquals(Firstres, "Chip War: The Fight for the World's Most Critical Technology");
		
		//Take the ScreenShot of Test Result
		Screenshot("MyBooksResult");
		
		//Remove book from my books list
		click(element("xpath", "(//img[@alt='Remove from my books'])[1]"));
		
		//Accept the alert
		driver.switchTo().alert().accept();
		
		//Validate the pop up message
		WebElement PopUptext=element("xpath", "(//div[@class='box noticeBox'])[1]");
		wait.until(ExpectedConditions.visibilityOf(PopUptext));
		String RemoveBookAlertMessage=PopUptext.getText();
		Assert.assertEquals(RemoveBookAlertMessage, "Chip War: The Fight for the World's Most Critical Technology was removed from your books.");
		
		//Take the ScreenShot of Test Result
		Screenshot("BookRemoval_PopUpMessage");
	
		
	}
	
	@Test(priority=7)
	public void SignOut() throws IOException {
		
		//Click SignOut button
		click(element("xpath", "(//span[@class='headerPersonalNav__icon'])[1]"));
		click(element("linkText", "Sign out"));
		
		//Take the ScreenShot of Test Result
		Screenshot("SignOutPage");
		
	}
	

}
