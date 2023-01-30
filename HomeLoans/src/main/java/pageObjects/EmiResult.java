package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmiResult {
	public WebDriver driver;
	By emiText=By.className("home-loan__calc__preview__emi--label");
	By span=By.xpath("//*[@id=\"emiSpan\"]");
	
	public EmiResult(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmiText()
	{
		return driver.findElement(emiText);
	}
	public WebElement getSpan()
	{
		return driver.findElement(span);
	}

}
