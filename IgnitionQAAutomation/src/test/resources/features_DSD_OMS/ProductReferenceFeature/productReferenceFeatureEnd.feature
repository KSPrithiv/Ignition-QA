Feature: Product reference1

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for PR
    When User is on Home Page for PR
    Then User navigate to Client side for PR
    Then User should select Order Entry tab for PR
    Then User selects Account# for PR

  @LogoutPR
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
