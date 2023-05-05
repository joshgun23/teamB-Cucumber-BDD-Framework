@api

Feature: POST /login JWT TOKEN Api

  As an admin
  I want to create new JWT TOKEN of the mortgage application

  @api
  Scenario: Create new JWT TOKEN

    Given the request is authenticated with a valid API key
    And the body has the existing username and password
    When I send a "POST" request to the endpoint "/login"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response time should be less than 1000 ms
    And the response body key "message" should be "You've successfully logged in!"
    And the response body key "success" should be true