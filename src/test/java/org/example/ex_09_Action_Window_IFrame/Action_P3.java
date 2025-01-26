package org.example.ex_09_Action_Window_IFrame;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Action_P3 {


    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }


    @Description("Action clas Demo")
    @Test
    public void test_ActionClass() throws Exception {

        driver.get("https://www.makemytrip.com/");
        driver.getCurrentUrl();
        driver.getTitle();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
        driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fromCity")));
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        Actions actions=new Actions(driver);
        actions.moveToElement(fromCity).click().sendKeys("bangkok").build().perform();

        List<WebElement> list_auto_complete = driver.findElements(By.xpath("//ul[@class='react-autosuggest__suggestions-list']/li"));

        for(WebElement e: list_auto_complete){
            if(e.getText().contains("Bangkok")){
                e.click();
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
