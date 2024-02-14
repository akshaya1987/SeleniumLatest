Feature: Dashboard functionalities

  Background:
    Given User signs in to the app

  Scenario: Dashboard statistics are displayed
    When User is in Dashboard
    Then Statistics are displayed in Dashboard
      | Total Projects      |
      | Total Users         |
      | Total Applications  |
      | Total Pipelines     |

  Scenario: Dashboard Build status information displayed
    When User is in Dashboard
    Then Build status pie chart is displayed
    And   Build status information are displayed

  Scenario: Dashboard Technology overview information displayed
    When User is in Dashboard
    Then Technology overview pie chart is displayed