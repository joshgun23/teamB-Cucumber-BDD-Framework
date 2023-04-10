@eric
Feature: As a user, I want to use the Summary page functionality and all edit buttons
  connected correctly and able to click submit button

  Scenario: User signs in and go to loan application
    Given the user is on the sign in page
    When the user entering a information
    And user clicks on the sign in button
    Then user enters loan application page



  Scenario: Verify the summary page functionality
    Given user on the mortgageSummary page
    When user enters preapproval page
    And all required fields are filled out information
    Then able to click summary page
    And user can see edit buttons


  Scenario: Edit button's functionality
    When user can click edit button
    And user back to the relevant page
    Then clicking the Submit button should submit the application


