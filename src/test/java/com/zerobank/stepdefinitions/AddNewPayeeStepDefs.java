package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.PayBills;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() throws InterruptedException {
        new AccountSummary().payBills.click();
        Thread.sleep(500);
        new PayBills().addNewPayee.click();
        Thread.sleep(500);
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> userInfo) throws InterruptedException {

        PayBills addNewPaye = new PayBills();

        addNewPaye.newPayeeName.sendKeys(userInfo.get("Payee Name"));
        addNewPaye.newPayeeAdress.sendKeys(userInfo.get("Payee Address"));
        addNewPaye.newPayeeAccount.sendKeys(userInfo.get("Account"));
        addNewPaye.newPayeeDetails.sendKeys(userInfo.get("Payee details"));
        addNewPaye.addButton.click();

    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {

        String expextedMsg = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        String actualMsg = new PayBills().successMsg.getText();

        Assert.assertEquals(expextedMsg,actualMsg);
    }

}
