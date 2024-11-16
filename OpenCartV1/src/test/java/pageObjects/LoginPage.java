package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){super(driver);}

    //Locators
    @FindBy(xpath = "//input[@id='input-email']") WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-password']") WebElement txtPassword;
    @FindBy(xpath = "//*[@value=\"Login\"]") WebElement btnLogin;

    public void setTxtEmail(String email){
        txtPassword.clear();
        txtEmail.sendKeys(email);
    }

    public  void setTxtPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void loginClick(){
        btnLogin.click();
    }

}
