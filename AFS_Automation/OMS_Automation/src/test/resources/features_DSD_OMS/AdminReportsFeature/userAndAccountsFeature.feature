Feature: scenarios for User and Accounts admin feature, for user and accounts

  Background: For login to application and selecting Account# for Admin reports
    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
    When User is on Home Page for Admin setting for Admin reports

  @ValidateAllToggleButtons
  Scenario Outline: Test scenario for verifying functioning of "Administrator to approve all new user registrations" taggle button
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>", for user and accounts
    Then User selects "<User Accounts>" in Orders page in admin login and validate user is in selected Tab
    And User validates all five toggle buttons presence in User and Admin General page
    Examples:
      | Main menu           |  Sub menu| User Accounts |
      | Users & Accounts    | General  |   General     |

  @PendingRegistrationToggle
  Scenario Outline: Test scenario for verifying functioning of "Administrator to approve all new user registrations" taggle button
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>", for user and accounts
    Then User selects "<User Accounts>" in Orders page in admin login and validate user is in selected Tab
    And User handles Administrator to approve all new user registrations toggle button and validate Pending registration approval Tab
    Examples:
      | Main menu           |  Sub menu| User Accounts |
      | Users & Accounts    | General  |   General     |

  @AddNewUSerAllAccoount
  Scenario Outline: Test scenario for creating new user in Admin with All customer Account
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>", for user and accounts
    Then User selects "<User Accounts>" in Orders page in admin login and validate user is in selected Tab
    And User should enable All customer toggle button and enter all the required fields, role to be selected "<Add filter>" and "<Filter detail>"
    Examples:
      | Main menu           |  Sub menu|   User Accounts    | Add filter | Filter detail |
      | Users & Accounts    | General  |   Add new user     |  Role      |   custadmin   |

  @AddNewUserAccount
  Scenario Outline: Test scenario for crating new user in Admin with single account
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>", for user and accounts
    Then User selects "<User Accounts>" in Orders page in admin login and validate user is in selected Tab
    And User enters Account number and enter all the required fields, role to be selected "<Add filter>" and "<Filter detail>"
    Examples:
      | Main menu           |  Sub menu|   User Accounts    | Add filter | Filter detail |
      | Users & Accounts    | General  |   Add new user     |  Role      |   custadmin   |

  @CreateUserWithDefaultEmail
  Scenario Outline: Test scenario for crating new user with default email address
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>", for user and accounts
    Then User selects "<User Accounts>" in Orders page in admin login and validate user is in selected Tab
    And User enters Account number and enter all the required fields, role to be selected "<Add filter>" and "<Filter detail>" with default email
    Examples:
      | Main menu           |  Sub menu|   User Accounts    | Add filter | Filter detail |
      | Users & Accounts    | General  |   Add new user     |  Role      |   custadmin   |

  @PermissionDeny
  Scenario Outline: Test scenario for Denying user account creation
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    #Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>", for user and accounts
    Then User selects "<User Accounts>" in Orders page in admin login and validate user is in selected Tab for pending registration
    And User selects user name from Pending registration drop down and click on Deny button
    Examples:
      | Main menu           |  Sub menu|   User Accounts                     |
      | Users & Accounts    | General  |   Pending registration approval     |

  @PermissionApprove
  Scenario Outline: Test scenario for approval of user account creation
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    #Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>", for user and accounts
    Then User selects "<User Accounts>" in Orders page in admin login and validate user is in selected Tab for pending registration
    And User selects user name from Pending registration drop down and click on Approve button
    Examples:
      | Main menu           |  Sub menu|   User Accounts                     |
      | Users & Accounts    | General  |   Pending registration approval     |
















