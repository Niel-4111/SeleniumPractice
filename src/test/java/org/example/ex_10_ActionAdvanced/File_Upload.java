package org.example.ex_10_ActionAdvanced;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class File_Upload {

    WebDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }


    @Description("File Upload Demo")
    @Test
    public void test_FileUpload() throws Exception {

        driver.get("https://awesomeqa.com/selenium/upload.html");

        WebElement file_Upload = driver.findElement(By.name("fileToUpload"));

        //file_Upload.sendKeys("src/test/java/org/example/ex_10_ActionAdvanced/testdata.txt");

        String working_Dir = System.getProperty("user.dir");
        System.out.println(working_Dir);
        file_Upload.sendKeys(working_Dir +"/src/test/java/org/example/ex_10_ActionAdvanced/testdata.txt");

        WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));
        submit.click();


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
