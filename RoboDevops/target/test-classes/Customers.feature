Feature: Customers feature

  Background:
    Given User signs in to the app

  Scenario Outline: Search user by email, firstname and lastname
    When User clicks on Customers option from hamburger menu
    Then Clicks on Customers menu
    Then Customers page is displayed
    And Enters search key "<searchkey>" in "<criteria>" field
    And Clicks on Search button
    Then Customer with "<searchkey>" is searched successfully

    Examples:
      | searchkey            | criteria |
      | admin@yourStore.com  | email    |
      | John                 | fname    |
      | Smith                | lname    |