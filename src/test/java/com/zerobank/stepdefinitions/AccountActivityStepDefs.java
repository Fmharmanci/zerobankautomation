package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() throws InterruptedException {

        Driver.get().get(ConfigurationReader.get("url"));
        new MainPage().signButton.click();
        new LoginPage().login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));

//        **  == Just try something ==  **
//        Driver.get().get(ConfigurationReader.get("url"));
//        new MainPage().signButton.click();
//        String username = ConfigurationReader.get("username");
//        String password = ConfigurationReader.get("password");
//        new LoginPage().login(username,password);
//        **  == Just try something ==  **


//          For pass to security FOR CHROME ( 2 Steps )
        Driver.get().findElement(By.id("details-button")).click();
        Driver.get().findElement(By.id("proceed-link")).click();

    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() throws InterruptedException {

        new AccountSummary().savings1.click();

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {

        Assert.assertTrue(Driver.get().getTitle().contains("Account Activity"));

//        String accActivity = new AccountActivity().pageSubTitle();
//        Assert.assertTrue(accActivity.contains("Account Activity"));

    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {

        Select select = new Select(new AccountActivity().accOptionSelect);
        System.out.println("first option = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Savings", select.getFirstSelectedOption().getText());

    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        new AccountSummary().brokerage.click();
    }

    @Then("Account	drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        Select select = new Select(new AccountActivity().accOptionSelect);
        System.out.println("first option = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Brokerage", select.getFirstSelectedOption().getText());
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        new AccountSummary().checking.click();
    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        Select select = new Select(new AccountActivity().accOptionSelect);
        System.out.println("first option = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Checking", select.getFirstSelectedOption().getText());
    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        new AccountSummary().creditCard.click();
    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        Select select = new Select(new AccountActivity().accOptionSelect);
        System.out.println("first option = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Credit Card", select.getFirstSelectedOption().getText());
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        new AccountSummary().loan.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        Select select = new Select(new AccountActivity().accOptionSelect);
        System.out.println("first option = " + select.getFirstSelectedOption().getText());
        Assert.assertEquals("Loan", select.getFirstSelectedOption().getText());
    }

}
