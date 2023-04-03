@Expense
  Feature: As a potential homebuyer

  I want to use the homebuyer's expenses
  page of  bank's mortgage application


    Scenario User selects "Rent" from question
    Given the user is on the Expenses page
    When the user selects "Rent" button from question
    Then another section payment is displayed


  Scenario User enters Monthly Rent Expenses
    Given the user is on the Expenses page
    When the user enter the rent amount
    Then the user should not see message "This field is required"


  Scenario  User should click "save" button
    Given the user is on Expenses page
    When user choose "save" button
    Then  all required fields are filled out

