@current
Feature: As a potential homebuyer

  I want to use the Personal Information
  page of my bank's mortgage application


  Scenario: User navigates to Personal Information page
    Given userName1
    When password1
    Then login1

#  Scenario 2: User fills out borrower's information
#    Given the user is on the Personal Information page
#    When the user enters their first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
#    Then all required fields are filled out
#
#  Scenario 3: User selects "Yes" for co-borrower question
#    Given the user is on the Personal Information page
#    When the user selects "Yes" for the co-borrower question
#    Then an additional section for co-borrower's information is displayed
#
#  Scenario 4: User fills out co-borrower's information
#    Given the user has selected "Yes" for the co-borrower question and the additional section is displayed
#    When the user enters the co-borrower's first name, last name, email, date of birth, SSN, marital status, cell phone, and home phone
#    Then all required fields are filled out
#
#  Scenario 5: User reads and accepts Privacy Policy
#    Given the user is on the Personal Information page
#    When the user reads the Privacy Policy and clicks the checkbox to accept the terms
#    Then the checkbox is checked and the user can move forward to the next page of the application
#
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
