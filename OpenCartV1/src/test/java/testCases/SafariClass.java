package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class SafariClass {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new SafariDriver();
//        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.quit();
    }

}
