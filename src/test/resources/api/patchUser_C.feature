@api
Feature: PUT /user Api

  As an admin
  I want to UPDATE user of the mortgage application

  @api
  Scenario: Update user NOT SUCCESFULLY

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "390"
    And the body is set to for Patch
    When I send a "PATCH" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 400
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "Invalid or missing data"

  @api
  Scenario: Update user SUCCESFULLY

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "390"
    And the body is set to SUCCES Patch
    When I send a "PATCH" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "User updated successfully"

  @api
  Scenario: Update user SUCCESFULLY using Map

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "391"
    And the body is set to SUCCES Patch following map
      | last_name | Herc                 |
      | email     | herc2232564@mail.com |
    When I send a "PATCH" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "User updated successfully"

  @api
  Scenario: Update user SUCCESFULLY using Map

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "391"
    And the body is set to SUCCES Patch following map
      | first_name | Herc23               |
      | email      | herc2232564@mail.com |
      | last_name  | Herc                 |
    When I send a "PATCH" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "User updated successfully"

  @api1
  Scenario: Update user User not found using Map

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "3910"
    And the body is set to SUCCES Patch following map
      | first_name | Herc23               |
      | email      | herc2232564@mail.com |
      | last_name  | Herc                 |
    When I send a "PATCH" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 404
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
