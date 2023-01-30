package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompareBalanceTransferResult {
	
	public WebDriver driver;
	
	By text1=By.id("messageDiv");
	By result=By.id("messageAmountDiv");
	By text2=By.id("emiTenureSavedResultDiv");
	
	public CompareBalanceTransferResult(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getText1()
	{
		return driver.findElement(text1);
	}
	
	public WebElement getResult()
	{
		return driver.findElement(result);
	}
	
	public WebElement getText2()
	{
		return driver.findElement(text2);
	}

}
