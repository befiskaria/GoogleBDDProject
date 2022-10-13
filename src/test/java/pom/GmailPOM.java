package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class GmailPOM extends BaseClass{
 	@FindBy(partialLinkText ="Gmail") WebElement GmailLink;
 	@FindBy(xpath ="//*[text()='Create account']") WebElement CreateAccountButton;
 	@FindBy(id ="firstName") WebElement Fname;
 	@FindBy(id ="lastName") WebElement Lname;
 	@FindBy(id ="username") WebElement uName;
 	@FindBy(name ="Passwd") WebElement Pswd;
 	@FindBy(name ="ConfirmPasswd") WebElement cPswd;
 	@FindBy(xpath ="//*[text()='Next']") WebElement NextButton;
 	@FindBy(xpath ="//*[text()='Verify your phone number']") WebElement VerifyYourPhoneNumber;
 	@FindBy(xpath ="//*[text()='For my personal use']") WebElement ForMyPersonalUse;
	
    public GmailPOM(){
		PageFactory.initElements(driver, this);
    }
    public void clickForMyPersonalUse() {
    	ForMyPersonalUse.click();
    }
    public String getTextPhoneNumber() {
    	return VerifyYourPhoneNumber.getText();
    }
    public void clickNextButton() {
    	NextButton.click();
    }
    public void confirmPassword(String CpSwd) {
    	cPswd.sendKeys(CpSwd);
    }
    public void enterPassword(String pSwd) {
    	Pswd.sendKeys(pSwd);
    }
    public void enterUserName(String Uname) {
    	uName.sendKeys(Uname);
    }
    public void enterLastName(String lName) {
    	Lname.sendKeys(lName);
    }
    public void enterFirstName(String fName) {
    	Fname.sendKeys(fName);
    }
    public void clickCreateAccountButton() {
    	CreateAccountButton.click();
    }
	public static void openGmailPage(String url) {
		driver.get(url);
	}
    public String getGmailPageTitle() {
    	return driver.getTitle();
    }
}
