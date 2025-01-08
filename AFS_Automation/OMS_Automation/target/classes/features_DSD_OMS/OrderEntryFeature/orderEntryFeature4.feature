Feature: Order Entry4
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @ContinueWithoutProvidingPayment
  Scenario: For not selecting Payment method and proceeding with creation of order
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button and Click on Without providing payment
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @OEOrdHistoryWithProd
  Scenario: Create order by adding product from OG then adding order to OE from order history
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select OrderGuide option
      |SampleOG|
    And Enter Qty for the products in Product grid
      |1|1|
      |1|2|
    Then User should click on Copy from dropdown and Select Order history
      |Order history|
    Then User verifies Order history page and add history Order to order
    And Click on Copy button
#    Then User should select Note from popup and Order guide from popup
#    Then Enter PO# for New order
#      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @OEProductLine
  Scenario: Test scenario for creating OE using Product line
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and select OG from OG popup
    Then Enter PO# for New order
      |PO123|
    And User should navigate to New OE page, and enter Qty to product in product grid
      |1|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @UnUsualQtyUnit
  Scenario: Test scenario for unusual units
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and select OG from OG popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for unusual qty verification
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    And User should navigate to New OE page, and enter Qty to product in product grid for only Unit
      |200|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @NextButton
  Scenario: Test scenrio for handling Next button, in Save order without submitting popup
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on Back button in NewOE page and popup should appear
    And In Save order without submitting popup should select next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @PriceOverRideWhatIfPriceByPriceLowPrice
  Scenario: Test scenario for testing price override with "What if" option, price by price option. Price should be set to lower then the actual price
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for price override
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on price override icon and Change price using What if option Price by price
      |$0.20|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @PriceOverRideWhatIfPricePerUnitLowPrice
  Scenario: Test scenario for testing price override with "What if" option, price per unit option
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for price override
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on price override icon and Change price using What if option Price per unit
      |$0.20|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page