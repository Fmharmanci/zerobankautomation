@mmm
Feature: Account Activity Functionality

  Background:
    Given the user is logged in

  Scenario: Account Activity Page Title
    When The user access the Account Activity Page
    Then Account activity page should have the title Zero - Account Activity

  Scenario: Dropdown Default Option
    When The user access the Account Activity Page
    Then Account drop down default option should be Savings

  Scenario: Dropdown Options
    When The user access the Account Activity Page
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: Transactions Tables
    When The user access the Account Activity Page
    Then Transactions table should have columns names
    |Date|
    |Description|
    |Deposit|
    |Withdrawal|