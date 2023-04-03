@regression

Feature: As a user, I want to use the Preapproval Details page of my bank's mortgage application, so that I can provide
  the information needed to get pre-approved for a mortgage loan.

    Background: Common steps for all scenarios
      Given The user navigates to the SignIn page
      When The user enters a valid email address and password
      When The user clicks on the Mortgage application page
      Then The user should be able to sign in and should be redirected to the mortgage application page

    Scenario: Click on the realtor check box
      When The user clicks on the realtor checkbox
      Then The realtor checkbox is checked
  @smoke
    Scenario: Fill out the Mortgage Application Preapproval Details page with valid information
      When The user fills out all fields on the preapproval details page
      Then The user move on to the personal information page by clicking on Next button

    Scenario: Fill out the Mortgage Application Preapproval Details page and check the percentage of loan amount
      When The user fills out necessary fields on the preapproval details page
      Then The user can check calculated loan amount percentage
  @smoke
    Scenario: Fill out the Mortgage Application Preapproval Details page and check calculated loan amount
      When The user fills out necessary fields on the preapproval details page
      Then The user can check calculated loan amount

    Scenario: Fill out the Mortgage Application Preapproval Details page using invalid credentials for the realtor information field
      When The user fills out all the necesarry fields on the preapproval details page using "!@#$%^&*()" as a realtor information
      Then The user should not be able to move on to the personal information page by clicking on Next button



















#    Scenario: Enter realtor's Information
#      When The user enters valid realtor information
#      Then The realtor information is displayed

#    Scenario: Click on the loan officer check box
#      When The user clicks on the loan officer checkbox
#      Then Loan officer box is checked
#
#    Scenario: Select the loan purpose
#      When The user clicks on the Loan Purpose button
#      Then The drop down menu with options is displayed
#
#    Scenario: Enter estimated purchase price
#      When The user enters the estimated purchase price
#      Then The dollar amount with up to two decimal places should be displayed




