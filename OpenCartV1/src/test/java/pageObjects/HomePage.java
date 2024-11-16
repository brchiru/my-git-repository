package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }


//Locators
@FindBy(xpath="//a[normalize-space()=\"Register\"]") WebElement lnkregister;
@FindBy(xpath="//a[normalize-space()=\"Login\"]") WebElement lnklogin;
@FindBy(xpath="//span[normalize-space()=\"My Account\"]") WebElement lnkmyAccount;

//Methods
    public void clickMyAccount()
    {
        lnkmyAccount.click();
    }

    public void clickRegisterLnk()
    {
        lnkregister.click();
    }

    public  void clickLoginLnk()
    {
        lnklogin.click();
    }

}