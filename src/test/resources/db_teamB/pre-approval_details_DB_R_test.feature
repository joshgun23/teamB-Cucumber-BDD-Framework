@DB
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

    Then verify mortgage preapproval details are stored in the table
    |realtor_status  |realtor_info    |loan_officer_status|purpose_loan    |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|src_down_payment           |add_fund_available|
    |1               |Keller Williams |1                  |Purchase a Home |40000             |10000       |25                  |30000            |Other type of Down Payment |5000              |

    @db_preapp
  Scenario Outline: Storing realtor_status and loan_officer column values as integers
    Given user is on the PreApproval Details page
    When user selects checkboxes for "<realtor_status_checkbox>" and "<loan_officer_status_checkbox>" sections in the PreApproval details page
    Then the corresponding integer values should be stored in the "<realtor_status>" and "<loan_officer_status>" columns respectively
    Examples:
    | realtor_status_checkbox  |loan_officer_status_checkbox| realtor_status  |loan_officer_status|
    |yes                       |yes                         |1                |  1                |
    |no                        |no                          |2                |  2                |

    @db_preapp
  Scenario: Store realtor_info, purpose_loan, and src_down_payment as String values
    Given user is on the PreApproval Details page
    When user enters the following information in the realtor_info, purpose_loan, and src_down_payment columns in the PreApproval details page:
    |realtor_info    |purpose_loan    |src_down_payment           |
    |Keller Williams |Purchase a Home |Other type of Down Payment |
    Then all entered values should be stored as a String values

    @db_preapp
  Scenario: Store PreApproval Details as Integer Values
    Given user is on the PreApproval Details page
    When user inputs the following information for the est_purchase_price, down_payment, down_payment_percent, total_loan_amount, and add_fund_available columns
    |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|add_fund_available|
    |700000            |50000       |7                   |650000           |35000             |
    Then all entered values should be stored as integers in the system

    @db_preapp
  Scenario Outline: Check that data from PreApproval Details page is mapped correctly to the database table
    Given user is on the PreApproval Details page
    When user enters the following data "<realtor_status>" , "<realtor_info>", "<loan_officer_status>", "<purpose_loan>", "<est_purchase_price>", "<down_payment>", "<down_payment_percent>", "<total_loan_amount>", "<src_down_payment>", "<add_fund_available>" into the PreApproval Details page form fields
    Then the data should be correctly mapped to the following column names "<realtor_status>" , "<realtor_info>", "<loan_officer_status>", "<purpose_loan>", "<est_purchase_price>", "<down_payment>", "<down_payment_percent>", "<total_loan_amount>", "<src_down_payment>", "<add_fund_available>" in the tbl_mortagage table:
    Examples:
    |realtor_status  |realtor_info    |loan_officer_status  |purpose_loan    |est_purchase_price|down_payment|down_payment_percent|total_loan_amount|src_down_payment                                |add_fund_available|
    |1               |Keller Williams |1                    |Purchase a Home |250765.00         |45234       |18                  |205531           |Equity on Pending Sale (executed sales contract)|50000             |
    |1               |Douglas Elliman |2                    |Purchase a Home |946466            |56907       |6                   |889559           |Equity on Pending Sale (executed sales contract)|15000             |
