Feature: Disconnected mode1

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for DM
    When User is on Home Page for DM
    Then User navigate to Client side for DM
    Then User should select Order Entry tab for DM

  @LogoutDM
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page