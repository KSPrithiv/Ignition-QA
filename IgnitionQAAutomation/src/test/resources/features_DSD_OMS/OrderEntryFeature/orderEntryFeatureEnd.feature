Feature: Order entry6

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @LogoutOE
  Scenario:Loging out from the application
    Then User refreshes page
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
