package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() throws InterruptedException {

        new AccountSummary().payBills.click();
        new PayBills().purchaseFCurrency.click();
        Thread.sleep(500);

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> currencyOption) throws InterruptedException {

        Thread.sleep(500);
        List<String> actualOptions = BrowserUtils.getElementsText(new PayBills().currencyOption);

        for (int i = 0; i < currencyOption.size(); i++) {

            Assert.assertTrue(actualOptions.contains(currencyOption.get(i)));

        }

    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() throws InterruptedException {


        new PayBills().amountInput.sendKeys("999");
        new PayBills().calculateButton.click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Alert alert = Driver.get().switchTo().alert();
        boolean check = (alert.getText().length()>0);
        Assert.assertTrue(check);
        alert.accept();

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

        Select select = new Select(new PayBills().currencyDropDown);
        select.selectByIndex(7);
        new PayBills().calculateButton.click();
    }

}
