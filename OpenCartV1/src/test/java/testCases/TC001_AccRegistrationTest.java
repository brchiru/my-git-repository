package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccRegisterPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccRegistrationTest extends BaseClass {
    @Test
    public void verify_account_registration() throws InterruptedException
    {
        logger.info("*************** Starting TC001_AccRegistrationTest ************");
        try{
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on MyAccount Link");
            hp.clickRegisterLnk();
            logger.info("Clicked on Register Link");
            Thread.sleep(CTime);
            AccRegisterPage regpage = new AccRegisterPage(driver);
            regpage.setTxtfirstName(randString().toUpperCase());
            regpage.setTxtlastName(randString().toUpperCase());
            regpage.setTxteMail(randString()+"@EFGH.COM");
            regpage.setTxttelephone(randNum());

            String pwds = randAlpNum();

            regpage.setTxtpassword(pwds);
            regpage.setTxtpasswordConfirm(pwds);
            regpage.selectChkboxagree();

            logger.info("Updated all the text fields and checkbox to Register");
            regpage.clickBtncontinue();

            logger.info("User clicked on Continue Button");
            Thread.sleep(CTime);

            String confirmationMsg = regpage.getVerifyMsg();
            logger.info("Recieved Verification message for Account Creation:: "+confirmationMsg);
            if(confirmationMsg.equals("Your Account Has Been Created!"))
            {
                Assert.assertTrue(true);
                logger.info("*************** End of TC001_AccRegistrationTest ************");
            }
            else
            {
                logger.info("Test FAILED");
                logger.debug("Debug Logs");
                logger.info("*************** End of TC001_AccRegistrationTest with FAIL ************");
                Assert.assertTrue(false);
            }
            //Assert.assertEquals(confirmationMsg,"Your Account Has Been Created!");

        } catch (Exception e) {
            Assert.fail();
        }
    }
}
