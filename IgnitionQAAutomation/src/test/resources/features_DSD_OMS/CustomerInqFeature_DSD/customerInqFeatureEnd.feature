Feature: Customer Inq
  All the scenarios that performs all the scenarios related to Customer inq

  Background: For login to application and select Customer inq
    Given User enters URL and is on login page and entered credentials Customer inq
    When User is on Home Page for Customer inq
    Then User navigate to Client side for Customer inq

  @LogoutCompetitorPricing
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page