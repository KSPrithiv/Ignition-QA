Feature: Test case for creating new user from client login

Background: For login to application and select User and account client login for new user creation
Given User enters URL and is on login page and entered credentials for User and account client login
When User is on Home Page for User and account client login
Then User navigate to Client side for User and account client login

  @CancelNewUserInClient
  Scenario: Test scenario for canceling creating new user from client credentials
    Given User must be on Client side and select User Management
    Then User should enter all the required fields in new user details card
    And User should select role and enter PO#
      |CompanyAdmin|P123|
    Then User clicks on Cancel buttton

  @CreatingNewUserInClient
  Scenario: Test scenario for creating new user from client credentials
    Given User must be on Client side and select User Management
    Then User should enter all the required fields in new user details card
    And User should select role and enter PO#
    |CompanyAdmin|P123|
    Then User clicks on register buttton

  @MangeRegistration
  Scenario: Test scenario for


  @LogoutFromUserAndAccountClientside
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page

