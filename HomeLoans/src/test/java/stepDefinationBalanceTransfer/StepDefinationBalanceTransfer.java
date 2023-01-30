package stepDefinationBalanceTransfer;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CompareBalanceTransfer;
import pageObjects.CompareBalanceTransferResult;
import resources.Utility;
import resources.base;
import utils.testUtil;

public class StepDefinationBalanceTransfer extends base{
	WebDriver driver;
	//declaring objects globally
	CompareBalanceTransferResult cbtr;
	CompareBalanceTransfer cbt;

	@Test
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver=initializeDriver();
	}

	@Test
	@And("^Navigate to balancetransfer site$")
	public void navigate_to_something() throws Throwable {
		String str=getBalanceTransfer();
		//getting the url
		driver.get(str);
		Utility.captureScreenshot(driver, "\\navWebBalance");
	}

	/*@Test
	@And("^Click on Balance Transfer tab present under Home Loan Calculator$")
	public void click_on_balance_transfer_tab_present_under_home_loan_calculator() throws Throwable {
		compareBalanceTransfer cbt=new compareBalanceTransfer(driver);
		cbt.getClickBalance().click();
	}*/

	@DataProvider
	public Object[][] getData() throws InvalidFormatException
	{
		Object data[][] = testUtil.getData("balanceTransfer");
		System.out.println(data);
		return data;
	}
	@Test(dataProvider="getData")
	@When("^User enters the inputs in (.+) and (.+) and (.+) and  (.+) and (.+) and (.+) and (.+)under data fileds$")
	public void user_enters_the_inputs_in_and_and_and_and_and_and_under_data_fileds(String loanamount, String currenttanure, String currentrateofinterest, String installmentpaid, String processingfees, String newtanure, String newrateofinterest) throws Throwable {
		cbt=new CompareBalanceTransfer(driver);
		cbt.getLoanAmount().clear();
		cbt.getLoanAmount().sendKeys(loanamount);
		cbt.getCTanure().clear();
		cbt.getCTanure().sendKeys(currenttanure);
		cbt.getCRoi().clear();
		cbt.getCRoi().sendKeys(currentrateofinterest);
		cbt.getInstallmentPaid().clear();
		cbt.getInstallmentPaid().sendKeys(installmentpaid);
		cbt.getProcessingFees().clear();
		cbt.getProcessingFees().sendKeys(processingfees);
		cbt.getNTanure().clear();
		cbt.getNTanure().sendKeys(newtanure);
		cbt.getNRoi().clear();
		cbt.getNRoi().sendKeys(newrateofinterest);
		cbt=new CompareBalanceTransfer(driver);
		//taking the screenshot
		Utility.captureScreenshot(driver, "\\entersDataBalance");
		cbt.getCompare().click();
		cbtr=new CompareBalanceTransferResult(driver);
		//checking the result text is visible or not
		Assert.assertTrue(cbtr.getText1().isDisplayed());
		System.out.println(cbtr.getText1().getText());
		Assert.assertTrue(cbtr.getResult().isDisplayed());
		System.out.println(cbtr.getResult().getText());
		System.out.println(cbtr.getText2().getText());
		//taking the screenshot
		Utility.captureScreenshot(driver, "\\resultBalance");
	}

	/*@Test
	@And("^Click the Compare button$")
	public void click_the_compare_button() throws Throwable {
		cbt=new compareBalanceTransfer(driver);
		cbt.getCompare().click();
	}

	@Test
	@Then("^It will display the interest the user will lose$")
	public void it_will_display_the_interest_the_user_will_lose() throws Throwable {
		cbtr=new compareBalanceTransferResult(driver);
		System.out.println(cbtr.getText1().getText());
		Assert.assertTrue(cbtr.getResult().isDisplayed());
		System.out.println(cbtr.getResult().getText());
		System.out.println(cbtr.getText2().getText());
	}*/

	@AfterTest
	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}

}
