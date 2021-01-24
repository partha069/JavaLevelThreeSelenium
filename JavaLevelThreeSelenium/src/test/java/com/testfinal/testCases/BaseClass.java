package com.testfinal.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.testfinal.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig =new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String userName=readconfig.getUserName();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		logger=Logger.getLogger("TestFinal");
		PropertyConfigurator.configure("Log4j.properties");
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePatrh());
		driver= new ChromeDriver();
		}else if(br.equals("firefox")) {
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
		driver= new FirefoxDriver();
		}else if(br.equals("ie")) {
		System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
		driver= new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseURL);
		
	}
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	
	public void captureScreenshots(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.clearProperty("user.dir")+"/Screenshot/"+tname+".png");
		FileUtils.copyFile(source, target);
	}
	
	public String randomstring() {
		String generatestring=RandomStringUtils.randomAlphabetic(4);  //randomNumeric(4) will gen numeric of 4 digit
		return generatestring;	
	}
	
	
}
