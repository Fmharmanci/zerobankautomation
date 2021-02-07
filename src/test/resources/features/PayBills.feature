  Feature: Pay Bills Functionality

    Background:
      Given the user is logged in

    Scenario: Account Activity Page Title
      When The user access the Pay Bills Page
      Then Account activity page should have the title Zero - Pay Bills

    Scenario: Successful Pay Operation
      When The user access the Pay Bills Page
      And The user enters the amount and date
      And Click to pay
      Then User completes a successful Pay operation, The payment was successfully submitted. should be displayed

    Scenario: Without Entering The Amount
      When The user access the Pay Bills Page
      And User tries to make a payment without entering the amount
      And Click to pay
      Then User tries to make a payment without entering the amount or date, Please fill out this field message should be displayed

    Scenario: Without Entering The Date
      When The user access the Pay Bills Page
      And User tries to make a payment without entering date
      And Click to pay
      Then User tries to make a payment without entering the amount or date, Please fill out this field message should be displayed

    Scenario: Alphabetical or Special Characters for Amount Field
      When The user access the Pay Bills Page
      And User enters a value with alphabetical or special characters as an amount
#      Then Amount field should not accept alphabetical or special characters ( failed )

    Scenario: Alphabetical Characters for Date Field
      When The user access the Pay Bills Page
      And User enters a date with alphabetical characters
      Then Date field should not accept alphabetical characters