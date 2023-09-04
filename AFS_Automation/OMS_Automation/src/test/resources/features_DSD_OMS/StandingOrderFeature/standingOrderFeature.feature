Feature: Standing Order
  Creation of Standing order and all operation related to standing order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for SO
    When User is on Home Page for SO
    Then User navigate to Client side for SO
    Then User should select Order Entry tab for SO
    Then User selects Account# for SO

  @StandingOrderCatalogCreate
  Scenario: Test scenario for creating standing order, using catalog
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects start and end date from popup
    Then User click on Add Product button in Standing order page and select catalog option
    And User checks for catalog popup and searches for product in catalog
    And User enters Qty in standing order product grid based on enabled days for multiple products
      |10|20|30|40|15|10|5|
      |2 |4 |6 |8 |10|12|14|
      |3 |5 |7 |9 |11|13|15|
      |12|24|6 |32|16|12|8 |
      |24|8 |14|22|12|10|8 |
    Then User clicks on Save button and handles popup

  @VerifyingDisableSelectButton
   Scenario: Test scenario for verifying whether select button is disabled or not in catalog popup
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then read the first product from the product grid and click on add product button
    And verify for display of catalog, enter product number to be searched and validate select button

  @DeleteProductFromStandingOrder
  Scenario:Test scenario for Deleting product from standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then read the first product from the product grid and click on check box
    And User clicks on Delete Product button and confirms deletion

  @SkipSpecificDay
  Scenario: Test scenario for skipping specific date in standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then Click on Skip specific day and select reason date for skip in skip popup and click on ok

  @VerifySkipDateSetInSOWithOE
  Scenario: Test scenario for verifying skip in SO with skip in OE page
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then User Click on Skip specific day and read the skip date value and click on Ok
    And User should navigate to OE page, User should select the same delivery date from calender
    Then User should verify for that date remove skip has been enabled or Skip has been disabled

  @RemoveSkipSpecificDay
  Scenario: Test scenario for remove skipping specific date in standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then Click on Skip specific day and select first date in the list of skip days in skip popup and click on ok

  @StandingOrderQuickProCreate
  Scenario: Test scenario for creating standing order using Quick product entry input box
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 2 and End date 2 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |10|20|30|40|15|10|5|
    Then User clicks on Save button and handles popup

  @MultipleStandingOrder
  Scenario: Test scenario for creating multiple standing orders
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 3 and End date 4 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |10|20|30|40|15|10|5|
    Then User clicks on Save button and handles popup and continue creation of multiple standing order
    And User click on Start standing order button and selects Start date 9 and End date 15 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |10|20|30|40|15|10|5|
    Then User clicks on Save button and handles popup and continue creation of multiple standing order
    And User click on Start standing order button and selects Start date 4 and End date 8 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |10|20|30|40|15|10|5|
    Then User clicks on Save button and handles popup

  @CatalogCard
  Scenario: Test scenario for creating standing order using catalog standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 16 and End date 17 day from current date
    Then User click on Add Product button in Standing order page and select catalog option
    And User should make sure that Catalog popup displayed in card view and select Category values
    Then Select products from card view
    And User enters Qty in standing order product grid based on enabled days
      |10|20|30|40|15|10|5|
    Then User clicks on Save button and handles popup

  @OverlappingDates
  Scenario: Test scenario for creating Standing orders with overlapped dates
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 21 and End date 24 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |10|20|30|40|15|10|5|
    Then User clicks on Save button and handles popup
    And User should go through dates of standing order and count number of standing orders
    And User click on Start standing order button and selects Start date 18 and End date 22 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |40|15|20|40|15|10|15|
    Then User clicks on Save button and handles popup
    And User should go through dates of standing order and count number of standing orders after overlapping dates




