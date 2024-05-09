Feature: HP Service center

  Scenario: Login functionality
    Given User opens PrintOS URL
    When Clicks on Sign In button
    Then Enters username
    Then Clicks on Next button
    Then Redirected to HP authenticate screen
    Then Enters valid username
    Then Enters valid password
    Then Clicks on Submit button
    Then Logs in successfully


  Scenario: Customer SC dashboard page
    When User clicks on Menu in PrintOS home page
    Then Clicks on organisation dropdown
    Then Enters customer organisation name in search filed
    Then Clicks on customer organisation
    Then Customer Home Screen is displayed
    Then Clicks on menu
    Then Open Service Center for Scitex
    Then Service Center dashboard is displayed
    Then HP Scitex family is selected by default in Family dropdown
    Then Parts to Return is displayed
    Then Ordered items is displayed
    Then UTKs is displayed
    Then Scitex Parts Catalog card is displayed
    Then Support cases card is displayed
    Then IOM card is displayed
    Then Parts Returns Status card is displayed