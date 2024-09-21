Feature: Facebook login page


  Scenario: Verify login page functionality
    When open login page
      | https://www.facebook.com/login/ |
    And get title of fb page
    Then verify login page is opened successfully
