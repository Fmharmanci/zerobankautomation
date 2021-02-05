package com.zerobank.stepdefinitions;

import com.zerobank.pages.MainPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Mecnun Deniz is starting the test");
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @After
    public void tearDown(Scenario scenario) throws InterruptedException {

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        System.out.println("Tested...");
       Driver.closeDriver();

    }


}

