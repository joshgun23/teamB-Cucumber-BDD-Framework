@testc
Feature: As a potential homebuyer

  I want to use the Personal Information
  page of my bank's mortgage application

  Background: Common steps for all scenarios in sign up page
    Given userName1
#    Then all required fields are filled out

  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then sulfix "Jr."
    Then all required xpath "Jr." are filled out

  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then sulfix "III"
    Then all required xpath "III" are filled out

  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then sulfix "IV"
    Then all required xpath "IV" are filled out