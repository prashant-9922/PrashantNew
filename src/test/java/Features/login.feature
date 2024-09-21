Feature: login functionality

  Background:
    Given navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  Scenario: Verify login functionality with valid credentials
    Given user navigate to url
    When user enters username & password
    And click on login button
    Then user will be redirected to homePage



  Scenario: Verify login functionality
      When user enters username as "Admin" and password as "admin123"
      And click on submit button
      Then Redirected to "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"

  Scenario: Verify login functionality with invalid credentials
    When user enters username as "abc" and password as "abc123"
    And click on submit button
    Then error message "Invalid Credentials" should be displayed on console

