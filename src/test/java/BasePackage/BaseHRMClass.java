package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMClass {
	
	public static Properties prop=new Properties();
	public static WebDriver driver;
	
	public BaseHRMClass() {
		
		try {
		FileInputStream file=new FileInputStream("/Users/priyanka/eclipse-workspace/HRmanagement/src/test/java/environmentvariables/Config.properties");
	prop.load(file);
		
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
			
		}
		catch(IOException a) {
			a.printStackTrace();
		}
	}
	
		@SuppressWarnings("deprecation")
		public static void initiate() {
			String browsername =prop.getProperty("browser");
			if (browsername.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver","/Users/priyanka/eclipse-workspace/HRmanagement/geckodriver");
				driver= new FirefoxDriver();
			}
				else if (browsername.equals("chrome")) {
					System.setProperty("webdriver.chrome.driver", "/Application/Chrome.app");
					driver= new ChromeDriver();
				}
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TimeUtils.Timepage, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			}
		
		public static void screenshots(String filename) {
			File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
			FileUtils.copyFile(file, new File("/Users/priyanka/eclipse-workspace/HRmanagement/src/test/java/screenshots/Screenshots"+"filename"+".jpg"));			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}}


