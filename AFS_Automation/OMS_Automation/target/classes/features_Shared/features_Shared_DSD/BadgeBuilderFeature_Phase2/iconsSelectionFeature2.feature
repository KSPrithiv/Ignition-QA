Feature: Badge Builder Icon Selection
  Background: For login to application and to select Badge Builder
    Given User enters URL and entered to login page

<<<<<<< HEAD
  @VerifyIconColorChangeInCatalogSearchListView
=======
  @VerifyIconColorChangeInCatalogSearchListView-OrderEntryPage
>>>>>>> cfd851261460b93c4e6039073ff046846beedf5f
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
<<<<<<< HEAD
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
=======
#    And    Select Account2



  @VerifyChangeInPickUpOrder0017
  Scenario:  Test Scenario to verify Icon color change in pick up order
#    Given  User on Order Entry Page
#    When   Click on Back
    Then   Select any date from Pickup Order
    And    Add Product in Order Entry
    And    Verify Icon Color from PickupOrder
>>>>>>> cfd851261460b93c4e6039073ff046846beedf5f

#  @VerifyChangeInOrderControlList
#  Scenario:  Test Scenario to verify Icon color change in OrderControlList
#    Given User should navigate to OrderControllist tab
#    And Click new order and Enter PO1
#    And Compare Product Icon color2

  @VerifyIconColorChangeInCart
  Scenario:  Test Scenario to verify Icon color change in Cart
    Given User should navigate to Catalog tab1
<<<<<<< HEAD
#    And   Search for product
    And   Click on Cart
    And   Verify Icon Color

=======
    And   Search for product
    And   Click on Cart
    And   Verify Icon Color

  @VerifyChangeInCatalogSearchListView
  Scenario:  Test Scenario to verify Icon color change in Catalog search list
    Given  User should navigate to Order Tab
    And    Click new order and Enter PO
    And    Compare Product Icon color1
    And    Logout

>>>>>>> cfd851261460b93c4e6039073ff046846beedf5f




