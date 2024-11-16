package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {
    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    //getting dataprovide from different class
    public void verify_loginDDT(String email, String pwd, String expResult) throws InterruptedException {
        try {

            logger.info("***************Starting TC003 Login Data Driven Test Case**********");
            //HomePage
            HomePage hp = new HomePage(driver);

            hp.clickMyAccount();
            logger.info("Clicked on MyAccount Link");
            hp.clickLoginLnk();
            logger.info("User Clicks on Myaccount - Login");

            Thread.sleep(CTime);
            //LoginPage
            logger.info("User landed on LoginPage");
            LoginPage lp = new LoginPage(driver);

            logger.info("User enter username...");
            lp.setTxtEmail(email);
            logger.info("User enter Password...");
            lp.setTxtPassword(pwd);

            lp.loginClick();
            logger.info("User clicked on Login Button");
            Thread.sleep(CTime);
            //MyAccountPage
            MyAccountPage map = new MyAccountPage(driver);

            boolean targetPage = map.verifyMyaccountHeading();

            if (expResult.equalsIgnoreCase("Valid")) {
                if (targetPage == true) {
                    map.btnLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }
            if (expResult.equalsIgnoreCase("Invalid")) {
                if (targetPage == true) {
                    map.btnLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail();
        }

        logger.info("***************End TC003 Login Data Driven Test Case**********");
    }
}
