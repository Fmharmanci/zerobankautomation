package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummary extends BasePage{

    @FindBy(xpath = "//tr[1]//a[text()='Savings']")
    public WebElement savings1;

    @FindBy(xpath = "//tr[2]//a[text()='Savings']")
    public WebElement savings2;

    @FindBy(xpath = "//tr[1]//a[text()='Brokerage']")
    public WebElement brokerage;

    @FindBy(xpath = "//tr[1]//a[text()='Checking']")
    public WebElement checking;

    @FindBy(xpath = "//tr[2]//a[text()='Credit Card']")
    public WebElement creditCard;

    @FindBy(xpath = "//tr[1]//a[text()='Loan']")
    public WebElement loan;
}
