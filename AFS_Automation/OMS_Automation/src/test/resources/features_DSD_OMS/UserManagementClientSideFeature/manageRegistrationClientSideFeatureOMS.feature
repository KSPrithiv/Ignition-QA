Feature: Test case for Manage registration from client login

  Background: For login to application and select User and account client login for new user creation
    Given User enters URL and is on login page and entered credentials for User and account client login
    When User is on Home Page for User and account client login
    Then User navigate to Client side for User and account client login

  @ManageRegistrationAddPrimaryAccount
  Scenario: Test scenario for Add primary account# in manage registration page
    Given User must be on Client side and select User Management for Manage registration
    Then User should navigate to manage registration page
    And User should select User from the User dialog box and validate that details are loaded
    Then User should enter account number for primary customer account number for OMS

  @ManageRegistrationDeletePrimaryAccount
  Scenario: Test scenario for Delete primary account# in manage registration page
    Given User must be on Client side and select User Management for Manage registration
    Then User should navigate to manage registration page
    And User should select User from the User dialog box and validate that details are loaded
    Then User should click on Delete button next to primary customer account

  @ManageRegistrationAddSecondaryAccount
  Scenario: Test scenario for Add secondary account# in manage registration page
    Given User must be on Client side and select User Management for Manage registration
    Then User should navigate to manage registration page
    And User should select User from the User dialog box and validate that details are loaded
    Then User should enter account number for Secondary customer account for OMS

  @ManageRegistrationDeleteSecondaryAccount
  Scenario: Test scenario for Delete secondary account# in manage registration page
    Given User must be on Client side and select User Management for Manage registration
    Then User should navigate to manage registration page
    And User should select User from the User dialog box and validate that details are loaded
    Then User should click on Delete button next to Delete Secondary customer account

  @ManageRegistrationUpdate
  Scenario: Test scenario for updating PO# in manage registration page
    Given User must be on Client side and select User Management for Manage registration
    Then User should navigate to manage registration page
    And User should select User from the User dialog box and validate that details are loaded
    Then User should change PO# and click on update button

