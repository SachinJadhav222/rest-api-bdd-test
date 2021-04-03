@ui
Feature: Print My name
  As user
  I want to
  Print my name

  Scenario: Print my name
  Given I login to "Print page"
  Then I enter my name "John"
  Then I can see my name "Doe"