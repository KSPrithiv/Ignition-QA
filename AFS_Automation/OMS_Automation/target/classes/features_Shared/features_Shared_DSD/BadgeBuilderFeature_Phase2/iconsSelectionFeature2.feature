Feature: Badge Builder Icon Selection
  Background: For login to application and to select Badge Builder
    Given User enters URL and entered to login page

  @VerifyIconColorChangeInCatalogSearchListView
  Scenario:  Test Scenario to verify Icon color change in Catalog search list view
    Given  User on login page and entered username and password
    When   Navigated to Admin home page
    Then   Click on General Setting tab
    And    Clicks on Badge Builder
    And    Select Icon under icon selections
    And    Click Permission By and select appropriate Company
    And    User should navigate to Badge Gallery - CatchWeightItems
    And    Change Color of the Icon
    And    Logout from Admin portal
    When   Login to Client portal1
    Then   User should navigate to Client side
    And    Click on the Order Entry tab1
    And    Select Account2

  @VerifyChangeInCatalogSearchListView
  Scenario:  Test Scenario to verify Icon color change in Catalog search list
    Given  User should navigate to Order Tab
    And    Click new order and Enter PO
    And    Compare Product Icon color1

  @VerifyChangeInPickUpOrder0017
  Scenario:  Test Scenario to verify Icon color change in pick up order
    Given  User on Order Entry Page
    When   Click on Back
    Then   Select any date from Pickup Order
    And    Add Product in Order Entry

#  @VerifyChangeInOrderControlList
#  Scenario:  Test Scenario to verify Icon color change in OrderControlList
#    Given User should navigate to OrderControllist tab
#    And Click new order and Enter PO1
#    And Compare Product Icon color2

  @VerifyIconColorChangeInCart
  Scenario:  Test Scenario to verify Icon color change in Cart
    Given User should navigate to Catalog tab1
#    And   Search for product
    And   Click on Cart
    And   Verify Icon Color





