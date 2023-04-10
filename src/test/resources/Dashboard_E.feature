
Feature: As a user, I want check Dashboard page functionality

  Scenario: User signs in with valid credentials
    Given the user is on the sign in home page
   When the user enters email address and password
    And clicks on the sign in button
    Then the user see mortgage account dashboard


  Scenario: Verify the dashboard page functionality
    Given User on the dashboard page
    When Bank logo should be displayed in the top left corner of the page
  #  And User should see the Mortgage Application and Application List links
    When User click on the "Mortgage Application" link
    Then User should be taken to a new page where user can apply for a new mortgage
    And User click on the "Application List" link


  Scenario:  Account informatiom
    When User should see my account information in the top right corner
    And User click on my name or profile picture
    Then User should see a dropdown menu with a "Logout" link
    And User should be able to click on the "Logout" link to log out of the system


