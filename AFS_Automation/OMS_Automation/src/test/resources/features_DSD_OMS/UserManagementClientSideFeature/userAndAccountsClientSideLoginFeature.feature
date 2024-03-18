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
    Then User clicks on Cancel button

  @CreatingNewUserInClient
  Scenario: Test scenario for creating new user from client credentials
    Given User must be on Client side and select User Management
    Then User should enter all the required fields in new user details card
    And User should select role and enter PO#
    |CompanyAdmin|P123|
    Then User clicks on register button

  @ChangeRegisterBy
  Scenario: Test scenario for changing Register by and create new user from client credentials select anything other than account number
    Given User must be on Client side and select User Management
    Then User changes Register by option and should enter all the required fields in new user details card
    And User should select role and enter PO#
      |CompanyAdmin|P123|
    Then User clicks on register button

  @CreateNewUserForAccount
  Scenario: Test scenario for creating new user from client credentials by selecting customer account number
    Given User must be on Client side and select User Management
    Then User should enter all the required fields in new user details card by selecting customer Account number
    And User should select role and enter PO#
      |CompanyAdmin|P123|
    Then User clicks on register button




