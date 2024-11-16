package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
    @Test
    public void verify_Login(){
        logger.info("*************** Start TC002_LoginTest ***************");
        try {


            //HomePage
            HomePage hp = new HomePage(driver);

            hp.clickMyAccount();
            logger.info("Clicked on MyAccount Link");
            hp.clickLoginLnk();
            logger.info("Click on Login Link under MyAccount");

            Thread.sleep(CTime);
            //Login Page
            LoginPage lp = new LoginPage(driver);

            lp.setTxtEmail(p.getProperty("email"));
            logger.info("User Entered Email(USERNAME)");
            lp.setTxtPassword(p.getProperty("password"));
            logger.info("User Enter Password");
            lp.loginClick();
            logger.info("User Clicked on Login after entering username and password");
            Thread.sleep(CTime);
            //MyAccount
            MyAccountPage map = new MyAccountPage(driver);
            boolean targetPage = map.verifyMyaccountHeading();
            logger.info("User Login Status :: "+targetPage);
            //Assert.assertEquals(targetPage,true,"Login Failed");
            Assert.assertTrue(targetPage);
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("*************** End TC002_LoginTest ***************");
    }
}
