@comments @api
Feature: Validate Comments from the API - (https://jsonplaceholder.typicode.com/comments/)

  Background: Endpoint Configuration
    Given The endpoint URI is already configured

  @comment @positive
  Scenario: I get the Valid Comments
    Then I set the base path "/comments" to URI
    When I GET the valid endpoint at "1"
    Then I should have the status code "200" displayed
    And content type should be in "JSON" format
    And I validate the Schema of the response
    And the body response content should be matched
      | key   | value                                                                                                                                                   |
      | name  | id labore ex et quam laborum                                                                                                                            |
      | email | Eliseo@gardner.biz                                                                                                                                      |
      | body  | laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium |


  @invalid
  Scenario: I get invalid Comments
    Then I set the base path "/posts" to URI
    When I GET the valid endpoint at "1555"
    Then I should have the status code "404" displayed

  @post
  Scenario: I create Comments using POST
    Then I set the base path "/comments" to URI
    And I set the request header "Content-Type" as "application/json"
    Then I POST data in json format
    """
     {
        "postId": 1,
        "id": 1,
        "name": "my name",
        "email": "myemail@gmail.com",
        "body": "request body"
     }
    """
    Then  I should have the status code "201" displayed
    And content type should be in "JSON" format
    And the body response content should be matched
      | key   | value             |
      | name  | my name           |
      | email | myemail@gmail.com |
      | body  | request body      |

  @delete
  Scenario: I DELETE the Comment
    Then I set the base path "/comments" to URI
    And I DELETE the valid comment "1"
    Then I should have the status code "200" displayed