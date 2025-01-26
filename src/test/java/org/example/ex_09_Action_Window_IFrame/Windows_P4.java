package org.example.ex_09_Action_Window_IFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Windows_P4 {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }


    @Description("Windows Demo")
    @Test
    public void test_Windows() throws Exception {

        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindow =driver.getWindowHandle();
        System.out.println("Parent Window: " +parentWindow);

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("Window Handles: "+windowHandles);

        for (String handle:windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getPageSource().contains("New window")) {
                System.out.println("Test passed");
                break;
            }
        }

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
