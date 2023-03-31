Feature: Sign in to mortgage account

  @sign-in

  Scenario 1 User signs in with valid credentials
    Given the user is on the sign in page
    When the user enters a valid email address and password
    And clicks on the sign in button
    Then the user should be redirected to the mortgage account dashboard

  Scenario 2 User signs in with invalid credentials
    Given the user is on the sign in page
    When the user enters an invalid email address or password
    And clicks on the sign in button
    Then the user should see an error message "Login Failed"

  Scenario 3 User attempts to sign in with missing credentials
    Given the user is on the sign in page
    When the user attempts to sign in without entering an email address or password
    Then the sign in button should be disabled
    And the user should see an error message indicating the missing field

  Scenario 4 User navigates to sign up page
    Given the user is on the sign in page
    When the user clicks the "Don't have an account? Sign up" link
    Then the user should be redirected to the sign up page

  Scenario 5 User navigates to forgot password page
    Given the user is on the sign in page
    When the user clicks the "Forgot your password?" link
    Then the user should be redirected to the forgot password page
    And the user should see a form to reset their password.

