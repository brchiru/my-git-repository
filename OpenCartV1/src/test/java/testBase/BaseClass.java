package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    //public ChromeOptions options;
    public Logger logger;
    public Properties p;

    public long CTime = 2000;

    @BeforeClass
    @Parameters({"os","browser"})
    public void setUp(String ostype,String br) throws InterruptedException, IOException {
        //Loding config.properties
        FileReader file = new FileReader("./src/test/resources/config.properties");
        p=new Properties();
        p.load(file);

        logger = LogManager.getLogger(this.getClass());
        //driver = new SafariDriver();

        switch (br.toLowerCase())
        {
            case "chrome" : driver = new ChromeDriver(); Thread.sleep(1000);break;
            case "safari" : driver = new SafariDriver(); break;
            default: System.out.println("Invalid Browser...!"); return;
        }

        //options = new ChromeOptions();
        //options.addArguments("--headless=new");
        //driver = new ChromeDriver(options);
        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //driver.get("https://tutorialsninja.com/demo/");
        //driver.get("https://www.costco.co.uk/");
        driver.get(p.getProperty("appURL")); // Reading URL from properties file


        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(CTime);
        driver.quit();
    }

    public String randString(){
        String randomString = RandomStringUtils.randomAlphabetic(5);
        return randomString;
    }
    public String randNum(){
        String randomNo = RandomStringUtils.randomNumeric(10);
        return randomNo;
    }
    public String randAlpNum(){
        String randomAlp = RandomStringUtils.randomAlphabetic(4);
        String randomNos = RandomStringUtils.randomNumeric(3);
        return (randomAlp+"@"+randomNos);
    }
}
