package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummary extends BasePage{

    @FindBy(xpath = "//tr[1]//a[text()='Savings']")
    public WebElement savings1;
}
