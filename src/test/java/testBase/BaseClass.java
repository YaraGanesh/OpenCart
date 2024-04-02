package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public ResourceBundle rb;
	
	@BeforeClass
	public void setUp() {
		rb=ResourceBundle.getBundle("config"); //will load properties file
		logger=LogManager.getLogger(this.getClass());
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		
	/*@Parameters({"browser"})
	public void setup(String br) {
		logger=LogManager.getLogger(this.getClass());
		if(br.equals("edge")) {
			driver=new EdgeDriver();
		}
		else if(br.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			driver=new FirefoxDriver();
		}*/
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("http://localhost/opencartsite/");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
	}
	
		
		public String randomeString() {
			String generatedString = RandomStringUtils.randomAlphabetic(5);//abcde, tyuio, nhjio,
			return (generatedString);
		}

		
		public String randomAlphaNumeric() {
			String st = RandomStringUtils.randomAlphabetic(4);//abcd, mnjh,
			String num = RandomStringUtils.randomNumeric(3); //123,456.678,
			
			return (st+"@"+num); //password
		}
		

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
	
	
}
