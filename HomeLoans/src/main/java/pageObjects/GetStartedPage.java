package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetStartedPage {
	public WebDriver driver;
	By loanAmount=By.cssSelector("[id='loanAmount']");
	By mobileNumber=By.cssSelector("[id='mobileNumber']");
	By checkBox=By.cssSelector("[id='tnc-checkbox']");
	By getStarted=By.cssSelector("[id='generate-otp']");

	public GetStartedPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement getLoanAmount()
	{
		return driver.findElement(loanAmount);
	}

	public WebElement getMobileNumber()
	{
		return driver.findElement(mobileNumber);
	}

	public WebElement getCheckBox() {
		return driver.findElement(checkBox);
	}

	public WebElement getGetStarted()
	{
		return driver.findElement(getStarted);
	}


}
