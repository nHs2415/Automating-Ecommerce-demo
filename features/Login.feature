Feature: Login

  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome Browser
    When User opes URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "nuwani"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks on Logout link
    Then Page Title should be "Your store. Login"
    And Close the browser