package org.example.ex_07_Alerts;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
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

public class AlertHanding {

    @Description("Handle Alerts")
    @Test
    public void test_AlertHanding() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");

        WebElement show_alert_box = driver.findElement(By.xpath("//input[@onclick='show_alert()']"));
        show_alert_box.click();
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(3));

        Alert alert = driver.switchTo().alert();
        wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();

        String text = driver.findElement(By.xpath("//p[@id='alertexplanation']")).getText();
        Assert.assertEquals(text,"You triggered and handled the alert dialog");


        driver.quit();
    }

}
