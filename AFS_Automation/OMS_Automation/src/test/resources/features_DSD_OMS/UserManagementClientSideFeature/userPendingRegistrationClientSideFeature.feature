Feature: Test case for Pending registration from client login

  Background: For login to application and select User and account client login for new user creation
    Given User enters URL and is on login page and entered credentials for User and account client login
    When User is on Home Page for User and account client login
    Then User navigate to Client side for User and account client login

  @PendingRegistrationDeny
  Scenario: Test scenario for Deny pending registration
    Given User must be on Client side and select User Management for Pending registration
    Then User should navigate to Pending registration page
    And User should select user details from Select User dropdown
    Then User clicks on Deny button

  @PendingRegistrationConfirm
  Scenario: Test scenario for Confirm pending registration
    Given User must be on Client side and select User Management for Pending registration
    Then User should navigate to Pending registration page
    And User should select user details from Select User dropdown
    Then User clicks on Confirm button