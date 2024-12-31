package org.example.ex_02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyURLAndHeading_03 {

    @Test
    public void TestSelenium02() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        if(driver.getPageSource().contains("CURA Healthcare Service")){
            System.out.println("CURA Healthcare Service is visible");
            Assert.assertTrue(true);
        }
        else {
            throw new Exception("CURA Healthcare Service is not visible");
        }
        Thread.sleep(3000);
        driver.close(); //to closed the current tab
        driver.quit(); //to close the all tabs i.e. close browser instance
    }
}
