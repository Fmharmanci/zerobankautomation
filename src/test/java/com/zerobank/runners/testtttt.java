package com.zerobank.runners;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;

public class testtttt {

    @Test
    public void test1() throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));

        new MainPage().signButton.click();
        Thread.sleep(4000);
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }
}
