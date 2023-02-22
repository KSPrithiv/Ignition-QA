Feature: Bill to bill1

  Background: For login to application and select Bill to billing
    Given User enters URL and is on login page and entered credentials for Bill to bill
    When User is on Home Page for bill to bill
    Then User navigate to Client side for bill to bill

  @LogoutBillToBill
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
