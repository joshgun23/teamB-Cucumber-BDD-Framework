@Ziyoda
Feature: As a user-
  I want to be able to sign in to my mortgage account,
  so that I can access my account information and perform necessary actions.

  Background: Common steps for all scenarios in sign up page
	Given the user is on the sign-in page

  Scenario: Sign in with valid credentials
	When the user enters valid credentials
	Then the user should be able to sign in successfully
	And the user should be able to see the welcome message "Welcome to Duo Bank"

  Scenario: Sign in with invalid credentials
	When the user enters invalid credentials
	Then the user should not be able to sign in
	And the user should be able to see the error message "Login Failed"

  Scenario: Sign in with blank credentials
	When the user enters blank credentials
	Then the user should not be able to sign in
	And the user should be able to see the error message "Please fill out this field

  Scenario: Sign in with invalid username
	When the user enters invalid username
	Then the user should not be able to sign in
	And the user should be able to see the error message "Login Failed"

  Scenario: Sign in with invalid password
	When the user enters invalid password
	Then the user should not be able to sign in
	And the user should be able to see the error message "Login failed"

  Scenario: Sign in with blank username
	When the user enters blank username
	Then the user should not be able to sign in
	And the user should be able to see the error message "Please fill out this field"

  Scenario: Sign in with blank password
	When the user enters blank password
	Then the user should not be able to sign in
	And the user should be able to see the error message "Please fill out this field"

  Scenario: Sign in with invalid username and password
	When the user enters invalid username and password
	Then the user should not be able to sign in

	Scenario: Don't have an account
	When the user clicks on "Don't have an account? Sign up"
	Then the user should be able to see the sign up page

  Scenario: Forgot password
	When the user clicks on "Forgot password?"
	Then the user should be able to see the forgot password page

