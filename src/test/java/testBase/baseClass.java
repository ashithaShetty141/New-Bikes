package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class baseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	public void setup() throws IOException
	{
		//config properties file
				FileReader file = new FileReader(".//src//test//resources//config.properties");
				p = new Properties();
				p.load(file);
				
		
		//loading log4j2 file
		logger = LogManager.getLogger(this.getClass());
		
//		switch(br.toLowerCase())
//		{
//		case "chrome": driver = new ChromeDriver(); break;
//		case "edge": driver = new EdgeDriver(); break; 
//		default: System.out.println("No matching browser!");
//		return;
		//}
		driver= new ChromeDriver(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("PageURL"));
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	public String captureScreen(String tname) throws IOException {
		 
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\ExtentScreenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
 
	}
	
}
