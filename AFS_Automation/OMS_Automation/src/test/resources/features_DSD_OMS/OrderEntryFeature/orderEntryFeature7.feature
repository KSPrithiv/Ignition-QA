Feature: Order Entry7
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @EditWithOutChanging
  Scenario:Test scenario for creating Order and edit it without making any changes, or usage of back to order list in summary page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |80|60|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page
    Then Click on Next button after editing order
    And User should be in Order summary page and click on back to Orderlist button

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
    And User clicks on Grid type drop down and select different grid
    #  |Regression grid|
    Then User verifies visibility of Price override icon and reset Grid type to Main grid
     # |Main grid|
    And User navigates back to OE by selecting Discard all option from pending order popup

  @ChangeGridAndChangePriceOverride
  Scenario: Test scenario for verifying price override by changing the price after chanigng gird
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and select any OG from popup
      |SampleOG|
    Then Enter PO# for New order
      |PO123|
    Then User should enter Units and Cases in product grid
      |80|60|
    And User clicks on Grid type drop down and select different grid
   #   |Regression grid|
    Then User verifies visibility of Price override icon change the Price in price override and reset Grid type to Main grid
     |0.01|
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
      |test grid|
    Then User verifies visibility of Price override icon and reset Grid type to Main grid in Order history page
      |Main grid|
    And User should navigate back to Order entry page from Order history page

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
      |80|60|
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