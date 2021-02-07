

Feature: Check Account Types in Account Summary

  Background:
    Given the user is logged in

  Scenario: Account Summary Page Title
    When The user access the Account Summary Page
    Then Account summary page should have the title Zero - Account Summary

  Scenario: Account Summary Types
    When The user access the Account Summary Page
    Then Account summary page should have to following account type
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts in Account Summary
    When The user access the Account Summary Page
    Then Credit accounts table must have columns
      | Account     |
      | Credit Card |
      | Balance     |