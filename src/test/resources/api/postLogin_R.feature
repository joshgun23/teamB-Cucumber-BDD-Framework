@api

Feature: Testing DuoBank Login API

  Background:
    Given The Base URI is set


  @api
  Scenario: Verify successful login information
    When I send a POST request to the endpoint with existing credentials
    Then I verify the status code


  @api
  Scenario: Verify Login info update with POST request
    When  I send a Post request to "/login.php" endpoint with the following information
      | email     | herc@mail.com |
      | password  | Dhsjjfhdsf23* |
    Then the response should contain the following data
      | Content-Type | application/json; charset=UTF-8      |
      | Server       | Apache/2.4.55 () OpenSSL/1.0.2k-fips |


  @api
  Scenario: Verify the return response of the url with POST request
    When  I send a Post request to "/login.php" endpoint with the following information
      | email     | herc@mail.com |
      | password  | Dhsjjfhdsf23* |
    Then the response should contain the following data
      | Content-Type | application/json; charset=UTF-8      |
      | Server       | Apache/2.4.55 () OpenSSL/1.0.2k-fips |
    Then the return response should be less that 1000ms


  @api
  Scenario:  Verify Negative test Post login with invalid credentials
    When I send a Post request to the endpoint with wrong credentials
    Then The response should contain an error message


