Feature: Badge Builder Icon Selection
  Background: For login to application and to select Badge Builder
    Given User enters URL and entered to login page

#
  @IconSelection
  Scenario: Test Scenario for Selecting Icon from Badge Builder
    Given  User on login page and entered username and password
    When   Navigated to Admin home page
    Then   Click on General Setting tab
    And    Clicks on Badge Builder
    And    Select Icon under icon selections
  @BadgeName
  Scenario: Test Scenario for Editing Badge Name
    Given  User should be on BadgeBuilder page
    When   Select Icon under icon selection
    And    Edit Badge name under Badge Info
    Then   Verify updated Badge name

  @BadgeCode
  Scenario: Test Scenario to verify Badge Code field
    Given  User should be on BadgeBuilder page
    When   Select Icon under icon selection
    Then   Verify Badge Code field

  @Save&AddToGallery
  Scenario: Test Scenario to verify Save&AddToGallery
    Given  User should be on BadgeBuilder page
    When   Select Icon under icon selection
    And    Change Badge name field under Badge Info
    And    Change Icon Color
    And    Clicks on Save and add to gallery button
    Then   Verify Saved Icon Changes

  @BadgeType
  Scenario: Test Scenario for Changing BadgeType
    Given  User must be on BadgeBuilder page
    Then   Change BadgeType and verify changes

  @DeleteAction
  Scenario: Test Scenario for Deleting Icon from Badge Builder
    Given  User must be on BadgeBuilder page
    When   User should navigate to Badge Gallery
    And    Click on any Badge under Badge Gallery
    Then   Verify delete button

  @EditAction
  Scenario: Test Scenario for Editing Icon from Badge Builder
    Given  User must be on BadgeBuilder page
    When   User should navigate to Badge Gallery
    And    Click on any Badge under Badge Gallery1
    And    Click on the Edit button
    And    Change Badge info, Icon color and Badge type
    And    Clicks on the Save and add to gallery button
    Then   Verify Saved Icon Change
#
  @VerifyColorChangeInOE-TieredPricingProducts
  Scenario: Test Scenario to Verify Icon Color Change In OrderEntry -  TieredPricingProducts
    Given  User must be on BadgeBuilder page
    When   Click Permission By and select appropriate Company
    And    User should navigate to Badge Gallery - TieredPricingProduct
    And    Change Color of the TieredPricingProduct Icon
    And    User should navigate to Badge Gallery - CatchWeightItems
    And    Change Color of the CatchWeightItems Icon
    And    Logout from Admin portal
    And    Login to Client portal
    Then   User should navigate to Client side
    And    Click on the Order Entry tab
    And    Select Account and start Order
    Then   Compare TieredPricingProduct Icon Color
#
#  @VerifyColorChangeInOE-CatchWeightItems
#  Scenario: Test Scenario to Verify Icon Color Change In OrderEntry -  CatchWeightItems
#
#    Given  User on login page and entered username and password
#    When   Navigated to Admin home page
#    Then   Click on General Setting tab
#    And    Clicks on Badge Builder
#
#    Given  User must be on BadgeBuilder page
#    When   Click Permission By and select appropriate Company
#    And    User should navigate to Badge Gallery - CatchWeightItems
#    And    Change Color of the CatchWeightItems Icon
#    And    Logout from Admin portal
#    And    Login to Client portal
#    Then   User should navigate to Client side
#    And    Click on the Order Entry tab
#    And    Select Account and start Order - CatchWeightItems
#    Then   Compare CatchWeightItems Icon Color

  @VerifyColorChangeInCatalogTab-CatchWeightItems
  Scenario: Test Scenario to Verify Icon Color Change In Catalog -  CatchWeightItems
    Given  user must be on Order Entry Page
    Then   user should navigate to Catalog tab
    And   Search for Catchweight Item
    Then  Compare Catlog CatchWeightItems Icon Color










