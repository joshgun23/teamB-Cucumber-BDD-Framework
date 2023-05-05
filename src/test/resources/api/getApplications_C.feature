@api
Feature: GET /applications API endpoint

  As an admin
  I want to retrieve all the users of the mortgage application

  @api
  Scenario: Retrieve all applications successfully

    Given the request is authenticated with a valid API key
    And the body has the existing username and password
    When I send a "POST" request to the endpoint "/login"
    Then the response log should be displayed
    Then the response status code should be 200
    And the JWT is set

    Given the request is authenticated with a valid API key
    And the "Authorization" header is set to JWT token obtained through login endpoint
    When I send a "GET" request to the endpoint "/applications"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json; charset=UTF-8"
    And the response time should be less than 850 ms
#     And the owner of all playlists should be correct
#    And the all playlists should be sorted in descending order

