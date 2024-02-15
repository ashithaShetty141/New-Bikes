package testCases;

import org.testng.annotations.Test;

import pageObject.zigHomePage;
import testBase.baseClass;

public class TC_001_zigwheelsHome extends baseClass {
	zigHomePage hp;
    
	@Test(priority=1,groups =  {"regression"})
	public void NewBikesClick() {
		hp = new zigHomePage(driver);
		hp.newBikesClick();
		logger.info("Upcoming bikes displayed.....");
	}
	
	@Test(priority=2, groups =  {"regression"})
	public void bikeModel() {
		hp = new zigHomePage(driver);
		hp.selectBikeModel();
		logger.info("Honda bikes are displayed.....");
	}
}
