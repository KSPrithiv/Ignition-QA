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
    |4|
  Then Click on Back button
  And Discard all Pending order should be displayed
  Then User should be navigated to Order Entry page


@LastdatePickupOrder
Scenario: Test scenario for creating order for the Last date in Pickup order dialogbox
  Given User must be on Order Entry Page
  When User clicks on drop down next to Start order button
  And Select Pickup Order from drop down options and select last delivery date
  Then User should select Note from popup and Order guide from popup
  Then Enter PO# for New order
    |PO123|
  Then Enter Pro# in Quick Product Entry area
  And Check for Case and Unit input box enabled or not based on that enter value
    |50|60|
  Then Click on Next button
  And Click on SubmitOrder button
  Then User should be navigated to Order Entry page and compare the dates

