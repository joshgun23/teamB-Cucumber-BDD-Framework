@regression @employment
Feature: Employment and Income Related feature

  As a user applying for a mortgage loan, I want to provide my employment and income details to the bank,
  so that they can evaluate my eligibility for a loan.

  Background: Common steps for all scenarios
    Given User is on the homepage
    When User enters valid username and password and clicks on the sign-in button
    Then User clicks mortgage application
    Then User fills out all the required fields and navigates to Employment and Income page

  Scenario: User should be able to fill in Employment and Income details information
    Given User is on the Employment and Income page
    When User enters the employer information
      | EMPLOYER NAME  | POSITION | CITY     | START DATE   | GROSS MONTHLY INCOME |
      | Google         | SDET     | New York | 07/01/2022   | 10500                |
    Then User should be able to click on next button

  Scenario:  User should be able to fill in Employment and Income feature with second employer information and start date
    Given User is on the Employment and Income page
    When User enters another employer information with the following credentials
      | EMPLOYER NAME2  | POSITION2   | CITY2     | START DATE2   | GROSS MONTHLY INCOME2 |
      | Adobe           | QA Engineer | Armonk    | 10/01/2015    | 9650                  |
    Then User should be able to click on next button

  Scenario: User is able to see the STATE dropdown list with all 50 US states
    Given User is on the Employment and Income page
    When User is at STATE dropdown menu in Employment and Income page
    Then User should be able to see a dropdown list with all 50 US states and their two letter abbreviations.

  Scenario Outline: User should be able to fill in Employment and Income feature with MONTHLY OVERTIME, BONUSES, COMMISSIONS & DIVIDENDS
    Given User is on the Employment and Income page
    When User enters employer information with the following credentials including the following Gross Monthly Employment Income
      | Employer Name   | Position   | City   | Start Date   | Gross Monthly Income  | Monthly Overtime | Monthly Bonuses | Monthly Commissions | Monthly Dividends |
      | <Employer Name> | <Position> | <City> | <Start Date> | <Gross Income>        | <Overtime>       | <Bonuses>       | <Commissions>       | <Dividends>       |
    Then User should be able to click on next button

    Examples:
      | Employer Name      | Position                           | City          | Start Date | Gross Income | Overtime | Bonuses | Commissions | Dividends |
      | Amazon             | Lead Software Testing Specialist   | Seattle       | 03.24.2022 | 12734        | 610      | 4000    | 5000        | 6005      |
      | Apple              | Senior QA Engineer                 | Cupertino     | 11.15.2019 | 10765        | 2009     | 3500    | 4000        | 3500      |
      | UnitedHealth Group | SDET                               | Boston        | 04.28.2012 | 9950         | 550      | 10555   | 3000        | 10000     |
      | JPMorgan Chase     | QA Engineer                        | New York City | 10.01.2006 | 6723         | 6125     | 3446    | 2000        | 5000      |
      | Delta Airlines     | Junior QA Engineer                 | Atlanta       | 02.01.2002 | 5688         | 2543     | 7892    | 1000        | 0         |



