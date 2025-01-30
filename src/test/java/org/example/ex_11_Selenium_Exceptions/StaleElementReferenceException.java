package org.example.ex_11_Selenium_Exceptions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StaleElementReferenceException {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }


    @Description("StaleElementReferenceException Demo")
    @Test
    public void test_StaleElementReferenceException() throws Exception {

        driver.get("https://google.com");
        WebElement input_Box = driver.findElement(By.id("APjFqb"));
        driver.navigate().refresh();
        input_Box.sendKeys("Youtube.com"+ Keys.ENTER);

        //To handle and fix this exception we have 2 ways.
        //1: handle: surround it with try/catch
        //2. Fix: actual fix is refind the element after refresh

    }


    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}
