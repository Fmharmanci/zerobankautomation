package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindTransactionsStepDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {
        new AccountSummary().accountActivity.click();
        new AccountActivity().findTransactions.click();
        Thread.sleep(1000);
    }

    @When("the user enters date range from “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void the_user_enters_date_range_from_to(Integer fromYear, Integer fromMonth, Integer fromDay, Integer toYear, Integer toMonth, Integer toDay) {

        String fromDate = fromYear + "-" + fromMonth + "-" + fromDay;
        String toDate = toYear + "-" + toMonth + "-" + toDay;

        new AccountActivity().fromDateInput.sendKeys(fromDate);
        new AccountActivity().toDateInput.sendKeys(toDate);

    }

    @When("clicks search")
    public void clicks_search() throws InterruptedException {

        new AccountActivity().submitButton.click();

        Thread.sleep(2000);

    }

    @Then("results table should only show transactions dates between “{int}-{int}-{int}” to “{int}-{int}-{int}”")
    public void results_table_should_only_show_transactions_dates_between_to(Integer fromYear, Integer fromMonth, Integer fromDay, Integer toYear, Integer toMonth, Integer toDay) {

        AccountActivity accA = new AccountActivity();
        List<WebElement> dateOfRow = accA.eachDateOfRow;

        System.out.println(dateOfRow.get(1).getText());
        System.out.println(dateOfRow.get(0).getText());
        System.out.println("-----------");

        for (WebElement element : dateOfRow) {
            System.out.println(element.getText());
        }
        boolean x;
        for (int i = 0; i < dateOfRow.size(); i++) {

            String date = dateOfRow.get(i).getText();
            String[] str = date.split("-");

            Integer[] intDate = new Integer[str.length];

            for (int j = 0; j < str.length; j++) {
                intDate[j] = Integer.parseInt(str[j]);
            }

            if (fromYear < intDate[0] && intDate[0] < toYear) {
                x = true;
            } else if (fromYear == intDate[0] && intDate[0] < toYear) {
                if (fromMonth < intDate[1]) {
                    x = true;
                } else if (fromMonth == intDate[1]) {
                    if (fromDay <= intDate[2]) {
                        x = true;
                    } else {
                        x = false;
                    }
                } else {
                    x = false;
                }
            } else if (fromYear < intDate[0] && intDate[0] == toYear) {
                if (toMonth > intDate[1]) {
                    x = true;
                } else if (toMonth == intDate[1]) {
                    if (toDay >= intDate[2]) {
                        x = true;
                    } else {
                        x = false;
                    }
                } else {
                    x = false;
                }
            } else if (fromYear == intDate[0] && intDate[0] == toYear) {
                if (fromMonth < intDate[1] && intDate[1] < toMonth) {
                    x = true;
                } else if (fromMonth == intDate[1] && intDate[1] < toMonth) {
                    if (fromDay <= intDate[2]) {
                        x = true;
                    } else {
                        x = false;
                    }
                } else if (fromMonth < intDate[1] && intDate[1] == toMonth) {
                    if (toDay >= intDate[2]) {
                        x = true;
                    } else {
                        x = false;
                    }
                } else if (fromMonth == intDate[1] && intDate[1] == toMonth) {
                    if (fromDay <= intDate[2] && intDate[2] <= toDay) {
                        x = true;
                    } else {
                        x = false;
                    }
                }
            }else{
                x = false;
            }

        }


        System.out.println("x = " + x);

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
