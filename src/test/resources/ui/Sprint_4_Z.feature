@ziyoda
Feature: Electronic Consent for Mortgage Loan Application

  Scenario Outline: User can consent electronically to do business
	#Given the user is on the electronic consent page
	When the user enters their first name as "<first_name>", last name as "<last_name>", and email address as "<email_address>"
	Then the user should see two radio buttons for "Agree" and "Don't Agree"
	And the "<default_radio_button>" button should be selected by default
	When the user presses the "Next" button the user should be redirected to the Summary page


	Examples:
	  | first_name | last_name | email_address            |
	  | Mickey     | Mouse     | mickey@example.com       |
	  | Tom        | Jerry     | tomandjerry@example.com  |
	  | Michael    | Myers     | michaelmyers@example.com |

  Scenario: User cannot proceed without selecting a radio button
	Given the user is on the electronic consent page
	Then the user should see two radio buttons for "Agree" and "Don't Agree"
	And the "Agree" button should be selected by default

  @negative_z

  Scenario: User cannot proceed without entering their first name
	Given the user is on the electronic consent page
	When the user not enters their first name
	Then the user should see an error message "THIS FIELD IS REQUIRED."


  Scenario: User cannot proceed without entering their last name
	Given the user is on the electronic consent page
	When the user not enters their last name
	Then the user should see an error message "THIS FIELD IS REQUIRED."

  Scenario:
	Given the user is on the electronic consent page
	When the user not enters their email address
	Then the user should see an error message "THIS FIELD IS REQUIRED."


#
#  Scenario Outline: User can access the electronic consent page on multiple browsers
#	Given the user is on the electronic consent page
#	When the user opens the page on "<browser_1>" and "<browser_2>"
#	Then the user should see the same page content on both browsers
#
#	Examples:
#	  | browser_1 | browser_2 |
#	  | Chrome    | Firefox   |
#	  | Safari    | Edge      |
#
#  Scenario Outline: User can access the electronic consent page in parallel
#	Given the user is on the electronic consent page
#	When the user opens the page on "<device_1>" and "<device_2>" in parallel
#	Then the user should see the same page content on both devices
#
#	Examples:
#	  | device_1 | device_2 |
#	  | iPhone   | iPad     |
#	  | MacBook  | iMac     |
