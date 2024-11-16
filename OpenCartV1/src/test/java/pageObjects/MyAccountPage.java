package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.decorators.WebDriverDecorator;

public class MyAccountPage extends BasePage{
    public MyAccountPage(WebDriver driver){super(driver);}

    @FindBy(xpath = "//h2[normalize-space()='My Account']") WebElement msgHeading;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement btnLogout;

    public boolean verifyMyaccountHeading()
    {
        try {
            return (msgHeading.isDisplayed());
        } catch (Exception e) {
            return false;
        }
    }

    public  void btnLogout(){
        btnLogout.click();
    }


}

