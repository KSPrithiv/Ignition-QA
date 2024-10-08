Feature: Order Entry4
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @UnUsualQtyCase
  Scenario:Test scenario for unusual  case
     Given User must be on Order Entry Page
     Then User must click Start Order button
     Then User should make selection between Pending order or Start New order
     Then User should select Note from popup and select OG from OG popup
     Then Enter PO# for New order
       |PO123|
    Then Enter Pro# in Quick Product Entry area for unusual qty verification
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
     And User should navigate to New OE page, and enter Qty to product in product grid for only Case
        |500|
     Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @UnUsualQtyUnitCase
  Scenario: Test scenario for creating order with unusual Qty "Maximum Qty exceeds"
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and select OG from OG popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for unusual qty verification
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    And User should navigate to New OE page, and enter Qty to product in product grid more than Maximum limit
      |100|100|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @OESearchProdForeignLanguage
  Scenario: Creating New order by entering foreign language product description  Product# in Searchbar, New order entry page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User enters foreign language description of Product in Search box
    Then Check for Catalog popup
    Then Enter the Qty in the Product grid Case and Unit
      | 1 | 1 |
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @AddCommentsToProduct
  Scenario: Adding comments at Product level
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
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
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
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
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on Comment icon in Product grid
   # And User should enter comment in comment popup at Product level
    And should enter comment in comment popup for updating
      |Comment at Product level|
    Then User should select comment from grid and edit comment as "<UpdateComm>"
    And User click on Update button in popup and Validate "<UpdateComm>"
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      | UpdateComm |
      | Edited Product comment level |

  @VerifyForDuplicateComment
  Scenario: Test scenario for verifying generation of duplicate comment should not happen
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on Comment icon in Order entry card
    And User should enter comment in comment popup
      |Comment at Order level for verifying duplicate comment|
    Then User should click on Comment icon in Product grid
    And should enter comment in comment popup
      |Comment at Product level|
    Then Click on Next button
    Then Click on Comment icon in Summary page
    And Enter Comment in summary page
      |Comment at Order level in order summary page|
    Then User checks for duplicate comments
    Then Click on SubmitOrder button
    Then User should be navigated to Order Entry page



