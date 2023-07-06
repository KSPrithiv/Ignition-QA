Feature: OMS ThemeBuilder Page Verification

  Background: For login to application
    Given User enters correct URL and opened login page

  @ThemeBuilderPageVerification
  Scenario: TC001 Theme Builder page verification
    Given  User able to open login page
    When   User entered correct Admin username and password
    Then   Admin Page is opened successfully
    And    User click on the General settings option
    Then   User click on the Branding Option
    And    Verify there should be twentyFive default themes available
    And    Verify all theme image should appear

  @ThemeBuilderAnyThemeSelection
  Scenario: TC002 Theme Builder Selection of any Image
    Then   User click on the Branding Option
    Then   Select any image in the theme and validate preview

  @MyOwnThemeLightHeaderText
  Scenario: TC003 Theme Builder My Own Theme verification with Light Header Text
    When   Select My own theme radio button with Light header text
    Then   Click on choose photo to select custom theme and validate preview of light header text

  @MyOwnThemeDarkHeaderText
  Scenario: TC004 Theme Builder My Own Theme verification with Dark Header Text
    When   Select My own theme radio button with Dark header text
    Then   Click on choose photo to select custom theme and validate preview of dark header text

  @PrimaryThemeColourSelection
  Scenario: TC005 Theme Builder Select any primary theme colour and validate colour of main component change
    When   Select any primary theme colour
    Then   Validate preview of main component with primary colour

  @SecondaryThemeColourSelection
  Scenario: TC006 Theme Builder Select any secondary theme colour and validate colour of save button changed
    When   Select any secondary theme colour
    Then   Validate preview of other component with secondary colour

  @ResetDefaultThemeSettings
  Scenario: TC007 Theme Builder reset default theme settings
    When   User click on reset default theme settings
    Then   Validate colors are back to default colors

  @CompanyLogoVerification
  Scenario: TC008 Theme Builder Verification of company logo
    When   User click on select files under company logo section
    Then   Verify company logo should appear in the center card of the login page

  @CancelAnyChanges
  Scenario: TC009 Theme Builder cancel the changes which are making on the page
    When   User select any theme and make any changes with theme
    Then   User click on cancel button to discard all changes

  @CompanyLevelSettings
  Scenario: TC011 Theme Builder Verify company level settings
    Then   User click permission by dropdown
    And    Select any other than company from permission by dropdown
    Then   Validate that theme builder is disappearing for other company level it only accessible for company level
    Then   Click on logout

  @SaveAnyChanges
  Scenario: TC010 Theme Builder save the changes which are making on the page
    When   User entered correct Admin username and password
    Then   Admin Page is opened successfully
    When   Click on the permission by DD and Select company which client user registered
    And    User click on the General settings option
    Then   User click on the Branding Option
    When   User select any theme and make any changes with theme to save
    Then   User click on save button to save all changes
    Then   Click on logout
    And    Validate login page is updated according to theme selection
    Then   Login with client and validate colors of components are updated
    And    Click on every module in left menu and validate all module master page should change according to new theme
    Then   Click on logout
    And    Validate login page is updated according to theme selection

