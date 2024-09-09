Feature: Navigation pannel
  Verifying behaviour of navigation pannel on left of the screen

  Background: For login to application
    Given User enters URL and is on login page and entered credentials for Admin setting
    When User is on Home Page for Admin setting

  @HamburgerIcon
  Scenario: Test scenario for verifying existence of hamburger icon
    Given User should be on Admin page
    Then User verifies existance of hamburger icon

  @SearchBar
  Scenario: Test scenario for verifying searchbar in left menubar
    Given User should be on Admin page
    Then User clicks on hamburger menu and verifies existence of search bar

  @CollapsingPermissionBar
  Scenario: Test scenario for verifying collapsing of Permission bar when hamburger menu bar
    Given User should be on Admin page and click on permission dropdown
    Then User clicks on hamburger menu and should make sure that permission dropdown menu is closed

  @MenuNavigationVerification
  Scenario: Test scenario for verifying menu navigation
    Given User should be on Admin page
    Then User clicks on hamburger menu and verifies existence of search bar
    Then User enters some menu item for searching
    |Login|
    Then User Logout from application

  @ClientSideHamburger
  Scenario: Test scenario to verify all above in client side
    Given User should be on login page and enter client credentials
    And User should verify that he is in landing page
    Then User verifies existance of hamburger icon
    Then User clicks on hamburger menu and verifies existence of search bar
    Then User clicks on hamburger menu and should make sure that permission dropdown menu is closed
    Then User enters some menu item for searching
    |Login|

