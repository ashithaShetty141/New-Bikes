package testCases;

import java.io.IOException;

import org.testng.annotations.Test;
import pageObject.hondaNewBikes;

public class TC_002_newHondaBikes extends TC_001_zigwheelsHome{
	hondaNewBikes nb;
	
	@Test(priority=3)
	public void viewMoreBikes() {
		nb = new hondaNewBikes(driver);
		nb.clickMoreBikes();
		logger.info("Click on view more bikes.....");
	}
	
	@Test(priority=4)
	public void detailsOfAllBikes() throws IOException {
		nb = new hondaNewBikes(driver);
		nb.allNewBikes();
		nb.goTOHome();
		logger.info("Get the details of all Honda bikes.....");
	}
	
}
