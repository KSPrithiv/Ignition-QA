Feature: Par Order1

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Par
    When User is on Home Page for Par
    Then User navigate to Client side for Par
    Then User should select Order Entry tab for Par
    Then User selects Account# for Par

  @LogoutPar
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page