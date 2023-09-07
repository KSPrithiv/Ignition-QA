Feature: Badge Builder Icon Selection
  Background: For login to application and to select Badge Builder
    Given User enters URL and entered to login page

  @VerifyIconColorChangeInCatalogSearchListView-OrderEntryPage
  Scenario:  Test Scenario to verify Icon color change in Catalog search list view
    Given  User on login page and entered username and password
    When   Navigated to Admin home page1
    Then   Click on General Setting tab1
    And    Clicks on Badge Builder
    And    Select Icon under icon selections
    And    Click Permission By and select appropriate Company1
    And    User should navigate to Badge Gallery - CatchWeightItems
    And    Change Color of the Icon
    And    Logout from Admin portal1
    When   Login to Client portal BadgeBuilder2
    Then   User should navigate to Client side1
    And    Click on the Order Entry tab1
#    And    Select Account2



  @VerifyChangeInPickUpOrder0017
  Scenario:  Test Scenario to verify Icon color change in pick up order
#    When   Click on Back
    Then   Select any date from Pickup Order1
    And    Add Product in Order Entry1
    And    Verify Icon Color from PickupOrder

#  @VerifyChangeInOrderControlList
#  Scenario:  Test Scenario to verify Icon color change in OrderControlList
#    Given User should navigate to OrderControllist tab
#    And Click new order and Enter PO1
#    And Compare Product Icon color2

  @VerifyIconColorChangeInCart
  Scenario:  Test Scenario to verify Icon color change in Cart
    Given User should navigate to Catalog tab1
    And   Search for product
    And   Click on Cart1
    And   Verify Icon Color

  @VerifyChangeInCatalogSearchListView
  Scenario:  Test Scenario to verify Icon color change in Catalog search list
    Given  User should navigate to Order Tab1
    And    Click new order and Enter PO
    And    Compare Product Icon color1
    And    Logout1





