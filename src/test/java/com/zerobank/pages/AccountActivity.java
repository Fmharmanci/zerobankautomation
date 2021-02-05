package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivity extends BasePage{

    public AccountActivity(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(name = "accountId")
    public WebElement accOptionSelect;

    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDateInput;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDateInput;

    @FindBy(xpath = "//div/button")
    public WebElement submitButton;

    @FindBy(css = "#aa_description")
    public WebElement desciptionInput;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    public List<WebElement> eachDateOfRow;


}
