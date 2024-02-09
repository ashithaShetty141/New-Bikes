package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.usedCars;

public class TC_003_usedCars extends TC_002_newHondaBikes{
	usedCars uc;
	
	@Test(priority=5)
	public void UsedCars() {
		uc = new usedCars(driver);
		uc.clickUsedCars();
		logger.info("Go to used cars model in chennai.....");
	}
	
	@Test(priority=6)
	public void printAllPopularModel() throws IOException {
		uc = new usedCars(driver);
		uc.clickPopularModel();
		logger.info("Print all the popular model.....");
	}
	
	
		
	

}
