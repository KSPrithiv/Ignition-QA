Feature: Customer Inq in ERP
  All the scenarios that performs all the scenarios related to Customer inq(ERP)

  Background: For login to application and select Customer inq ERP
    Given User enters URL and is on login page and entered credentials Customer inq ERP
    When User is on Home Page for Customer inq ERP
    Then User navigate to Client side for Customer inq ERP

  @LogoutCustInq
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page