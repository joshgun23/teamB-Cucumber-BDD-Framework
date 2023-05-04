@api
Feature: DELETE /user Api

  As an admin
  I want to DELETE user of the mortgage application

  @api
  Scenario: DELETE user for Automotic ID SUCCESFULLY

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the body is added
    When I send a "POST" request to the endpoint "/user"
    Then the response log should be displayed
    Given the USER is creted and the id
    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to new id
    When I send a "DELETE" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "User deleted successfully"

  @api
  Scenario: DELETE user NOT SUCCESFULLY

    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "id" query parameter is set to "100"
    When I send a "DELETE" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 404
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "User not found"

 @api
  Scenario: DELETE user bad input parameter SUCCESFULLY


    Given the request is authenticated with a valid API key
    And the "Content-type" header is set to "application/json"
    And the "idi" query parameter is set to "101"
    When I send a "DELETE" request to the endpoint "/user"
    Then the response log should be displayed
    Then the response status code should be 400
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 1000 ms
    And the response body key "message" should be "Invalid or missing ID"