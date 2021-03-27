@user
Feature: Validate User details from the API - (https://jsonplaceholder.typicode.com/users/1)

  Background: Endpoint Configuration
    Given The endpoint URI is already configured

  @user @positive
  Scenario: Enter a valid userId
    Then I set the base path "/users" to URI
    When I GET a valid userId "1"
    Then I should have the status code "200"
    And content type should be in "JSON" format
    And the body response content should be matched
      | key      | value                 |
      | id       | 1                     |
      | name     | Leanne Graham         |
      | username | Bret                  |
      | email    | Sincere@april.biz     |
      | phone    | 1-770-736-8031 x56442 |
      | website  | hildegard.org         |

  @user @positive
  Scenario: Enter a valid userId
    Then I set the base path "/users" to URI
    When I GET a valid userId "2"
    Then I should have the status code "200"
    And content type should be in "JSON" format
    And the body response content should be matched
      | key      | value               |
      | id       | 2                   |
      | name     | Ervin Howell        |
      | username | Antonette           |
      | email    | Shanna@melissa.tv   |
      | phone    | 010-692-6593 x09125 |
      | website  | anastasia.net       |

  @user @negative
  Scenario: Enter an invalid UserId
    Then I set the base path "/users" to URI
    When I GET a valid userId "25"
    Then I should have the status code "404"


  Scenario: I create User using POST
    Then I set the base path "/users" to URI
    Then I POST data in json format
    """
      {  "name": "sac",
        "username": "sac444",
        "email": "sac444@gmail.com"}
    """
    Then I should have the status code "201"
    And content type should be in "JSON" format
    And the body response content should be matched
      | key      | value            |
      | name     | sac              |
      | username | sac444           |
      | email    | sac444@gmail.com |


