package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {

       new MainPage().signButton.click();
       new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));

    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {

        new AccountSummary().savings1.click();

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {

        Assert.assertTrue(new AccountActivity().pageSubTitle().contains("Account Activity"));
//        String accActivity = new AccountActivity().pageSubTitle();
//        Assert.assertTrue(accActivity.contains("Account Activity"));

    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {

        Select select = new Select(new AccountActivity().accOptionSelect);
        System.out.println("first option = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Savings",select.getFirstSelectedOption().getText());

    }

}
