Feature: Quotes2

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Quotes
    When User is on Home Page for Quotes
    Then User navigate to Client side for Quotes
    Then User should select Order Entry tab for Quotes
    Then User selects Account# for Quotes

  @LogoutQuotes
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
