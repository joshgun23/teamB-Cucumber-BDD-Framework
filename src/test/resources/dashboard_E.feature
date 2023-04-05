
Feature: Dashboard page functionality

  Scenario: 1 User signs in with valid credentials
    Given the user is on the sign in page
    When the user enters a valid email address and password
    And clicks on the sign in button
    Then the user should be redirected to the mortgage account dashboard

  Scenario: 2 Verify the dashboard page functionality
    Given User on the dashboard page
    Then Bank logo should be displayed in the top left corner of the page
    And User should see the "Mortgage Application" and "Application List" links
    When User click on the "Mortgage Application" link
    Then User should be taken to a new page where user can apply for a new mortgage
    When User click on the "Application List" link

    Scenario: 3 Account informatiom
      Given The user's account information
    And User should see my account information in the top right corner
    When User click on my name or profile picture
    Then User should see a dropdown menu with a "Logout" link
    And User should be able to click on the "Logout" link to log out of the system

