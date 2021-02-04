package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountActivity extends BasePage{

    public AccountActivity(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "accountId")
    public WebElement accOptionSelect;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransactions;
}
