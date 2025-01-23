package org.example.ex_06_Waits;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWait {

    @Description("Verify invalid ID password error message in login page using Explicit Wait")
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

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3000));

        WebElement errorMessage = driver.findElement(By.className("notification-box-description"));
        wait.until(ExpectedConditions.textToBePresentInElement(errorMessage,"Your email, password, IP address or location did not match"));

        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");


       // driver.quit(); //to close the current tab
    }

}
