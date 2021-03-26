@api
Feature: JSON Placeholder Comments test

  Scenario: User want to make get Request
    Given User sets base API path "/comments"
    And User creates GET request
    Then User validate status code is "200"
    And User validates Status string is "HTTP/1.1 200 OK"
    Then User validates Content-type to be "application/json; charset=utf-8"
#    And User check the response for following contents:
#      | name     | Leanne Graham     |
#      | username | Bret              |
#      | email    | Sincere@april.biz |

