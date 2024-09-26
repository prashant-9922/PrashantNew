Feature: Tool tip

  Scenario: Verify tool tip
    Given open fb login page
    |https://www.facebook.com/login/|
    Then get tool tip of log in link at bottom
    Then verify tool tip message
    |Log in to Facebook|

    Scenario: Verify screenshot of fb page
      Given open fb login page
        |https://www.facebook.com/login/|
      Then get screenshot of fb page
      |/Users/apple/IdeaProjects/CucumberDemo/target/Fb.png|

  Scenario: Verify screenshot of fb logo
    Given open fb login page
      |https://www.facebook.com/login/|
    Then get screenshot of fb logo
      |/Users/apple/IdeaProjects/CucumberDemo/target/FbLogo.png|