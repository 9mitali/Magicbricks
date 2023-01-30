package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompareBalanceTransfer {
	public WebDriver driver;
	
	By clickBalance=By.xpath("//*[@id=\"loantransId\"]");
	By loanAmount=By.id("laltc");
	By cTanure=By.id("ltltc");
	By cRoi=By.id("rltc");
	By installmentPaid=By.id("ipltc");
	By processingFees=By.id("pfltc");
	By nTanure=By.id("nltltc");
	By nRoi=By.id("nrltc");
	By compare=By.xpath("//*[@id=\"loanTransferCalculator\"]/div/div[1]/div/div[4]/input");
	
	public CompareBalanceTransfer(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getClickBalance()
	{
		return driver.findElement(clickBalance);
	}
	
	public WebElement getLoanAmount()
	{
		return driver.findElement(loanAmount);
	}
	
	public WebElement getCTanure()
	{
		return driver.findElement(cTanure);
	}
	
	public WebElement getCRoi()
	{
		return driver.findElement(cRoi);
	}
	
	public WebElement getInstallmentPaid()
	{
		return driver.findElement(installmentPaid);
	}
	
	public WebElement getProcessingFees()
	{
		return driver.findElement(processingFees);
	}
	
	public WebElement getNTanure()
	{
		return driver.findElement(nTanure);
	}
	
	public WebElement getNRoi()
	{
		return driver.findElement(nRoi);
	}
	
	public WebElement getCompare()
	{
		return driver.findElement(compare);
	}

}
