Feature: Test case for creating new user from client login

  Background: For login to application and select User and account client login for new user creation
    Given User enters URL and is on login page and entered credentials for User and account client login
    When User is on Home Page for User and account client login
    Then User navigate to Client side for User and account client login

  @LogoutFromUserAndAccountClientside
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page