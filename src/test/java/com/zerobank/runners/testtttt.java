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

        new MainPage().signButton.click();
//        Thread.sleep(4000);
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));


//        Need Pass to security ( 2 steps )
        Driver.get().findElement(By.id("details-button")).click();
        Driver.get().findElement(By.id("proceed-link")).click();


        new AccountSummary().savings1.click();
        Thread.sleep(2000);

        System.out.println(Driver.get().getTitle());
        Assert.assertTrue(Driver.get().getTitle().contains("Account Activity"));

        Select select = new Select(new AccountActivity().accOptionSelect);
        System.out.println("first option = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Savings", select.getFirstSelectedOption().getText());

    }
}
