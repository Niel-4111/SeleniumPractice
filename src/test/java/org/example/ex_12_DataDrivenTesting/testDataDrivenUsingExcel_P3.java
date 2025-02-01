package org.example.ex_12_DataDrivenTesting;

import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testDataDrivenUsingExcel_P3 {



    @Description(" Data Driven Testing using excel Demo")
    @Test(dataProvider  = "getData",dataProviderClass = UtilExcel.class)
    public void test_login (String email, String password){

        System.out.println("Email - " + email);
        System.out.println("Password - " + password);

    }



}
