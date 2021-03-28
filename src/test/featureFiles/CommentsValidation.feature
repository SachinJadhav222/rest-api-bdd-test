@comments @api
Feature: Validate Comments from the API - (https://jsonplaceholder.typicode.com/comments/)

  Background: Endpoint Configuration
    Given The endpoint URI is already configured

  @comment @positive
  Scenario: I get the Valid Comments
    Then I set the base path "/comments" to URI
    When I GET the valid endpoint at "1"
    Then I should have the status code "200"
    And content type should be in "JSON" format
    And I validate the Schema of the response
    And the body response content should be matched
      | key   | value                                                                                                                                                   |
      | name  | id labore ex et quam laborum                                                                                                                            |
      | email | Eliseo@gardner.biz                                                                                                                                      |
      | body  | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium |


