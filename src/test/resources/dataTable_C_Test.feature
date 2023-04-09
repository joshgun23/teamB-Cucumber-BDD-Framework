@regression
Feature: As a potential homebuyer

  I want to use the Personal Information
  page of my bank's mortgage application

  Background: Common steps for all scenarios in sign up page
    Given userName1

  @coshgun12
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    When the user enters the personal information
      | Frederic   | Frederic   | Majury      | fmajury0@twitpic.com       | 01051991    |
    Then all required fields positiv are filled out

  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then sulfix "Jr."
    Then all required xpath "Jr." are filled out

  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then Click in sulfix place
    Then i should see following options
      | Jr. |
      | Sr. |
      | II  |
      | III |
      | IV  |

  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then Click in marytal status place
    Then i should see marytal status following options
      | Single    |
      | Married   |
      | Divorced  |
      | Separated |
