@DB
Feature: Storing Personal Information in Duobank Mortgage Application



  Background: Common steps for all scenarios in sign up page
    Given userName1


  @DB_C_Map
  Scenario: Storing Borrower and Co-Borrower Personal Information
    Then an additional section for personal information  information is displayed
    When the user enters the personal information page mapping
      | firstName | middleName | lastName | emailmaping        | dob      |
      | joshgun   | ismayilov  | Majury   | fmajury0@gmail.com | 01051991 |
    Then A table named tbl_mortagage should store the correcect mapping information
      | firstName | middleName | lastName | emailmaping        | dob      |
      | joshgun   | ismayilov  | Majury   | fmajury0@gmail.com | 01051991 |

