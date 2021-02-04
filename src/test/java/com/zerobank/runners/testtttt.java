package com.zerobank.runners;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class testtttt {

    @Test
    public void test1() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
//        Driver.get().manage().window().maximize();
        new MainPage().signButton.click();
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));


//        Need Pass to security ( 2 steps )
        Driver.get().findElement(By.id("details-button")).click();
        Driver.get().findElement(By.id("proceed-link")).click();


    }

    @Test
    public void test2(){

        String ss = String.valueOf(09);
        Integer x = 09 + 10;
        Byte y = 08;
        Long l = 09;
        Short s = 08;
        Double d = 08;

        String.valueOf(x);
        System.out.println(x);

        int i = 09;
    }

}
