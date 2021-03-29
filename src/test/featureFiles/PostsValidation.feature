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
