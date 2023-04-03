@coshgun
Feature: As a potential homebuyer

  I want to use the Personal Information
  page of my bank's mortgage application

  Background: Common steps for all scenarios in sign up page
    Given userName1
#    When password1
#    Then login1
#    Then check to personal infomation place

#  Scenario: User navigates to Personal Information page
#    Given userName1
#    When password1
#    Then login1
#    Then check to personal infomation place

  Scenario: User selects "Yes" for co-borrower question
#    Given the user is on the Personal Information page
    When the user selects for the co-borrower question
    Then an additional section for co-borrower's information is displayed
#
#  @personal
  Scenario: User fills out Personal Information information
    Then an additional section for personal information  information is displayed
    Then the user enters the personal information first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out
@smoke @regression
  Scenario: User reads and accepts Privacy Policy
    When the user reads the Privacy Policy and clicks the checkbox to accept the terms
    Then the checkbox is checked and the user can move forward to the next page of the application
  @regression
  Scenario: User fills out co-borrower's information
    When the user selects for the co-borrower question
    Then an additional section for co-borrower's information is displayed
    Then the user enters the co-borrower's first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
    Then all required fields are filled out

#  Scenario 6: User navigates to next page
#    Given the user has filled out all required fields and accepted the Privacy Policy
#    When the user clicks the "Next" button
#    Then the user is directed to the next page of the loan application
#
#  Scenario 7: User navigates back to previous page
#    Given the user has filled out all required fields and accepted the Privacy Policy
#    When the user clicks the "Previous" button
#    Then the user is directed back to the previous page of the loan application
#
#  Scenario 8: User submits incomplete form
#    Given the user is on the Personal Information page
#    When the user attempts to move forward to the next page without filling out all required fields and accepting the Privacy Policy
#    Then an error message is displayed prompting the user to complete all required fields and accept the Privacy Policy checkbox.
