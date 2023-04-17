

  Feature: As a user of Duobank Mortgage Application, I want my Preapproval Details page data to be stored in
    the database, so that I can access it later and the bank can process my mortgage application

  Background: Common steps for all scenarios in PreApproval details page
    Given user navigates to the SignIn page
    When user enters a valid email address and password and clicks on Sing In button
    And user is redirected to the Dashboard page
    And user clicks on Mortgage Application button
    Then user is redirected to the PreApproval Details page

    @db_preapp
  Scenario: the Preapproval Details page information should be stored in tbl_mortagage table in the corresponding columns
    Given user is on the PreApproval Details page
    When user fills out PreApproval Details page form fields using valid information
    |realtor_status  |realtor_info    |loan_officer_status|purpose_loan    |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|src_down_payment           |add_fund_available|
    |yes             |Keller Williams |yes                |Purchase a Home |40000             |10000       |25                  |30000            |Other type of Down Payment |5000              |

    Then entered details for Mortgage PreApproval can be viewed by the user in their respective columns
    |realtor_status  |realtor_info    |loan_officer_status|purpose_loan    |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|src_down_payment           |add_fund_available|
    |1               |Keller Williams |1                  |Purchase a Home |40000             |10000       |25                  |30000            |Other type of Down Payment |5000              |




