Feature: Customers feature

  Background:
    Given User signs in to the app

  Scenario: Add a new customer
    When User clicks on Customers option from hamburger menu
    Then Clicks on Customers menu
    Then Customers page is displayed
    And Clicks on Add new button
    And Enters customer information
    | @test.com | pass123* | Ganesha | Uppoor | 28/02/2023 2:00 PM | QA soft | Your store name | Guests | Vendor 1 | Sample admin comment |
    And Clicks on Save button
    Then Customer is added successfully
    And Added customer is available in customers table



