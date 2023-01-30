package stepDefinationExplore;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ExploreButton;
import resources.Utility;
import resources.base;

public class StepDefinationExplore extends base{
	//declaring objects globally
	WebDriver driver=null;
	ExploreButton eb;

	@Test
	@Given("^Initialize and open the browser$")
	public void initialize_and_open_the_browser() throws Throwable {
		driver=initializeDriver();
	}

	@Test
	@And("^Navigate to the main home loans page$")
	public void navigate_to_the_main_home_loans_page() throws Throwable {
		//url from base file
		String str=getExplore();
		driver.get(str);
		//Thread.sleep(5000);
		eb=new ExploreButton(driver);
		Utility.captureScreenshot(driver, "\\navWebExplore");
		Thread.sleep(5000);
		eb.getButton().click();
		//handling different windows
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String pid=it.next();
		String cid=it.next();
		//switching to the child window
		driver.switchTo().window(cid);
		//taking the screenshot
		Utility.captureScreenshot(driver, "\\navChildWebExplore");
		String estr="Key Highlights";
		String astr=eb.getKeyText().getText();
		//checking the expected and the actual text are same or not
		Assert.assertEquals(estr, astr);
		System.out.println("String Matched  --  Assert Passed");
	}

	/*@Test	
	@When("^Click the Explore button$")
	public void click_the_explore_button() throws Throwable {
		
		eb=new exploreButton(driver);
		Thread.sleep(5000);
		eb.getButton().click();
		System.out.println("Cilck on explore button");
	}

	
	@Then("^User will be able to visit another page with Key Features$")
	public void user_will_be_able_to_visit_another_page_with_key_features() throws Throwable {
		eb=new exploreButton(driver);
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String pid=it.next();
		String cid=it.next();
		driver.switchTo().window(cid);
		String estr="Key Highlights";
		String astr=eb.getKeyText().getText();
		Assert.assertEquals(estr, astr);
		System.out.println("String Matched");
	}*/

	@AfterTest
	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();
	}


}
