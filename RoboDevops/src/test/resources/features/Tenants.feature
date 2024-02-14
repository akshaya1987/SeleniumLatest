Feature: Add and Delete Tenants
  Background:
    Given User signs in to the app

  Scenario: Add a new tenant
    When User clicks on Tenants menu
    Then Tenants page is displayed
    And Clicks on Add button
    Then Create tenant page is displayed
    When Enters tenants details and clicks on Create button
    Then Tenant created successfully message is displayed
    And Tenant is listed in tenants list
      |QA organization|QA admin|akshaya@robosoftin.com|robosoftin.com|

  Scenario: Delete a new tenant
    When User clicks on Tenants menu
    Then Tenants page is displayed
    And Clicks on Delete button to delete the tenant
    And Delete tenant popup is displayed and clciks on Ok button
    Then Tenant deleted successfully message is displayed
    Then Tenant is removed from the tenants list
      |QA organization|


#  Scenario: Dashboard Build status information displayed1
#    When User is in Dashboard1
#    Then Build status pie chart is displayed1
#    And   Build status information are displayed1
