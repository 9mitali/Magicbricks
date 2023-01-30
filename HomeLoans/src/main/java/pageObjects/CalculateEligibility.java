package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculateEligibility {
	public WebDriver driver;
	By loanAmount=By.id("lalec");
	By netIncome=By.id("inlec");
	By existingLoan=By.id("ellec");
	By tanure=By.id("ltlec");
	By roi=By.id("rlec");
	By calculate=By.xpath("//*[@id=\"loanEligibilityCalc\"]/div/div[1]/div/div[6]/input");
	
	public CalculateEligibility(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getLoanAmount()
	{
		return driver.findElement(loanAmount);
	}
	public WebElement getNetAmount()
	{
		return driver.findElement(netIncome);
	}
	public WebElement getExistingLoan()
	{
		return driver.findElement(existingLoan);
	}
	public WebElement getTanure()
	{
		return driver.findElement(tanure);
	}
	public WebElement getRoi()
	{
		return driver.findElement(roi);
	}
	public WebElement getCalculate()
	{
		return driver.findElement(calculate);
	}

}
