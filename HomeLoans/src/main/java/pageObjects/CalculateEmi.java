package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculateEmi {
	public WebDriver driver;
	By loanAmount=By.id("amountRequired");
	By tanure=By.id("loanTenureYear");
	By roi=By.id("emiroi");
	By calculate=By.xpath("//*[@id=\"emiCalculator\"]/div/div[1]/div/div[4]/input");
	
	public CalculateEmi(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement getLoanAmount()
	{
		return driver.findElement(loanAmount);
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
