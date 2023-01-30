package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalNextPage {
	public WebDriver driver;
	
	By search=By.cssSelector("[name='selectedLocality']");
	
	public PortalNextPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getSearch()
	{
		return driver.findElement(search);
	}

}
