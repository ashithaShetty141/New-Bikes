package pageObject;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage  extends basePage{
	public loginPage(WebDriver driver) {
		super(driver);
	
	}
	
	@FindBy(xpath="//div[@id='forum_login_title_lg']")
	WebElement loginElement;
	
	@FindBy(xpath="//div[@class='lgn-sc c-p txt-l pl-30 pr-30 googleSignIn']")
	WebElement googleElement;
	
	@FindBy(xpath="//*[@id=\"identifierId\"]")
	WebElement emailElement;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]/div/button/span")
	WebElement nextButton;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement errorMsg;
	
	
	
	
	public void clickLogin() {
		loginElement.click();
		googleElement.click();
	}
	
	public String verifyEmail(String email) throws IOException {
		Set<String> winIdSet = driver.getWindowHandles();
		List<String> winIdList =new ArrayList<>(winIdSet);
		driver.switchTo().window(winIdList.get(1));
		
		emailElement.sendKeys(email);
		nextButton.click();
		String	errortext=errorMsg.getText();
		System.out.println();
		System.out.println("============================");
		System.out.println("Error Alert: ");
		System.out.println(errortext);
		
		takeScreenshot("errormessage", errorMsg);
		return errortext;
	}
}
