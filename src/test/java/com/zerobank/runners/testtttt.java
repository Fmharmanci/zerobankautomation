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

    }

}
