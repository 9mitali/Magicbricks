package stepDefinationEligibility;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CalculateEligibility;
import pageObjects.EligibilityResult;
import resources.Utility;
import resources.base;
//import resources.screenShot;
import utils.testUtil;

public class StepDefinationEligibility extends base{
	//declaring objects globally
	WebDriver driver;
	CalculateEligibility ce;
	EligibilityResult er;

	@Test
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver=initializeDriver();
	}

	@Test
	@And("^Navigate to eligibility site$")
	public void navigate_to_something() throws Throwable {
		//get the url
		String str=getEligibility();
		driver.get(str);
		//taking the screenshot
		Utility.captureScreenshot(driver, "\\navWebEligibility");
	}
	
	//providing the data from excel sheet
	@DataProvider
	public Object[][] getData() throws InvalidFormatException
	{
	Object data[][] = testUtil.getData("eligibility");
	System.out.println(data);
	return data;
	}

	@Test(dataProvider="getData")
	//@Parameters({"NetIncome","Existing","Tanure","Rate"})
	@When("^User enters (.+) and (.+) and (.+) and (.+) and (.+)$")
	public void user_enters_and_and_and_and(String loanamount, String netincome, String existingloan, String tanure, String rateofinterest) throws Throwable {
		ce=new CalculateEligibility(driver);
		ce.getLoanAmount().clear();
		ce.getLoanAmount().sendKeys(loanamount);
		ce.getNetAmount().clear();
		ce.getNetAmount().sendKeys(netincome);
		ce.getExistingLoan().clear();
		ce.getExistingLoan().sendKeys(existingloan);
		ce.getTanure().clear();
		ce.getTanure().sendKeys(tanure);
		ce.getRoi().clear();
		ce.getRoi().clear();
		ce.getRoi().sendKeys(rateofinterest);
		//taking the screenshot
		Utility.captureScreenshot(driver, "\\entersDataEligibility");
		CalculateEligibility ce1=new CalculateEligibility(driver);
		ce1.getCalculate().click();
		er=new EligibilityResult(driver);
		Assert.assertTrue(er.getEligibilityText1().isDisplayed());
		System.out.println("Text is displaying -- Assert Passed");
	}

	@Test
	@And("^User click the Check Eligibility button$")
	public void user_click_the_check_eligibility_button() throws Throwable {
		ce=new CalculateEligibility(driver);
		ce.getCalculate().click();
		er=new EligibilityResult(driver);
		//printing the results
		/*System.out.println(er.getEligibilityText1().getText());
		System.out.println(er.getEligibilityAmount().getText());
		System.out.println(er.getEligibilityText2().getText());
		System.out.println(er.getEmiAmount().getText());
		//taking the screenshot
		Utility.captureScreenshot(driver, "\\clkButtonEligibility");*/
	}

	@Test
	@Then("^It will display the Eligibility amount$")
	public void it_will_display_the_eligibility_amount() throws Throwable {
		er=new EligibilityResult(driver);
		//Assert.assertTrue(er.getEligibilityText1().isDisplayed());
		System.out.println(er.getEligibilityText1().getText());
		System.out.println(er.getEligibilityAmount().getText());
		System.out.println(er.getEligibilityText2().getText());
		System.out.println(er.getEmiAmount().getText());
	}

	@AfterTest
	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}


}
