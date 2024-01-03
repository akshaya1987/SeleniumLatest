Feature: Login to nopCommerce web application

  @demo
  Scenario Outline: Successful login with valid credentials data driven validation
    Given User opens the nopCommerce login page
    When Enters username "<email>" and password "<password>"
    And Clicks on login button
    Then Successfully logged into the application

    Examples:
      |email                | password |
      |admin@yourstore.com  |admin     |
      |admin@yourstore1.com |pass123   |

#  @demo
#  Scenario: Successful login with valid credentials
#    Given User opens the nopCommerce login page
#    When Enters username and password
#    And Clicks on login button
#    Then Successfully logged into the application