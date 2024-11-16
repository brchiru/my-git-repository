package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccRegisterPage extends BasePage{
    public AccRegisterPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//input[@id=\"input-firstname\"]")
    WebElement txtfirstName;
    @FindBy(xpath="//input[@id=\"input-lastname\"]")
    WebElement txtlastName;
    @FindBy(xpath="//input[@id=\"input-email\"]")
    WebElement txteMail;
    @FindBy(xpath="//input[@id=\"input-telephone\"]")
    WebElement txttelephone;
    @FindBy(xpath="//input[@id=\"input-password\"]")
    WebElement txtpassword;
    @FindBy(xpath="//input[@id=\"input-confirm\"]")
    WebElement txtpasswordConfirm;
    @FindBy(xpath="//input[@name=\"agree\"]")
    WebElement chkboxagree;
    @FindBy(xpath="//input[@value=\"Continue\"]")
    WebElement btncontinue;

    @FindBy(xpath = "//*[@id=\"content\"]/h1")
    WebElement verifyMsg;

    public void setTxtfirstName(String fName) {
        txtfirstName.sendKeys(fName);
    }

    public void setTxtlastName(String lname) {
        txtlastName.sendKeys(lname);
    }

    public void setTxteMail(String eMail) {
        txteMail.sendKeys(eMail);
    }

    public void setTxttelephone(String telephone) {
        txttelephone.sendKeys(telephone);
    }

    public void setTxtpassword(String spassword) {
        txtpassword.sendKeys(spassword);
    }

    public void setTxtpasswordConfirm(String confpassword) {
       txtpasswordConfirm.sendKeys(confpassword);
    }

    public void selectChkboxagree() {
        chkboxagree.isSelected();
        chkboxagree.click();
    }

    public void clickBtncontinue() {
        btncontinue.click();
    }

    public String getVerifyMsg()
    {
        try {
            return (verifyMsg.getText());
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

