package org.example.ex_08_JSExecutor_RelativeLocators;

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

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators_P2 {
    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Relative Locators Demo")
    @Test
    public void test_RelativeLocators() throws Exception {


        driver.get("https://www.aqi.in/real-time-most-polluted-city-ranking");

        List<WebElement> search_box = driver.findElements(By.xpath("//input[@type='search']"));
        search_box.get(1).sendKeys("India"+ Keys.ENTER);

        Thread.sleep(3000);
        List<WebElement> all_Locations = driver.findElements(By.cssSelector("div.location-name > p"));
        for( WebElement e:all_Locations){
            System.out.println(e.getText());

            String serial = driver.findElement(with(By.tagName("p")).toLeftOf(e)).getText();
            String aqi = driver.findElement(with(By.tagName("span")).toRightOf(e)).getText();

            System.out.println(serial);
            System.out.println(aqi);
            System.out.println("| " +serial + " | " +e.getText()+" | " +aqi + " | ");

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
