Feature: OMS Phase2 ThemeBuilder Page Verification

  Background: For login to application
    Given User enters correct URL and opened login page

  @ThemeBuilderLoginCardPositionLeft
  Scenario: TC012 Theme Builder Login Card position Left
    When   Enter correct Admin username and password
    Then   Admin Page is open successfully
    When   User click on permission by dropdown
    And    Select any company from dropdown
    Then   User click on the General settings tab
    And    User click on the Branding Option under general settings
    Then   User click on left side icon of login card position
    And    click on save button
    Then   Logout from admin
    And    Login with Client credential and validate login page preview
    Then   Logout from Client
    And    Validate login page should display the login box at left side of the screen

  @ThemeBuilderLoginCardPositionCenter
  Scenario: TC013 Theme Builder Login Card position Center
    When   Enter correct Admin username and password
    Then   Admin Page is open successfully
    When   User click on permission by dropdown
    And    Select any company from dropdown
    Then   User click on the General settings tab
    And    User click on the Branding Option under general settings
    Then   User click on center side icon of login card position
    And    click on save button
    Then   Logout from admin
    And    Login with Client credential and validate login page preview
    Then   Logout from Client
    And    Validate login page should display the login box at center side of the screen

  @ThemeBuilderLoginCardPositionRight
  Scenario: TC014 Theme Builder Login Card position Right
    When   Enter correct Admin username and password
    Then   Admin Page is open successfully
    When   User click on permission by dropdown
    And    Select any company from dropdown
    Then   User click on the General settings tab
    And    User click on the Branding Option under general settings
    Then   User click on right side icon of login card position
    And    click on save button
    Then   Logout from admin
    And    Login with Client credential and validate login page preview
    Then   Logout from Client
    And    Validate login page should display the login box at right side of the screen

  @ThemeBuilderLoginPageTitle
  Scenario: TC015 Theme Builder Enter Login Page Title
    When   Enter correct Admin username and password
    Then   Admin Page is open successfully
    Then   User click on the General settings tab
    And    User click on the Branding Option under general settings
    Then   User Enter title value in the title text box
    And    click on save button
    Then   Logout from admin
    And    Login with Client credential and validate login page preview
    Then   Logout from Client
    And    Validate login page should display the same title on the page

  @ThemeBuilderDefaultThemeSettings
  Scenario: TC016 Theme Builder Default Theme Settings
    When   Enter correct Admin username and password
    Then   Admin Page is open successfully
    When   User click on permission by dropdown
    And    Select any company from dropdown
    Then   User click on the General settings tab
    And    User click on the Branding Option under general settings
    Then   Click on default theme radio button to select default theme
    And    Validate login preview and click on save button
    Then   Logout from admin
    And    Login with Client credential and validate login page preview
    Then   Logout from Client
    And    Validate login page should display the default theme