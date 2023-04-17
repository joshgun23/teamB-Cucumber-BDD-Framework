#@dbJosh
Feature: Storing Personal Information in Duobank Mortgage Application



  Background: Common steps for all scenarios in sign up page
    Given userName1

  @dbJosh
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    Then The  tbl_mortagage table should have columns named apply_co_borrower, b_firstName,
    When the user enters the personal information page
      | joshgun   | ismayilov   | Majury      | fmajury0@gmail.com       | 01051991    |
    Then A table named tbl_mortagage should store the borrower's and co-borrower’s personal information.



  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    Then The  tbl_mortagage table should have columns named apply_co_borrower, b_firstName,


#  Scenario: Storing Borrower and Co-Borrower Personal Information
#    Then an additional section for personal information  information is displayed
#    When I enter the borrower's information:
#      | First Name | Middle Name | Last Name | Suffix | Email | Date of Birth | SSN | Marital Status | Cell | Home |
#      | John       | M            | Doe       | Mr     | john.doe@email.com | 01/01/1980 | 123-45-6789 | Single | 1234567890 | 9876543210 |
#    And I select "Yes" for co-borrower question
#    And I enter the co-borrower's information:
#      | First Name | Middle Name | Last Name | Suffix | Email | Date of Birth | SSN | Marital Status | Cell | Home |
#      | Jane       | A            | Smith     | Mrs    | jane.smith@email.com | 02/02/1990 | 987-65-4321 | Married | 9876543210 | 1234567890 |
#    And I submit the form
#    Then the borrower's and co-borrower's information should be stored in the "tbl_mortgage" table in the database