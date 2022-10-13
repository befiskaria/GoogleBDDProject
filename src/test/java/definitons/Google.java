package definitons;

import java.io.IOException;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.HomePagePOM;
import utils.BaseClass;
import utils.GenericFunctions;


public class Google extends BaseClass{
	HomePagePOM G=new HomePagePOM();
	SoftAssert Assert = new SoftAssert();
	
	public Google() {
		super();
	}


	@Given("user is on Google Homepage {string}")
	public void user_is_on_google_homepage(String url) throws IOException {
		HomePagePOM.openPage(url);
	}

	@Then("I should be able to see the page title as {string}")
	public void i_should_be_able_to_see_the_page_title_as(String homepageTitle) {
	    Assert.assertEquals(G.getPageTitle(), homepageTitle);
	    //throw new io.cucumber.java.PendingException();
	}

	@When("I click on Gmail link")
	public void i_click_on_gmail_link() {
		G.clickGmailLink();
	}

	@Then("I should be able to navigate to Gmail page")
	public void i_should_be_able_to_navigate_to_gmail_page() {
		String expectedGmailTitle="Gmail: Private and secure email at no cost | Google Workspace";
		Assert.assertEquals(G.getPageTitle(), expectedGmailTitle);
	}

	@When("I click on Search box")
	public void i_click_on_search_box() {
		G.clickSearchBox();
	}

	@When("Enters the keyword {string}")
	public void enters_the_keyword(String searchString) {
		G.typeSearchBox(searchString);
	}

	@When("clicks on Enter key")
	public void clicks_on_enter_key() {
		G.pressEnter();
	}

	@Then("I should be able to navigate to corresponding results page")
	public void i_should_be_able_to_navigate_to_corresponding_results_page() {
		String expectedSearchResultsPageTitle="Weather - Google Search";
		Assert.assertEquals(G.getPageTitle(), expectedSearchResultsPageTitle);
	}
    @When("^I click on Images link$")
    public void i_click_on_images_link() throws InterruptedException {
        G.clickImagesLink();
        Thread.sleep(2000);
    }

    @Then("^I should be able to navigate to Google Images page$")
    public void i_should_be_able_to_navigate_to_google_images_page() throws Throwable {
		String expectedTitle="Google Images";
		String actualTitle=G.getPageTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
    }
    
}
