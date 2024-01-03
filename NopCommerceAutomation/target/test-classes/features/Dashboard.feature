Feature: Dashboard functionalities

  Background:
    Given User signs in to the app

  Scenario: Store settings options are displayed
    Given User is in Dashboard
    Then Store setting options are displayed
      | Personalize your store |
      | Add your store info    |
      | Set up shipping        |
      | Set up payments        |
      | Set up taxes           |
      | Create products        |
      | Set up email accounts  |
      | Edit services info     |
      | "Powered by" link      |

  Scenario: Successful login with valid credentials
    Given User opens the nopCommerce login page
    When Enters username and password
    And Clicks on login button
    Then Successfully logged into the application