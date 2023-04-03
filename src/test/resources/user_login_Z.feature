@sign
Feature: Sign in to mortgage account


    Scenario : User signs in with valid credentials
	Given the user is on the sign in page
	When the user enters a valid email address and password
	When the user clicks on the sign in button
	Then the user should be redirected to the mortgage account dashboard

  Scenario : User signs in with invalid credentials
    When the user enters an invalid email address or password
	Then the user should see an error message "Login Failed"

  Scenario : User attempts to sign in with missing credentials
    When the user attempts to sign in without entering an email address or password
	Then the sign in button should be disabled
	And the user should see an error message indicating the missing field

  Scenario : User navigates to sign up page
    When the user clicks the "Don't have an account? Sign up" link
	Then the user should be redirected to the sign up page

  Scenario : User navigates to forgot password page
    When the user clicks the "Forgot your password?" link
	Then the user should be redirected to the forgot password page
	And the user should see a form to reset their password.

