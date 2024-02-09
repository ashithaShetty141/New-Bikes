package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class zigHomePage extends basePage{
	
	
	public zigHomePage(WebDriver driver) {
		super(driver);	
	}
	
	//locators
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/a")
	WebElement clickNewBikes;
	
	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/ul/li[5]/span")
	WebElement upcomingBikes;
	
	@FindBy(xpath="//*[@id=\"makeId\"]")
	WebElement manufactureDropdown;
	
	
	//action methods
	public void newBikesClick() {
		Actions act = new Actions(driver);
		act.moveToElement(clickNewBikes).perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		act.moveToElement(upcomingBikes).click().perform();
		
	}
	
	public void selectBikeModel() {
		Select selector = new Select(manufactureDropdown);
		selector.selectByVisibleText("Honda");
	}
}

