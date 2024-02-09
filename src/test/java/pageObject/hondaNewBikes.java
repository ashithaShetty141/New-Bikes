package pageObject;


import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

public class hondaNewBikes  extends basePage{
	public hondaNewBikes(WebDriver driver) {
		super(driver);	
	}
	
	//locators
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']")
	WebElement moreBikes;
	
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/a/strong")
	List<WebElement> allBikes;
	
	@FindBy(xpath="//li[contains(@class,'modelItem')]")
	public List<WebElement> priceOfBike;
	
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/div[1]")
	public List<WebElement>Bike_Prices;
	
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/div[2]")
	public List<WebElement>Bike_Launchdate;
	
	
	@FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]/a/img")
	WebElement homeBtn;
	
	
	//action methods
	public void clickMoreBikes() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",moreBikes);
		js.executeScript("arguments[0].click();",moreBikes);
		//moreBikes.click();
	}
	
	public void allNewBikes() throws IOException {
		
/*        Map<String, Float> prices = new LinkedHashMap<>();
		
		for (WebElement ele: allBikes) {
			String priceString = ele.findElement(By.tagName("div")).getText();
			
			String[] parts = priceString.split("\\s");
		
			if (parts.length >=2 && parts[1].equals("79,000")) {
				prices.put(ele.findElement(By.tagName("strong")).getText(),(float) 0.79);				
				
			} 
			else if (parts.length >= 2) {
				float price = Float.parseFloat(parts[1].trim());
				if (price <= 4.00) {
					
					prices.put(ele.findElement(By.tagName("strong")).getText(),price);
				}
			} 
			else {
				System.out.println("skipped");
				continue;
			}
		}
		for (Map.Entry<String, Float> entry : prices.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}*/
		
		
		System.out.println("-----------------------------");
		ExcelUtility eu= new ExcelUtility(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		for(int i=0;i<allBikes.size();i++) {
			int price = Integer.parseInt(priceOfBike.get(i).getAttribute("data-price"));
			if(price<400000) {
				System.out.println(allBikes.get(i).getText());
				eu.setCellData("HondaNewBikes",i,0,allBikes.get(i).getText());
			
				System.out.println(Bike_Prices.get(i).getText());
				eu.setCellData("HondaNewBikes",i,1,Bike_Prices.get(i).getText());
			
				System.out.println(Bike_Launchdate.get(i).getText());
				eu.setCellData("HondaNewBikes",i,2,Bike_Launchdate.get(i).getText());
				System.out.println("-----------------------------------");
			
				
			}
			else {
				continue;
			}
				
			}
		}
	
		
		
	public void goTOHome()
	{
		homeBtn.click();
	}	
	
	
	
	}
	
	
	

