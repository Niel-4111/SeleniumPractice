package org.example.ex_01_SeleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test_Selenium01 {

    @Test
    public void TestSelenium01(){
    WebDriver driver = new EdgeDriver();
    driver.get("https://google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());
        driver.manage().window().maximize();
        driver.manage().window().minimize();

    }
}
