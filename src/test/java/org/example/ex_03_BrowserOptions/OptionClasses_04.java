package org.example.ex_03_BrowserOptions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class OptionClasses_04 {

    @Test
    public void TestSelenium04() throws Exception {

        EdgeOptions edgeOptions = new EdgeOptions();

        edgeOptions.addArguments("--window-size=1920,1080");
        //edgeOptions.addArguments("--window-size=800,600");
       // edgeOptions.addArguments("--headless");

        WebDriver driver = new EdgeDriver(edgeOptions);
       // driver.manage().window().maximize();
        //driver.get("https://katalon-demo-cura.herokuapp.com/");


        Thread.sleep(3000);
        driver.close(); //to close the current tab
    }
}
