Feature: Customers Roles feature

  Background:
    Given User signs in to the app

  Scenario: Add a new customer role
    When User is in Customer Role page
      | Customer roles |
    Then Clicks on Add new button
    Then Add new customer role page is displayed
    And Enters the necessary data
    And Clicks on Save button
    Then Customer role is added successfully
