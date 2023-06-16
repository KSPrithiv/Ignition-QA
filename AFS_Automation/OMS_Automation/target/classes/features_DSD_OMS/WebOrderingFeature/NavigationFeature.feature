Feature: Admin setting
  Verifying Admin setting features for Navigation menu bar

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Admin setting
    When User is on Home Page for Admin setting
    Then User Clicks on Permissions by drop down to select Customer Account#

  @DragAndDropMenu
  Scenario Outline: Test scenario to drag and drop menu item in admin setting
    Given User is on Home Page for Admin setting to select Admin option
    And User should enter menu "<Option>" in search bar to navigate to Authorized Products
    Then User should Drag and drop menu item from Web order menu to Available apps
    And User should Drag and drop Available apps item to Web order menu
    Examples:
      |Option      |
      |Navigation  |




