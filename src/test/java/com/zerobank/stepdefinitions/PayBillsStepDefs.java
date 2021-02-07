package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillsStepDefs {

    @When("The user access the Pay Bills Page")
    public void the_user_access_the_Pay_Bills_Page() {

        new AccountSummary().payBills.click();

    }

    @Then("Account activity page should have the title Zero - Pay Bills")
    public void account_activity_page_should_have_the_title_Zero_Pay_Bills() {

        String currentTitle = Driver.get().getTitle();
        String expextedTitle = "Zero - Pay Bills";

        Assert.assertTrue(currentTitle.contains(expextedTitle));

    }

    @When("The user enters the amount and date")
    public void the_user_enters_the_amount_and_date() {

        String amount = "456";
        String date = "2022-02-02";

        new PayBills().payAmountInput.sendKeys(amount);
        new PayBills().payDateInput.sendKeys(date);

    }

    @When("Click to pay")
    public void click_to_pay() {
        new PayBills().payButton.click();
    }

    @Then("User completes a successful Pay operation, The payment was successfully submitted. should be displayed")
    public void user_completes_a_successful_Pay_operation_The_payment_was_successfully_submitted_should_be_displayed() {

        String actual = new PayBills().successMsg.getText();
        String expexted = "The payment was successfully submitted.";

        Assert.assertEquals(actual,expexted);

    }

    @When("User tries to make a payment without entering the amount")
    public void user_tries_to_make_a_payment_without_entering_the_amount() {

        String date = "2022-02-02";
        new PayBills().payDateInput.sendKeys(date);

    }

    @Then("User tries to make a payment without entering the amount or date, Please fill out this field message should be displayed")
    public void user_tries_to_make_a_payment_without_entering_the_amount_or_date_Please_fill_out_this_field_message_should_be_displayed() {

        String actualMsg = "";

        actualMsg = new PayBills().payAmountInput.getAttribute("validationMessage");
        if(actualMsg.equals("")){
            actualMsg = new PayBills().payDateInput.getAttribute("validationMessage");
        }

        String expectedMsg = "Lütfen bu alanı doldurun.";

        Assert.assertEquals(actualMsg,expectedMsg);

    }

    @When("User tries to make a payment without entering date")
    public void user_tries_to_make_a_payment_without_entering_date() {

        String amount = "456";
        new PayBills().payAmountInput.sendKeys(amount);

    }

    @When("User enters a value with alphabetical or special characters as an amount")
    public void user_enters_a_value_with_alphabetical_or_special_characters_as_an_amount() throws InterruptedException {

    String a,b,c;
    a = "asd";
    b = "#$%";
    c = "As@$";

    new PayBills().payAmountInput.sendKeys(a + b + c);
    new PayBills().payAmountInput.sendKeys("AaSs#@");

    }

    @Then("Amount field should not accept alphabetical or special characters")
    public void amount_field_should_not_accept_alphabetical_or_special_characters() throws InterruptedException {


        Assert.assertTrue(new PayBills().payAmountInput.getAttribute("value").isEmpty());

        // failed .... ( bacause can be written )
    }

    @When("User enters a date with alphabetical characters")
    public void user_enters_a_date_with_alphabetical_characters() {

        new PayBills().payDateInput.sendKeys("AaSsDd");

    }

    @Then("Date field should not accept alphabetical characters")
    public void date_field_should_not_accept_alphabetical_characters() {

        Assert.assertTrue(new PayBills().payDateInput.getAttribute("value").isEmpty());

    }

}
