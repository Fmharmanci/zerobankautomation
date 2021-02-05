package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
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

        new AccountActivity().fromDateInput.clear();
        new AccountActivity().fromDateInput.sendKeys(fromDate);
        new AccountActivity().toDateInput.clear();
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


        for (int i = 0; i < dateOfRow.size(); i++) {
//            String x = "";
            String date = dateOfRow.get(i).getText();
            String[] str = date.split("-");

            Integer[] intDate = new Integer[str.length];

            for (int j = 0; j < str.length; j++) {
                intDate[j] = Integer.parseInt(str[j]);
            }

            LocalDate start = LocalDate.of(fromYear, fromMonth, fromDay);
            LocalDate end = LocalDate.of(toYear, toMonth, toDay);
            LocalDate current = LocalDate.of(intDate[0], intDate[1], intDate[2]);

            boolean check = ((current.equals(start) || current.isAfter(start)) && (current.isBefore(end) || current.isEqual(end)));

//            System.out.println("current = " + current);
//            System.out.println("start = " + start);
//            System.out.println("end = " + end);
//            System.out.println("check = " + check);
//            System.out.println("------------------------------");

            Assert.assertTrue(check);

//            if (fromYear < intDate[0] && intDate[0] < toYear) {
//                x = "true";
//            } else if (fromYear.equals(intDate[0]) && intDate[0] < toYear) {
//                if (fromMonth < intDate[1]) {
//                    x = "true";
//                } else if (fromMonth.equals(intDate[1])) {
//                    if (fromDay <= intDate[2]) {
//                        x = "true";
//                    } else {
//                        x = "false";
//                    }
//                } else {
//                    x = "false";
//                }
//            } else if (fromYear < intDate[0] && toYear.equals(intDate[0])) {
//                if (toMonth > intDate[1]) {
//                    x = "true";
//                } else if (toMonth.equals(intDate[1])) {
//                    if (toDay >= intDate[2]) {
//                        x = "true";
//                    } else {
//                        x = "false";
//                    }
//                } else {
//                    x = "false";
//                }
//            } else if (fromYear.equals(intDate[0]) && toYear.equals(intDate[0])) {
//                if (fromMonth < intDate[1] && intDate[1] < toMonth) {
//                    x = "true";
//                } else if (fromMonth.equals(intDate[1]) && intDate[1] < toMonth) {
//                    if (fromDay <= intDate[2]) {
//                        x = "true";
//                    } else {
//                        x = "false";
//                    }
//                } else if (fromMonth < intDate[1] && toMonth.equals(intDate[1])) {
//                    if (toDay >= intDate[2]) {
//                        x = "true";
//                    } else {
//                        x = "false";
//                    }
//
//                } else if (fromMonth.equals(intDate[1]) && toMonth.equals(intDate[1])) {
//                    if (fromDay <= intDate[2] && intDate[2] <= toDay) {
//                        x = "true";
//                    } else {
//                        x = "false";
//                    }
//                }else{
//                    x = "false";
//                }
//            }else{
//                x = "false";
//            }

//            System.out.println("x = " + x);

//            Assert.assertEquals("true",x);
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        AccountActivity accA = new AccountActivity();
        List<WebElement> dateOfRow = accA.eachDateOfRow;

        LocalDate[] ld = new LocalDate[dateOfRow.size()];

        for (int i = 0; i < dateOfRow.size(); i++) {
            String date = dateOfRow.get(i).getText();
            String[] str = date.split("-");

            Integer[] intDate = new Integer[str.length];

            for (int j = 0; j < str.length; j++) {
                intDate[j] = Integer.parseInt(str[j]);
            }

            ld[i] = LocalDate.of(intDate[0], intDate[1], intDate[2]);

        }

        boolean check;

        for (int i = 0; i < ld.length - 1; i++) {

            check = (ld[i].isEqual(ld[i + 1]) || ld[i].isAfter(ld[i + 1]));

            Assert.assertTrue(check);

        }

    }

    @Then("the results table should only not contain transactions dated “{int}-{int}-{int}”")
    public void the_results_table_should_only_not_contain_transactions_dated(Integer year, Integer month, Integer day) {

        AccountActivity accA = new AccountActivity();
        List<WebElement> dateOfRow = accA.eachDateOfRow;

        LocalDate[] ld = new LocalDate[dateOfRow.size()];

        for (int i = 0; i < dateOfRow.size(); i++) {
            String date = dateOfRow.get(i).getText();
            String[] str = date.split("-");

            Integer[] intDate = new Integer[str.length];

            for (int j = 0; j < str.length; j++) {
                intDate[j] = Integer.parseInt(str[j]);
            }

            ld[i] = LocalDate.of(intDate[0], intDate[1], intDate[2]);

        }

        LocalDate trDate = LocalDate.of(year, month, day);

        boolean check = false;

        for (int i = 0; i < ld.length; i++) {

            if (trDate.isEqual(ld[i])) {
                check = false;
            }else{
                check = true;
            }

//            System.out.println("ld[i] = " + ld[i]);
        }

//        System.out.println("check = " + check);
        Assert.assertTrue(check);

    }
}
