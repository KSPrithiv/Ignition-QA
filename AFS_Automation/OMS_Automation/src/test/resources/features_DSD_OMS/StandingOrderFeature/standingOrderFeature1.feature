Feature: Standing Order1
  Creation of Standing order and all operation related to standing order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for SO
    When User is on Home Page for SO
    Then User navigate to Client side for SO
    Then User should select Order Entry tab for SO
    Then User selects Account# for SO

  @CopyStandingOrder
  Scenario: Test scenario for copying Standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then User checks for all the prodcuts in Active SO
    And User clicks on Copy Standing order button selects start and end date as 25 and 26 day from current date
    Then User checks for the products added to copied SO

  @ValidateDeliverySchedule
  Scenario: Test scenario for validating Delivery schedule default value
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then User should validate that Standing order Delivery schedule by default having Every week option

  @StandingOrderWithoutEndDate
  Scenario: Creation of standing order without giving any end date
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 27 from current date
    Then User enters Product# in Quick product entry inputbox
    And User enters Qty in standing order product grid based on enabled days
      |10|20|30|40|15|10|5|
    Then User clicks on Save button and handles popup
    And User should validate that there is no end date assigned to standing order

  @OverlappedStandingOrder
  Scenario: Test scenario for creating standing order using Quick product entry input box
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User click on Start standing order button and selects Start date 2 and End date 2 day from current date
    Then User should validate Standing Order dialog box for SO already existing

  @StandingOrderRegisterExcel
  Scenario: Test scenario for generating Excel sheet for standing order registration
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User should click on Standing Order Register button
    Then User should search for Customer and Route in Standing order register popup
    And User should click on Excel button, should download csv files

  @StandingOrderRegisterPdf
  Scenario: Test scenario for generating Excel sheet for standing order registration
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User should click on Standing Order Register button
    Then User should search for Customer and Route in Standing order register popup
    And User should click on PDF button, should Open new browser

  @StandingOrderRegisterCancel
  Scenario: Test scenario for generating Excel sheet for standing order registration cancel option
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User should click on Standing Order Register button
    Then User should search for Customer and Route in Standing order register popup
    And User should Click on Cancel button

  @GenerateStandingOrder
  Scenario:Test scenario for generating standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User should click on Generate Standing order  button
    Then User should select From and To date in Generate standing order(s) popup, Click on Ok
    And User should click on ok, in All task completed popup

  @DeleteStandingOrder
  Scenario: Test scenario for deleting all the standing orders which are active and pending
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then User navigates to Standing order card and clicks on Delete button

  @DeleteExpiredStandingOrder
  Scenario: Test scenario for deleting expired standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    Then User navigates to Standing order card and selects the first expired standing order
    And User sucessfuly deletes expired standing order

  @ChangeAccountNumber
  Scenario: Test scenario for changing customer account# and createing standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User changes Customer account# for creating SO for some other customer
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
