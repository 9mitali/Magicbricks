package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public String emiSite;
	public String getStartedSite;
	public String getEligibilitySite;
	public String getBalanceTransferSite;
	public String getExploreSite;
	public WebDriver initializeDriver() throws IOException
	{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\USER\\Desktop\\HomeLoans\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		String siteName=prop.getProperty("url");
		emiSite=prop.getProperty("emi");
		getStartedSite=prop.getProperty("getstarted");
		getEligibilitySite=prop.getProperty("eligibility");
		getBalanceTransferSite=prop.getProperty("balancetransfer");
		getExploreSite=prop.getProperty("explore");

		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			//driver.get(siteName);
			System.out.println(driver.getTitle());
		}
		else if(browserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE"))
		{
			//Internet Explorer
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	public String getUrl()
	{
		return emiSite;
	}
	public String getGetStarted()
	{
		return getStartedSite;
	}
	public String getEligibility()
	{
		return getEligibilitySite;
	}
	public String getBalanceTransfer()
	{
		return getBalanceTransferSite;
	}
	public String getExplore()
	{
		return getExploreSite;
	}
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\HIGHOSH\\eclipse-workspace\\HomeLoans\\screenShots"+result+"magicbricks.png"));
		
	}
	
}
