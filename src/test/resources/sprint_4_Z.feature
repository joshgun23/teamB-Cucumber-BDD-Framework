@Sprint4
Feature: Electronic Consent for Mortgage Loan Application

  Scenario Outline: User can consent electronically to do business
	Given the user is on the electronic consent page
	When the user enters their first name as "<first_name>", last name as "<last_name>", and email address as "<email_address>"
	And the user reads the necessary disclosures related to the loan application
	Then the user should see two radio buttons for "Agree" and "Don't Agree"
	And the "<default_radio_button>" button should be selected by default
	When the user selects the "<selected_radio_button>" button
	Then the user should be able to proceed with the application

	Examples:
	  | first_name | last_name | email_address         | default_radio_button | selected_radio_button |
	  | John       | Doe       | johndoe@example.com   | Agree                | Agree                 |
	  | Jane       | Smith     | janesmith@example.com | Don't Agree          | Don't Agree           |
	  | Bob        | Johnson   | bobjohnson@example.com| Don't Agree          | Agree                 |

  Scenario: User cannot proceed without selecting a radio button
	Given the user is on the electronic consent page
	When the user enters their first name as "John", last name as "Doe", and email address as "johndoe@example.com"
	And the user reads the necessary disclosures related to the loan application
	Then the user should see two radio buttons for "Agree" and "Don't Agree"
	And the "Agree" button should be selected by default
	When the user clicks the "Submit" button without selecting any radio button
	Then the user should see an error message and should not be able to proceed with the application

  Scenario Outline: User can access the electronic consent page on multiple browsers
	Given the user is on the electronic consent page
	When the user opens the page on "<browser_1>" and "<browser_2>"
	Then the user should see the same page content on both browsers

	Examples:
	  | browser_1 | browser_2 |
	  | Chrome    | Firefox   |
	  | Safari    | Edge      |

  Scenario Outline: User can access the electronic consent page in parallel
	Given the user is on the electronic consent page
	When the user opens the page on "<device_1>" and "<device_2>" in parallel
	Then the user should see the same page content on both devices

	Examples:
	  | device_1 | device_2 |
	  | iPhone   | iPad     |
	  | MacBook  | iMac     |
