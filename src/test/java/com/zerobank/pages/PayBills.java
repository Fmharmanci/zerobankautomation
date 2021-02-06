package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBills extends BasePage{

    public PayBills(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "#tabs>ul>li:nth-of-type(2)")
    public WebElement addNewPayee;

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
}
