Feature: All orders1
  Test scenarios to logout, to stop All order/Open order feature files execution

  Background: For login to application and selecting Account# for All order
    Given User enters URL and is on login page and entered credentials for All order
    When User is on Home Page for All order
    Then User navigate to Client side for All order
    Then User should select Order Entry tab for All order

  @LogoutAllOrder
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
