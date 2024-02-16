Feature: Add/Update/Delete Tenants
  Background:
    Given User signs in to the app

  Scenario: Adding a new tenant
    When User clicks on Tenants menu
    Then Tenants page is displayed
    And Clicks on Add button
    Then Create tenant page is displayed
    When Enters tenants details and clicks on Create button
      |QA organization|QA admin|akshaya@robosoftin.com|robosoftin.com|
    Then Tenant created successfully message is displayed
    And Tenant is listed in tenants list

  Scenario: Updating the tenant
    When User clicks on Tenants menu
    Then Tenants page is displayed
    And Clicks on Update button
      |QA organization|
    And Update tenant page is displayed
    Then Update the tenant information
      |QA organization1|QA admin1|akshaya1@robosoftin.com|robosoftin1.com|
    Then Click on Update button
    Then Tenant updated successfully message is displayed
    Then Tenant is updated in the tenants list
      |QA organization1|

  Scenario: Deleting the tenant
    When User clicks on Tenants menu
    Then Tenants page is displayed
    And Clicks on Delete button and confirms deletion
      |QA organization|
    Then Tenant deleted successfully message is displayed
    Then Tenant is removed from the tenants list
      |QA organization|