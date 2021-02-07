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

    @FindBy(css = "#aa_accountId>option")
    public List<WebElement> accOptions;

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

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[2]")
    public List<WebElement> eachDescrOfRow;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[3]")
    public List<WebElement> eachDepositOfRow;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[4]")
    public List<WebElement> eachWithdrawOfRow;

    @FindBy(css = "#aa_type")
    public WebElement typeOption;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> headersTransaction;

}
