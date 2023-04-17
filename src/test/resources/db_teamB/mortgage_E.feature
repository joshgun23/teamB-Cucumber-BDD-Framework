@db
Feature: Verify data mapping

  As a mortgage lender
  I want to have a table in the database labeled "tbl_mortgage"
  So that I can store and manage applicant and co-applicant information for mortgage applications


  Scenario: Check tbl_mortgage columns
    Given the tbl_mortgage table exists

   When It should be the following columns in the "tbl_mortgage" table:
      | Column |
      | employer_name |
      | position |
      | city |
      | state |
      | start_date |
      | end_date |
      | current_job |
      | co_employer_name |
      | co_position |
      | co_city |
      | co_state |
      | co_start_date |
      | co_end_date |
      | co_current_job |
      | gross_monthly_income |
      | monthly_overtime |
      | monthly_bonuses |
      | monthly_commissions |
      | monthly_dividends |
      | c_gross_monthly_income |
      | c_monthly_overtime |
      | c_monthly_bonuses |
      | c_monthly_commissions |
      | c_monthly_dividends |
      | add_belong |
      | income_source |
      | amount |



    Then the "employer_name" and "gross_monthly_income" columns should be required and not empty

    And the "state" column should only contain two-letter abbreviations of US states

    When the "income_source" column should only contain the following values:
      | Value                             |
      | Alimony/Child Support            |
      | Social Security/Disability Income|
      | Unemployment Benefits            |
      | Interest and Dividends           |
      | VA Compensation                  |
      | Royalty Payments                 |
      | Other Types of Income            |