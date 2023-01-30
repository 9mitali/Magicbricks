package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExploreButton {
	
	WebDriver driver;
	By btn=By.xpath("/html/body/div[1]/div/div[2]/a/div[2]");
	By keyTxt=By.className("aspaHL__keyHlit__title");
	
	public ExploreButton(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getButton()
	{
		return driver.findElement(btn);
	}
	
	public WebElement getKeyText()
	{
		return driver.findElement(keyTxt);
	}

}
