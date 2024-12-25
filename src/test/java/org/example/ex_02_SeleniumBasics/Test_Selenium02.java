package org.example.ex_02_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Selenium02 {


    @Test
    public void TestSelenium02(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        driver.manage().window().maximize();
        Assert.assertEquals(driver.getTitle(), "Google");

    }
}
