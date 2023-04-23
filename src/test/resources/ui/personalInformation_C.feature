@regression
Feature: As a potential homebuyer

  I want to use the Personal Information
  page of my bank's mortgage application

  Background: Common steps for all scenarios in sign up page
    Given userName1

  Scenario: User selects "Yes" for co-borrower question
    When the user selects for the co-borrower question
    Then an additional section for co-borrower's information is displayed

  @smokeC  @regressionC @positive
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smokeC @regressionC
  Scenario: User reads and accepts Privacy Policy
    When the user reads the Privacy Policy and clicks the checkbox to accept the terms
    Then the checkbox is checked and the user can move forward to the next page of the application

  @smokeC @regressionC
  Scenario: User fills out co-borrower's information
    When the user selects for the co-borrower question
    Then an additional section for co-borrower's information is displayed
    Then the user enters the co-borrower's first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

