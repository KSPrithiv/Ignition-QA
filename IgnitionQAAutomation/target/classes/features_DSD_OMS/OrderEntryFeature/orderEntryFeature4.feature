Feature: Order Entry3
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
      Then User should select Note from popup
      Then User should find select Order guide from popup
      Then Enter PO# for New order
        |PO123|
      Then Enter Pro# in Quick Product Entry area
      And Check for Case and Unit input box enabled or not based on that enter value
        |20|20|
      Then Click on Next button and Click on Without providing payment
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page

    @OEOrdHistoryWithProd
    Scenario: Create order by adding product then adding order to OE
      Given User must be on Order Entry Page
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup
      Then User should find select Order guide from popup
      Then Enter PO# for New order
        |PO123|
      Then Enter Pro# in Quick Product Entry area
      And Check for Case and Unit input box enabled or not based on that enter value
        |20|20|
      Then User should click on Copy from dropdown and Select Order history
        |Order history|
      Then User verifies Order history page and click on checkbox
      And Click on Copy button
      Then Click on Next button
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page

  @AddCommentsToProduct
  Scenario: Adding comments at Product level
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup
    Then User should find select Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|50|
    Then User should click on Comment icon in Product grid
    And should enter comment in comment popup
      |Comment at Product level|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @ProductCommentColor
  Scenario: Adding comments at Product level and change of color of comment icon
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup
    Then User should find select Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |10|20|
    Then User should click on Comment icon in Product grid
    And should enter comment in comment popup
      |Comment at Product level|
    Then Check Comment Icon color at product level has changed or not
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @ProductCommentUpdate
  Scenario Outline: Adding comments at Product level and update comment
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup
    Then User should find select Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |10|20|
    Then User should click on Comment icon in Product grid
    And User should enter comment in comment popup at Product level
      |Comment at Product level|
    Then User should select comment from grid and edit comment as "<UpdateComm>"
    And User click on Update button in popup and Validate "<UpdateComm>"
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
    | UpdateComm |
    | Edited Product comment level |

    @OEProductLine
    Scenario: Test scenario for creating OE using Product line
      Given User must be on Order Entry Page
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup
      Then User should find select Order guide from popup and select OG
      Then Enter PO# for New order
        |PO123|
      And User should navigate to New OE page, and enter Qty to product in product grid
        |50|60|
      Then Click on Next button
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page

    @UnUsualQtyUnitCase
    Scenario: Test scenario for creating order with unusual Qty "Maximum Qty exceeds"
      Given User must be on Order Entry Page
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup
      Then User should find select Order guide from popup and select OG
      Then Enter PO# for New order
        |PO123|
      And User should navigate to New OE page, and enter Qty to product in product grid more than Maximum limit
        |200|200|
      Then Click on Next button
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page

    @UnUsualQtyUnit
    Scenario:
    Test scenario for creating order with unusual Qty for unit "Maximum Qty exceeds"
      Given User must be on Order Entry Page
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup
      Then User should find select Order guide from popup and select OG
      Then Enter PO# for New order
        |PO123|
      And User should navigate to New OE page, and enter Qty to product in product grid for only Unit
        |200|
      Then Click on Next button
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page

  @UnUsualQtyCase
  Scenario:Test scenario for creating order with unusual Qty for case "Maximum Qty exceeds"
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup
    Then User should find select Order guide from popup and select OG
    Then Enter PO# for New order
      |PO123|
    And User should navigate to New OE page, and enter Qty to product in product grid for only Case
      |200|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page