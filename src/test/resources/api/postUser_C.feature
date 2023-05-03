@api

Feature: POST /user Api

  As an admin
  I want to create new users of the mortgage application

  @api
  Scenario: Create new user

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "The user has been created."