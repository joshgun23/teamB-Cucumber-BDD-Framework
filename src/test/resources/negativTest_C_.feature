@regression
Feature: As a potential homebuyer

  I want to use the Personal Information
  page of my bank's mortgage application

  Background: Common steps for all scenarios in sign up page
    Given userName1

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information first name incoreccet only number, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information first name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information first name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information first name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information Middle name incoreccet only number, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information Middle name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information Middle name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out


  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information Middle name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information Last name incoreccet number and letters, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information Last name incoreccet letters with space, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

  @smoke @negativ
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information Last name letters with charcters more, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out