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
      |1|1|2|1|1|1|1|
      |1|2|1|1|2|1|1|
      |2|1|1|1|1|1|1|
      |1|2|1|1|1|1|1|
      |1|1|2|1|1|1|1|
    Then User clicks on Save button and handle success popup

  @VerifyingDisableSelectButton
   Scenario: Test scenario for verifying whether select button is disabled or not in catalog popup
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then read the first product description from the product grid and click on add product button
    And verify for display of catalog, enter product Description to be searched and validate select button

  @DeleteProductFromStandingOrder
  Scenario:Test scenario for Deleting product from standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then read the first product from the product grid and click on check box
    And User clicks on Delete Product button and confirms deletion

  @SkipSpecificDay
  Scenario: Test scenario for skipping specific date in standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then Click on Skip specific day and select any enabled day from current date,select reason date for skip in skip popup and click on ok

  @RemoveSkipSpecificDay
  Scenario: Test scenario for remove skipping specific date in standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then Click on Skip specific day and select first date in the list of skip days in skip popup and click on ok

  @VerifySkipDateSetInSOWithOE
  Scenario: Test scenario for verifying skip in SO with skip in OE page
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then Click on Skip specific day and select any enabled day from current date,select reason date for skip in skip popup and click on ok
    Then User Click on Skip specific day and read the skip date value and click on Ok
    And User should navigate to OE page, User should select the same delivery date from calender
    Then User should verify for that date remove skip has been enabled or Skip has been disabled

  @StandingOrderQuickProCreate
  Scenario: Test scenario for creating standing order using Quick product entry input box
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 2 and End date 2 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |1|2|1|1|1|1|1|
    Then User clicks on Save button and handle success popup

  @MultipleStandingOrder
  Scenario: Test scenario for creating multiple standing orders
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 3 and End date 4 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
        |1|2|1|1|1|2|1|
    Then User clicks on Save button and handles popup and continue creation of multiple standing order
    And User click on Start standing order button and selects Start date 9 and End date 15 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |2|1|1|1|1|1|1|
    Then User clicks on Save button and handles popup and continue creation of multiple standing order
    And User click on Start standing order button and selects Start date 4 and End date 8 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |1|2|1|1|1|1|1|
    Then User clicks on Save button and handle success popup

  @CatalogCard
  Scenario: Test scenario for creating standing order using catalog standing order, by selecting category value
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 16 and End date 17 day from current date
    Then User click on Add Product button in Standing order page and select catalog option
    And User should make sure that Catalog popup displayed in card view and select Category values
    Then Select products from Catalog popup
    And User enters Qty in standing order product grid based on enabled days
      |2|1|1|1|1|1|1|
    Then User clicks on Save button and handle success popup

  @DatesRangeValidation
  Scenario: Test scenario for creating Standing orders with new standing order if the date range mentioned fall into the range of another active SO
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 21 and End date 24 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |1|1|1|1|1|1|2|
    Then User clicks on Save button and handle success popup
    And User should go through dates of standing order and count number of standing orders
    And User click on Start standing order button and selects Start date 18 and End date 22 day from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |1|1|1|1|1|2|1|
    Then User clicks on Save button and handle success popup
    And User should go through dates of standing order and count number of standing orders after overlapping dates




