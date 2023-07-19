Feature: AR Inquiry
  All the scenarios that performs all functionality related to AR Inquiry tab

  Background: For login to application and select AR Inquiry
    Given User enters URL and is on login page and entered credentials for AR Inquiry
    When User is on Home Page for AR Inquiry
    Then User navigate to Client side for AR Inquiry

  @LogoutARInquiry
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page