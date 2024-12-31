package org.example.ex_03_BrowserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class Add_Extension_05 {

    @Test
    public void TestSelenium05() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.addArguments("--window-size=1920,1080");
        //edgeOptions.addArguments("--window-size=800,600");
        // edgeOptions.addArguments("--headless");
        edgeOptions.addExtensions(new File("src/test/java/org/example/ex_03_BrowserOptions/addblocker.crx"));


        WebDriver driver = new EdgeDriver(edgeOptions);
        // driver.manage().window().maximize();
        driver.get("https://youtube.com/");


        Thread.sleep(7000);
        driver.close(); //to close the current tab
    }

}
