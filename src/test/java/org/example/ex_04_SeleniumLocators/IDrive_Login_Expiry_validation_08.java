package org.example.ex_04_SeleniumLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IDrive_Login_Expiry_validation_08 {

    @Description("Verify account expiry notification from iDriver site")
    @Test
    public void Account_expiry() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.idrive360.com/enterprise/login");

        Thread.sleep(2000);

        WebElement username_InputBox = driver.findElement(By.xpath("//input[@id='username']"));
        username_InputBox.sendKeys("augtest_040823@idrive.com");

        WebElement pass_InputBox = driver.findElement(By.xpath("//input[@id='password']"));
        pass_InputBox.sendKeys("123456");

        WebElement signin_Button = driver.findElement(By.xpath("//button[@id='frm-btn']"));
        signin_Button.click();
        Thread.sleep(10000);
/*
        WebElement errorMessage = driver.findElement(By.xpath("//h5[contains(text(), 'expired')]"));
         Assert.assertEquals(errorMessage.getText(),"Your free trial has expired");*/

        WebElement header = driver.findElement(By.xpath("//h5[text()='Your free trial has expired']"));
        if(header.isDisplayed()){
            System.out.println("Account free trial is Expired");
        }
        else{
            System.out.println("Account is active or something went wrong");
        }
        Thread.sleep(3000);
        driver.quit(); //to close the current tab
    }

}
