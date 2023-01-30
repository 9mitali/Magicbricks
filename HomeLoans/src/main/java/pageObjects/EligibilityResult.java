package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EligibilityResult {
	
	public WebDriver driver;
	
	By eligibilityText1=By.className("home-loan__calc__preview__emi--label");
	By eligibilityAmount=By.id("loanAmtResultDiv");
	By eligibilityText2=By.className("home-loan__calc__preview__category--label");
	By emiAmount=By.id("emiResultDiv");
	
	public EligibilityResult(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEligibilityText1()
	{
		return driver.findElement(eligibilityText1);
	}
	public WebElement getEligibilityAmount()
	{
		return driver.findElement(eligibilityAmount);
	}
	public WebElement getEligibilityText2()
	{
		return driver.findElement(eligibilityText2);
	}
	public WebElement getEmiAmount()
	{
		return driver.findElement(emiAmount);
	}

}
