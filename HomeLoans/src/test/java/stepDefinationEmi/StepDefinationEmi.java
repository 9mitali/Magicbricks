package stepDefinationEmi;

import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CalculateEmi;
import pageObjects.EmiResult;
import resources.Utility;
import resources.base;
import utils.testUtil;

public class StepDefinationEmi extends base{
	//declaring objects globally
	CalculateEmi ce;
	EmiResult er;
	WebDriver driver;
	
	@Test
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver=initializeDriver();
	}
	@Test
	//@Parameters("browser1")
	@And("^Navigate to emi site$")
	public void navigate_to_something_site() throws Throwable {
		//getting the url
		String emi=getUrl();
		driver.get(emi);
		Utility.captureScreenshot(driver, "\\navWebEmi");
	}
	
	@DataProvider
	public Object[][] getData() throws InvalidFormatException
	{
	Object data[][] = testUtil.getData("emi");
	System.out.println(data);
	return data;
	}
	
	@Test(dataProvider="getData")
	@Parameters({"Lamount","Tanure","Rate"})
	@When("^User enters (.+) and (.+) and (.+)$")
	public void user_enters_and_and(String loanamount, String tanure, String rateofinterest) throws Throwable {
		//CalculateEmi ce=new CalculateEmi(driver);
		ce=new CalculateEmi(driver);
		ce.getLoanAmount().clear();
		//Thread.sleep(2000);
		ce.getLoanAmount().sendKeys(loanamount);
		ce.getTanure().clear();
		ce.getTanure().sendKeys(tanure);
		ce.getRoi().clear();
		ce.getRoi().sendKeys(rateofinterest);
		//ce=new CalculateEmi(driver);
		ce.getCalculate().click();
		//checking the calculated result is visible or not
		Assert.assertTrue(ce.getCalculate().isDisplayed());
		System.out.println("Result is displayed -- Assert Passed");
		Utility.captureScreenshot(driver, "\\resultEmi");
		er=new EmiResult(driver);
		System.out.println(er.getEmiText().getText());
		//checking the result is visible or not
		Assert.assertTrue(er.getSpan().isDisplayed());
		System.out.println(er.getSpan().getText());
		System.out.println("The test case is correct");
	}
	/*@Test
	@And("^Click on Calculate EMI button$")
	public void click_on_calculate_emi_button() throws Throwable {
		//CalculateEmi ce=new CalculateEmi(driver);
		ce=new CalculateEmi(driver);
		ce.getCalculate().click();
	}
	@AfterTest
	@Then("^It will display EMI per month$")
	public void it_will_display_emi_per_month() throws Throwable {
		EmiResult er=new EmiResult(driver);
		System.out.println(er.getEmiText().getText());
		Assert.assertTrue(er.getSpan().isDisplayed());
		System.out.println(er.getSpan().getText());
		System.out.println("The test case is correct");
		//Assert.assertEquals(s1, result1);
		
	}*/
	@AfterTest
	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}

}
