package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;


public class usedCars extends basePage {
	public usedCars(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a")
	WebElement usedCarElement;

	@FindBy(xpath = "//li/span[contains(text(),'Chennai')]")
	WebElement ChennaiElement;

	@FindBy(xpath = "//div[contains(text(),'Popular Models')]")
	WebElement scrollPopularModels;

	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']//label")
	List<WebElement> popularModels;

	@FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]/a/img")
	WebElement homeBtn;
	
	
	
	// action methods
	public void clickUsedCars() {
		Actions act = new Actions(driver);
		act.moveToElement(usedCarElement).perform();
		act.moveToElement(ChennaiElement).click().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", scrollPopularModels);
		System.out.println();
	}

	public void clickPopularModel() throws IOException {
		
		System.out.println("================================");
		
		ExcelUtility eu= new ExcelUtility(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		for(int j=0;j<popularModels.size();j++) {
			System.out.println(popularModels.get(j).getText());
			eu.setCellData("PopularModels",j,0,popularModels.get(j).getText());
			
		}
		homeBtn.click();
	}

	

}
