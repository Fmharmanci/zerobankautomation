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


        new AccountSummary().accountActivity.click();
        AccountActivity aa = new AccountActivity();
        aa.findTransactions.click();
        Thread.sleep(2000);
//        aa.desciptionInput.sendKeys("asdasdasd");
//        aa.toDateInput.click();
        String asd1 = String.valueOf(2012);
        String asd2 = String.valueOf(09);
        String asd3 = new Integer(01).toString();
        String asd = asd1+"-0"+asd2+"-"+asd3;
        String asd4 = new Integer(06).toString();
        String asdd = asd1+"-0"+asd2+"-"+asd4;
        System.out.println("asd = " + asd);
        System.out.println("asdd = " + asdd);

        aa.fromDateInput.sendKeys(asd);
        aa.toDateInput.sendKeys(asdd);
//        aa.fromDateInput.click();

        aa.submitButton.click();
    }
}
