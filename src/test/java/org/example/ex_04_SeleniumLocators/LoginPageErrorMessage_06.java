package org.example.ex_04_SeleniumLocators;

import io.qameta.allure.Description;
import org.checkerframework.common.util.count.report.qual.ReportCreation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageErrorMessage_06 {

    @Description("Verify invalid ID password error message in login page")
    @Test
    public void NegativeLoginTC() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");

        WebElement passInputBox = driver.findElement(By.name("password"));
        passInputBox.sendKeys("Test12345");

        WebElement submitButton = driver.findElement(By.id("js-login-btn"));
        submitButton.click();
        Thread.sleep(2500);

        WebElement errorMessage = driver.findElement(By.className("notification-box-description"));
        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");

        WebElement a_TagFreeTrial = driver.findElement(By.linkText("Start a free trial"));
        a_TagFreeTrial.click();

        Thread.sleep(2000);
        driver.quit(); //to close the current tab
    }

}
