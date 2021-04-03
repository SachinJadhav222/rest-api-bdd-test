@posts @api
Feature: Validate Posts from the API - (https://jsonplaceholder.typicode.com/posts/)

  Background: Endpoint Configuration
    Given The endpoint URI is already configured

  @posts @positive
  Scenario: I get the Valid Posts
    Then I set the base path "/posts" to URI
    When I GET the valid endpoint at "1"
    Then I should have the status code "200" displayed
    And content type should be in "JSON" format
    And I validate the Schema of the response
    Then The response body should match
  """
  {
  "userId": 1,
  "id": 1,
  "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
  "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
 }
  """

  @invalid
  Scenario: I get invalid Post
    Then I set the base path "/posts" to URI
    When I GET the valid endpoint at "155"
    Then I should have the status code "404" displayed

  @post
  Scenario: I create post using POST
    Then I set the base path "/posts" to URI
    And I set the request header "Content-Type" as "application/json"
    Then I POST data in json format
    """
     {
      "userId": 12,
      "id": 11,
      "title": "New title",
      "body": "New Body"
    }
    """
    Then  I should have the status code "201" displayed
    And content type should be in "JSON" format
    And the body response content should be matched
      | key    | value     |
      | userId | 12        |
      | title  | New title |
      | body   | New Body  |

  @put
  Scenario: I UPDATE the post
    Then I set the base path "/posts" to URI
    And I set the request header "Content-Type" as "application/json"
    And I PUT the post "1" with following data
      """
      {
        "id": 11,
        "name": "Leanne Graham111",
        "username": "Bret111",
        "email": "111Sincere@april.biz"
      }
     """
    Then I should have the status code "200" displayed


  @delete
  Scenario: I DELETE the Post
    Then I set the base path "/posts" to URI
    And I DELETE the valid post "1"
    Then I should have the status code "200" displayed