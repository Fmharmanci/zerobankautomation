package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    @FindBy(xpath = "//title")
    public WebElement pageSubTitle;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public String pageSubTitle(){
        return pageSubTitle.getText();
    }

}
