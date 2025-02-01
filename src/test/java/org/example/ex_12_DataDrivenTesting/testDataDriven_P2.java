package org.example.ex_12_DataDrivenTesting;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDataDriven_P2 {


    @DataProvider(name ="LoginData", parallel = true)
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin@gmail.com","pass123"},
                new Object[]{"admin1234@gmail.com","pass5667"},
                new Object[]{"admin1@gmail.com","pas67"},
                new Object[]{"admin2@gmail.com","pass5"},
                new Object[]{"admin4@gmail.com","pass656"},
        };
    }

    @DataProvider(name ="LoginData2", parallel = true)
    public Object[][] getData2(){
        return new Object[][]{
                new Object[]{"admin@gmail.com","pass123"},
                new Object[]{"admin1234@gmail.com","pass5667"},
                new Object[]{"admin1@gmail.com","pas67"},
                new Object[]{"admin2@gmail.com","pass5"},
                new Object[]{"admin4@gmail.com","pass656"},
        };
    }

    @Description(" Data Driven Testing Demo")
    @Test(dataProvider  = "LoginData")
    public void test_login (String email, String password){

        System.out.println(email + " | " + password);



    }

    @Test(dataProvider  = "LoginData2")
    public void test_login2 (String email, String password){

        System.out.println(email + " | " + password);



    }



}
