Feature: Order Entry7
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @FiltersInCatalogIndexPage
  Scenario: Test scenario for filtering of products in catalog index popup
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      | PO123 |
    Then Click on Add product drop down and select catalog option
    And User should validate Catalog dialogbox and use filters in customer index dialogbox

  @LastdatePickupOrder
  Scenario: Test scenario for creating order for the Last date in Pickup order dialogbox
    Given User must be on Order Entry Page
    When User clicks on drop down next to Start order button
    And Select Pickup Order from drop down options and select last delivery date
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order for Pickup order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
   # And Click on SubmitOrder button
   # Then User should be navigated to Order Entry page and compare the dates
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page and compare the dates
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page
    Then Click on Cancel button
    And Check for Warning popup
    Then User should be navigated to Order Entry page

  @EditWithOutChangingBackToOrderList
  Scenario:Test scenario for creating Order and edit it without making any changes, or usage of back to order list in summary page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page
    Then Click on Next button after editing order
    And User should be in Order summary page and click on back to Orderlist button
    Then User should be navigated to Order Entry page

  @EditWithOutChanging
  Scenario:Test scenario for creating Order and edit it without making any changes
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page
    Then Click on Next button after editing order
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @ContactInformation
  Scenario: Test scenario for finding the contact information details
    Given User must be on Order Entry Page
    Then User clicks on icon next to address

  @PrivacyPolicy
  Scenario: Test scenario for finding the privacy policy
    Given User must be on Order Entry Page
    Then User clicks on Privacy policy link and window with pivacy policy will open, user handles it

  @ChangeGridAndValidatePriceOverride
  Scenario: Test scenario for verifying price override icon after chanigng gird
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and select any OG from popup
      |SampleOG|
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    And User clicks on Grid type drop down and select different grid
     # |Regression grid|
    Then User verifies visibility of Price override icon and reset Grid type to Main grid
      #|Main grid|
    And User navigates back to OE by selecting Discard all option from pending order popup

  @OrderHistoryChangeGridType
  Scenario: Test scenario for changing grid type in order history
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User should click on Copy from dropdown and Select Order history
      |Order history|
    Then User verifies Order history page and change grid types
    Then User changes grid to verify and reset Grid type to Main grid in order history page
    And User should navigate back to Order entry page from Order history page




