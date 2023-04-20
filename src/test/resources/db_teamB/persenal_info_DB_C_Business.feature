@DB
Feature: Storing Personal Information in Duobank Mortgage Application DB TO DB




  Scenario: Storing Borrower and Co-Borrower Personal Information
    When I send request to retrive email from user table
    Then It shoul be folowing exepted email
      | coshgun.ismayilov231985@gmail2.com |
      | paige.boyer@hotmail.com            |
      | priscila.veum@hotmail.com          |
      | boyer@hotmail.com                  |
      | marie.pacocha@gmail.com            |


  Scenario: Storing Borrower and Co-Borrower Personal Information
    When I send request to retrive email
    Then It result should contain dublicate email

  @DB_only
  Scenario: Storing Borrower and Co-Borrower Personal Information
    When  I send a request to retrieve duplicate usernames
    Then  The result should be empty