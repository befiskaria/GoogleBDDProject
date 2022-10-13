package definitons;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.GmailPOM;
import utils.BaseClass;

public class Gmail extends BaseClass{
	GmailPOM Gm = new GmailPOM();
	SoftAssert Assert = new SoftAssert();
	
	public Gmail() {
		super();
	}
	@Given("user is on Gmail {string}")
	public void user_is_on_gmail(String url) {
		GmailPOM.openGmailPage(url);
	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String gmailTitle) {
		Assert.assertEquals(Gm.getGmailPageTitle(), gmailTitle);
	}

	@Given("I click on Create Account")
	public void i_click_on_create_account() {
		Gm.clickCreateAccountButton();
	}

	@When("I click on For my personal use")
	public void i_click_on_for_my_personal_use() {
		try {
			Gm.clickForMyPersonalUse();
		} catch (Exception ignored) {

		}
	}

	@Then("I should see the page title as {string}")
	public void i_should_see_the_page_title_as(String CYGATitle) {
		Assert.assertEquals(Gm.getGmailPageTitle(), CYGATitle);
	}

	@Given("clicks on account creation button")
	public void clicks_on_account_creation_button() {
		Gm.clickCreateAccountButton();
	}

	@Given("clicks on For my personal use option")
	public void clicks_on_for_my_personal_use_option() {
		try {
			Gm.clickForMyPersonalUse();
		} catch (Exception ignored) {

		}
	}

	@When("^user enters (.*) (.*) (.*) (.*) and (.*)$")
	public void user_enters (String fName, String lName, String Uname, String pSwd, String CpSwd) {
		Gm.enterFirstName(fName);
		Gm.enterLastName(lName);
		Gm.enterUserName(Uname);
		Gm.enterPassword(pSwd);
		Gm.confirmPassword(CpSwd);
	}

	@When("clicks on button: Next")
	public void clicks_on_button_next() throws InterruptedException {
		Thread.sleep(2000);
		Gm.clickNextButton();
		Thread.sleep(1000);
	}

	@Then("I should be navigated to page: Verify your phone number")
	public void i_should_be_navigated_to_page_verify_your_phone_number() {
		String actualText = "Verify your phone number";
		Assert.assertEquals(actualText, Gm.getTextPhoneNumber());
	}
}
