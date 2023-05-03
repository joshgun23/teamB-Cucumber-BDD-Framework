@api
Feature: GET /users API endpoint

  As an admin
  I want to retrieve all the users of the mortgage application
  So that I can manage and monitor the user base

  @api
  Scenario: Retrieve all users successfully
    Given the request is authenticated with a valid API key
    And the "Accept" header is set to "application/json"
    When I send a "GET" request to the endpoint "/users"
    Then the response log should be displayed
    Then the response status code should be 200
    And the response "Content-Type" header should be "application/json"
    And the response should contain a list of all users with the following fields
      | id          |
      | email       |
      | password    |
      | first_name  |
      | last_name   |
      | phone       |
      | image       |
      | type        |
      | created_at  |
      | modified_at |
      | zone_id     |
      | church_id   |
      | country_id  |
      | active      |

    And the response time should be less than 850 ms

  @api
  Scenario: Api key mising
    Given the request is not authenticated with a valid API key
    And the "Accept" header is set to "application/json"
    When I send a "GET" request to the endpoint "/users"
    Then the response log should be displayed
    Then the response status code should be 401
    And the response "Content-Type" header should be "application/json"
    And the response time should be less than 850 ms
    And the response body key "message" should be "Invalid or missing API Key. Provide a valid api key with 'api_key' query parameter."