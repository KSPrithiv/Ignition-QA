Feature: Standing order1

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for SO
    When User is on Home Page for SO
    Then User navigate to Client side for SO
    Then User should select Order Entry tab for SO
    Then User selects Account# for SO

  @LogoutSO
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
