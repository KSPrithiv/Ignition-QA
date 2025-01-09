Feature: Order Entry8
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

@FilteringInCatalogByBrand
Scenario: Test scenario for filtering Brand in catalog popup
  Given User must be on Order Entry Page
  Then User must click Start Order button
  Then User should make selection between Pending order or Start New order
  Then User should select Note from popup and Order guide from popup
  Then Enter PO# for New order
    |PO123|
  Then Click on Add product drop down and select catalog option
  And User searches for Brand and goes through the product numbers
  Then Click on Back button
  And Discard all Pending order should be displayed
  Then User should be navigated to Order Entry page

@FilteringInCatalogByQoH
Scenario: Test scenario for filtering Qty on Hand in catalog popup
  Given User must be on Order Entry Page
  Then User must click Start Order button
  Then User should make selection between Pending order or Start New order
  Then User should select Note from popup and Order guide from popup
  Then Enter PO# for New order
    |PO123|
  Then Click on Add product drop down and select catalog option
  And User searches for QoH and goes through the product numbers
    |0|
  Then Click on Back button
  And Discard all Pending order should be displayed
  Then User should be navigated to Order Entry page

@SearchProductCatalogIndexDialogbox
Scenario: Test scenario for searching for product in catalog index dialog box
  Given User must be on Order Entry Page
  Then User must click Start Order button
  Then User should make selection between Pending order or Start New order
  Then User should select Note from popup and Order guide from popup
  Then Enter PO# for New order
    |PO123|
  Then Click on Add product drop down and select catalog option
  And User should select Product from catalog Index popup search input box and Enter Qty for the products
    |1|1|
  Then Click on Next button
  And Click on SubmitOrder button
  Then User should be navigated to Order Entry page

@PaymentOptionsDisabled
Scenario: Test scenario to verify that payment page all payment options are disabled once order is submitted and reopen the order
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button and select the very first payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    And User should verify that payment options in Payment page are disabled
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

@CheckPaymentInfoInSummaryPage
Scenario: Test scenario to verify payment info in summary page
  Given User must be on Order Entry Page
  Then User must click Start Order button
  Then User should make selection between Pending order or Start New order
  Then User should select Note from popup and Order guide from popup
  Then Enter PO# for New order
    |PO123|
  Then Enter Pro# in Quick Product Entry area
  And Check for Case and Unit input box enabled or not based on that enter value
    |1|1|
  Then Click on Next button and read payment methods
  And Click on SubmitOrder button and compare payment info
  Then User should be navigated to Order Entry page

  @PriceOverRideWhatIfPermanent
  Scenario: Test scenario for testing price override with "What if" option, Permanent price overrdie
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for price override
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on price override icon and Change price using What if option Price per unit and change length value to Permanent
      |$0.20|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @PriceOverRideWhatIfSameDay
  Scenario: Test scenario for testing price override with "What if" option, Permanent price overrdie
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for price override
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on price override icon and Change price using What if option Price per unit and change length value to Same day
      |$0.20|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @ChangeShippingAddress
  Scenario: Test scenario for changing shipping address
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |2|2|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page and check for New OE page for editing Order by changing shipping address
    Then Click on Next button and change shipping address
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page


