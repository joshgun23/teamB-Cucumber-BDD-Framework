@DB
Feature: Storing Personal Information in Duobank Mortgage Application UI TO DB



  Background: Common steps for all scenarios in sign up page
    Given userName1

  @DB_C
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    Then The  tbl_mortagage table should have columns named apply borrower, b_firstName,
    When the user enters the personal information page
      | joshgun   | ismayilov   | Majury      | teamb@gmail.com       | 01051991    |
    Then A table named tbl_mortagage should store the borrower's information

  @DB_C
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    Then The  tbl_mortagage table should have columns named apply_co_borrower, b_firstName,
    Then A table named tbl_mortagage should store the co_borrower's information

  @DB_C
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    Then The  tbl_mortagage table should have columns correct borrower, email adress
    Then A table named tbl_mortagage should store the correct borrower, email adress information

  @DB_C
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    Then The  b_marital column should only contain the values Single, Married, or Divorced.
    Then A table named tbl_mortagage should store the correct borrower, marytal status information

  @DB_C
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    Then The  tbl_mortagage table should have columns named apply borrower, b_firstName,

  @DB_C
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    Then The  tbl_mortagage table should have columns named apply borrower, b_firstName,
    When the user enters the personal information page
      | joshgun   | ismayilov   | Majury      | teamb@gmail.com       | 01051991    |
    Then A table named tbl_mortagage should store should match borrower's information

  @DB_C
  Scenario: Storing Borrower and Co-Borrower Personal Information UPDATE
    When the user enters the personal information page
      | joshgun   | ismayilov   | Majury      | afterupdate@gmail.com       | 01051991    |
    Then A table named tbl_mortagage should store the correct borrower,new email adress information




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