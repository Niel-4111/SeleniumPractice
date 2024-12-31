package org.example.ex_04_SeleniumLocators;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Katalon_Login_Page_07 {

    @Description("Make appointment in Katalon login page")
    @Test
    public void LoginAppointment() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement make_Appointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        make_Appointment.click();

        Thread.sleep(2000);

        WebElement username_InputBox = driver.findElement(By.xpath("//input[@id='txt-username']"));
        username_InputBox.sendKeys("John Doe");

        WebElement pass_InputBox = driver.findElement(By.xpath("//input[@id='txt-password']"));
        pass_InputBox.sendKeys("ThisIsNotAPassword");

        WebElement login_Button = driver.findElement(By.xpath("//button[@id='btn-login']"));
        login_Button.click();
        Thread.sleep(2500);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");

        Thread.sleep(2000);
        driver.quit(); //to close the current tab
    }

}
