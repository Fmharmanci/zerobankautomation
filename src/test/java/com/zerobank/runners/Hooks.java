package com.zerobank.runners;

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
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
        System.out.println("End of Part");
    }
//    @After
//    public void tearDown(Scenario scenario) throws InterruptedException {
//
//        if(scenario.isFailed()){
//            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot,"image/png","screenshot");
//        }
//
//        Thread.sleep(2000);
//        Driver.closeDriver();
//
//    }
//
//    @After
//    public void tearDown(){
//        Driver.closeDriver();
//    }

}
