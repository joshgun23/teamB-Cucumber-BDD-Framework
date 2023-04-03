Feature: Dashboard page functionality

  Scenario 1: Verify the dashboard page displays bank logo, links, and user information
    Given User navigates to the dashboard page
    Then Bank logo should be displayed in the top left corner of the page
    And Dashboard page should include "Mortgage Application" and "Application List" links

  Scenario 2: "Mortgage Application" link
    When User clicks on "Mortgage Application" link
    Then User should be taken to the mortgage application page
    And User can apply for a new mortgage
  Scenario 3: "Mortgage Application" link
    When User clicks on "Application List" link
    Then User should be taken to the previous mortgage applications page
    And User can view a list of their previous mortgage applications
    And User's account information, including their first and last name and profile picture, should be displayed in the top right corner of the page
  Scenario 4: User's account information
    When User clicks on their name or picture
    Then User should see a dropdown menu
    And Dropdown menu should include a "Logout" link
    When User clicks on "Logout" link
    Then User should be logged out of the system
