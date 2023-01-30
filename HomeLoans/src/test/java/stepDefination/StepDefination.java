package stepDefination;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GetStartedPage;
import pageObjects.PortalNextPage;
import resources.base;
import utils.testUtil;

public class StepDefination extends base{
	
	WebDriver driver;
	GetStartedPage gsp;
	
	@Test
	@Given("^User is able to visit the getstarted site$")
	public void user_is_able_to_visit_the_site_something() throws Throwable {
		driver=initializeDriver();
		String str=getGetStarted();
		driver.get(str);
	}
	/*@DataProvider
	public Object[][] getData() throws InvalidFormatException
	{
	Object data[][] = testUtil.getData("get");
	System.out.println(data);
	return data;
	}*/
	
	@Test()
	@Parameters({"Lnamount","mobile"})
	@When("^User enters the (.+) and (.+)$")
	public void user_enters_the_and(String loanamount, String mobilenumber) throws Throwable {
		gsp=new GetStartedPage(driver);
		gsp.getLoanAmount().sendKeys(loanamount);
		gsp.getMobileNumber().sendKeys(mobilenumber);
		gsp.getCheckBox().click();
		Assert.assertEquals(true, gsp.getCheckBox().isDisplayed());
		gsp.getGetStarted().click();
	}
	@Test
	@And("^Click the checkbox$")
	public void click_the_checkbox() throws Throwable {
		gsp=new GetStartedPage(driver);
		gsp.getCheckBox().click();

	}
	@Test
	@And("^Click get started button$")
	public void click_get_started_button() throws Throwable {
		gsp=new GetStartedPage(driver);
		gsp.getGetStarted().click();
	}
	/*@AfterMethod
	@Then("^User will navigate to the next page$")
	public void user_will_navigate_to_the_next_page() throws Throwable {
		PortalNextPage png=new PortalNextPage(driver);
		Assert.assertTrue(png.getSearch().isDisplayed());
	}*/
	@AfterTest
	@And("^Close all the browser$")
	public void close_all_the_browser() throws Throwable {
		driver.close();
	}


}
