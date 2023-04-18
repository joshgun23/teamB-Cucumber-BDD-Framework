#@DB
Feature: Database System Security for Duobank Mortgage Application
  As a user of Duobank Mortgage Application
  I want to be able to sign up and log in securely using a database system
  that protects my personal and financial information
  so that I can complete the mortgage application process with confidence.

  Background:

     Given the user is on the signup page

	@sameUser
  Scenario: Database can handle large number of user signups
	When the user submits multiple signups concurrently
	Then the signups should complete within a reasonable time frame
	And the system should not slow down or crash

	@sameUser
  Scenario: Unique username and email address
	Given a user with username "ziyoda.muslimova@gmail.com" already exists
	When the user attempts to sign up with the same username and email
	Then the system should display an error message "This email already used"
	And the new user account should not be created

  @dataTableUsers
  Scenario: "tbl_users" table constraints
	Given a user with email "{email}" which does not exist
	Then the user account should be created in the database
	And the "tbl_users" table should contain the correct information
	And the "tbl_users" table should have a unique constraint on the email column

#  Scenario: Password encryption
#	Given a user with email "john@example.com" exists
#	When the user logs in with the correct password
#	Then the user should be authenticated successfully
#	And the password in the database should be encrypted with MD5 hash
#
#  Scenario: Successful signup
#	When the user submits the signup form with valid information
#	Then the user account should be created in the database
#	And the system should display a message "Signup successful"
#	And the user should be redirected to the login page
