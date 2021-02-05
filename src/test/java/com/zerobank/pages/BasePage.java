package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String getPageSubTitle(){
        return Driver.get().getTitle();
    }


}
