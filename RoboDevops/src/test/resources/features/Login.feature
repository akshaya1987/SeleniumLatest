Feature: Login to RoboDevops as super admin

  Scenario Outline: Successful login with valid credentials
    Given User opens the RoboDevops login page
    When Enters username "<email>" and password "<password>"
    And Clicks on Continue button
    Then Successfully logged into the application

    Examples:
      |email                | password |
      |manju.p@roboso.com   |Robo@1234 |
