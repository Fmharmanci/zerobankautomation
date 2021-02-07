package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDefs {

    @When("The user access the Account Summary Page")
    public void the_user_access_the_Account_Summary_Page() {

        String currentTitle = Driver.get().getTitle();
        String expextedTitle = "Account Summary";

        Assert.assertTrue(currentTitle.contains(expextedTitle));

    }

    @Then("Account summary page should have the title Zero - Account Summary")
    public void account_summary_page_should_have_the_title_Zero_Account_Summary() {

        String currentTitle = Driver.get().getTitle();
        String expextedTitle = "Zero - Account Summary";

        Assert.assertTrue(currentTitle.contains(expextedTitle));

    }

    @Then("Account summary page should have to following account type")
    public void account_summary_page_should_have_to_following_account_type(List<String> dataTable) {

        List<String> actualTypes = BrowserUtils.getElementsText(new AccountSummary().accTypes);

        Assert.assertEquals(actualTypes,dataTable);

    }

    @Then("Credit accounts table must have columns")
    public void credit_accounts_table_must_have_columns(List<String> dataTable) {

        List<String> actualColumnsTypes = BrowserUtils.getElementsText(new AccountSummary().headersCreditAcc);

        Assert.assertEquals(actualColumnsTypes,dataTable);

    }
}
