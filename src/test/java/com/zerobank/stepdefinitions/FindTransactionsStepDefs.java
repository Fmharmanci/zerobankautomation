package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {
        new AccountSummary().accountActivity.click();
        new AccountActivity().findTransactions.click();
        Thread.sleep(1000);
        }

    @When("the user enters date range from “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void the_user_enters_date_range_from_to(Integer fromYear, Integer fromMonth, Integer fromDay, Integer toYear, Integer toMonth, Integer toDay) throws InterruptedException {


        System.out.println("fromYear = " + fromYear);
        System.out.println("fromMonth = " + fromMonth);
        System.out.println("fromDay = " + fromDay);
        System.out.println("toYear = " + toYear);
        System.out.println("toMonth = " + toMonth);
        System.out.println("toDay = " + toDay);

//        new AccountActivity().fromDateInput.sendKeys(fromDate);
//        new AccountActivity().toDateInput.sendKeys(toDate);
//        new AccountActivity().submitButton.click();
//        Thread.sleep(3000);

    }

    @When("clicks search")
    public void clicks_search() {

        new AccountActivity().submitButton.click();

        }

    @Then("results table should only show transactions dates between “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void results_table_should_only_show_transactions_dates_between_to(Integer int1, Integer int2, Integer int3, Integer int4, Integer int5, Integer int6) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the results table should only not contain transactions dated “{int}-{int}-{int}”")
    public void the_results_table_should_only_not_contain_transactions_dated(Integer int1, Integer int2, Integer int3) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
