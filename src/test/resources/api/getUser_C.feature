@api

Feature: GET /user Api

  As an admin
  I want to GET SINGLE USER of the mortgage application

  @api
  Scenario: GET SINGLE USER SUCCESFULLY

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "390"
    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms

  @api
  Scenario: GET SINGLE USER NOTSUCCESFULLY

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "3900"
    When I send a "GET" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 404
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms