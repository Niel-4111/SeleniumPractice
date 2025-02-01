package org.example.ex_12_DataDrivenTesting;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDataDriven_P1 {


    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin@gmail.com","pass123"},
                new Object[]{"admin1234@gmail.com","pass5667"},
        };
    }

    @Description(" Data Driven Testing Demo")
    @Test(dataProvider  = "getData")
    public void test_login (String email, String password){

        System.out.println(email + " | " + password);



    }



}
