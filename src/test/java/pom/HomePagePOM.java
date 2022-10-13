package pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class HomePagePOM extends BaseClass {
 	@FindBy(css ="Gmail") WebElement GmailLink;
 	@FindBy(css ="Images") WebElement ImagesLink;
 	@FindBy(xpath ="//input[@name='q']") WebElement SearchBox;
 	
 	
    public HomePagePOM(){
		PageFactory.initElements(driver, this);
    }
    
    public void clickGmailLink() {
    	GmailLink.click();
    }
    public void clickImagesLink() {
    	ImagesLink.click();
    }
    public String getPageTitle() {
    	return driver.getTitle();
    }
    public void clickSearchBox() {
    	SearchBox.click();
    }
    public void typeSearchBox(String SearchString) {
    	SearchBox.sendKeys(SearchString);
    }
    public void pressEnter(){
        Actions action;
        action=new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }
	public static void openPage(String url) {
		driver.get(url);
	}
    public void pressTab(){
        Actions action;
        action=new Actions(driver);
        action.sendKeys(Keys.TAB).build().perform();
    }
    public void refresh(WebDriver driver){
        driver.navigate().refresh();
    }
}
