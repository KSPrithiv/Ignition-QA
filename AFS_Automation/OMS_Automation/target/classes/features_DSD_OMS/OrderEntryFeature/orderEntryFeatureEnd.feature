Feature: Order entry End

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

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
    And User should reset the delivery date to current date

  @CancelAndSkip
  Scenario: Test scenario for Skip using cancel button in new order entry page
    Given User must be on Order Entry Page
    Then Change the date 5 days after current date
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then User click on Cancel button and Popup should appear
    And User should click on Cancel and skip button by selecting reason
      |Closed|
    Then User should be navigated to Order Entry page
    Then Check for Remove Skip button is visible and Click on Remove Skip button
    And User should reset the delivery date to current date

  @CancelAndSkipEnabled
  Scenario: Test scenario for verifying Cancel and Skip button is enabled in new OE page
    Given User must be on Order Entry Page
    Then Change the date 5 days after current date
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Click on Cancel button
    And Cancel popup should appear and verify button Cancel and Skip button
    Then User should be navigated to Order Entry page
    And User should reset the delivery date to current date

  @SkipOrder
  Scenario: Skip order, which will not let user to create New order for selected date
    #Given User must be on Order Entry Page to Skip Order
    Given User must be on Order Entry Page
    Then Change the date 5 days after current date
    Then Check for Skip button is visible and Click on Skip button and select reason
      |Closed|
    And Check for visibility of Remove Skip button
    And User should reset the delivery date to current date

  @RemoveSkipOrder
  Scenario:Remove Skip order button, that appears in OE page
    #Given User must be on Order Entry Page to Skip Order
    Given User must be on Order Entry Page
    Then Change the date 5 days after current date
    Then Check for Remove Skip button is visible and Click on Remove Skip button
    And User should reset the delivery date to current date

  @SkipFromNewOrderEntry
  Scenario: Skip the creation of order from new order entry page
    #Given User must be on Order Entry Page to Skip Order
    Given User must be on Order Entry Page
    Then Change the date 5 days after current date
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Click on Skip button in New order entry page and also select the reason
      |closed|
    Then User should be navigated to Order Entry page
    Then Check for Remove Skip button is visible and Click on Remove Skip button
    And User should reset the delivery date to current date

  @CancelAndSkipDisabled
  Scenario: Test scenario for verifying Cancel and Skip button is disabled in new OE
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Click on Cancel button
    And Cancel popup should appear and verify button Cancel and Skip button for current date
    Then User should be navigated to Order Entry page
    And User should reset the delivery date to current date

  @ChangeGridAndChangePriceOverride
  Scenario: Test scenario for verifying price override by changing the price after chanigng gird
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
    Then User verifies visibility of Price override icon change the Price in price override and reset Grid type to Main grid
      |0.001|
    And User navigates back to OE by selecting Discard all option from pending order popup



