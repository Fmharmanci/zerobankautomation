package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBills extends BasePage{

    public PayBills(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#tabs>ul>li:nth-of-type(2)")
    public WebElement addNewPayee;

    @FindBy(css = "#tabs>ul>li:nth-of-type(3)")
    public WebElement purchaseFCurrency;

    @FindBy(css = "#np_new_payee_name")
    public WebElement newPayeeName;

    @FindBy(css = "#np_new_payee_address")
    public WebElement newPayeeAdress;

    @FindBy(css = "#np_new_payee_account")
    public WebElement newPayeeAccount;

    @FindBy(css = "#np_new_payee_details")
    public WebElement newPayeeDetails;

    @FindBy(css = "#add_new_payee")
    public WebElement addButton;

    @FindBy(css = "#alert_content")
    public WebElement successMsg;

    @FindBy(css = "#pc_currency>option")
    public List<WebElement> currencyOption;

    @FindBy(css = "#pc_currency")
    public WebElement currencyDropDown;

    @FindBy(css = "#pc_calculate_costs")
    public WebElement calculateButton;

    @FindBy(css = "#pc_amount")
    public WebElement amountInput;

    @FindBy(css = "#sp_amount")
    public WebElement payAmountInput;

    @FindBy(css = "#sp_date")
    public WebElement payDateInput;

    @FindBy(css = "#pay_saved_payees")
    public WebElement payButton;

}
