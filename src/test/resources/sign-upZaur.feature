@Zaur
Feature: User Sign Up

  Scenario: Successful registration
    Given I am on the Sign Up page
    And I enter my First Name as "John"
    And I enter my Last Name as "Doe"
    And I enter my Email Address as "john.doe@example.com"
    And I enter my Password as "Abc12345"
    And I click on the Sign Up button
#    Then I should see a message "Registration Successful"
    And I should be redirected to the Sign In page

  Scenario: Email already exists
    Given an existing user with Email Address "jane.doe@example.com"
    And I am on the Sign Up page
    And I enter my First Name as "John"
    And I enter my Last Name as "Doe"
    And I enter my Email Address as "jane.doe@example.com"
    And I enter my Password as "Abc12345"
    And I click on the Sign Up button
    Then I should see an error message "This email already used"
#    And the Sign Up button should remain disabled

  Scenario: Invalid input
    Given I am on the Sign Up page
    And I enter my First Name as "John123"
    And I enter my Last Name as "Doe456"
    And I enter my Email Address as "john.doe@example"
    And I enter my Password as "abc123"
    And I click on the Sign Up button
#    Then the Sign Up button should remain disabled
#    And I should see validation errors for each input field
