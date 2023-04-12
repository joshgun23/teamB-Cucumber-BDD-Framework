@dbJosh
Feature: As a potential homebuyer

  I want to use the Personal Information
  page of my bank's mortgage application

  Background: Common steps for all scenarios in sign up page
    Given userName1

  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out
