Feature: Payment Info1

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Payment
    When User is on Home Page for Payment
    Then User navigate to Client side for Payment

  @LogoutPar
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
