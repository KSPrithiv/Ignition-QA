Feature: Order Entry1
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @OERegular
  Scenario: Creating New order using Order type
    Given User must be on Order Entry Page
    Then Click on Dropdown next to Ordertype input box Order type Popup should display
      |Description|REGULAR ORDER|
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|80|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page

  @SearchOrderAddfilter
  Scenario: Creating New order and search for that order by using add filter
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|60|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    And Click on Add filter button and search for order using search options

  @CopyFromOrderHistroy
  Scenario: Creating new order, using 'Copy from' drop down in New order entry page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User should click on Copy from dropdown and Select Order history
      |Order history|
    Then User verifies Order history page and add history Order to order
    And Click on Copy button
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @CreateOEOrderGuide
  Scenario: Creating New order by using Order guide
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select OrderGuide option
    |SampleOG|
    And Enter Qty for the products in Product grid
      |50|70|
      |40|60|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @AddCommentsToOrder
  Scenario: Adding comments at order level
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
      |Comment at Order level|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @CopyOrderHistoryFromOrderSummary
  Scenario: Creating new order using history order, and click on copy button in order history summary page
    Given User must be on Order Entry Page
    Then Click on History button
    Then User verifies Order history page and add history Order to order select Order
    Then Click on Copy button in Summary page
    And User should Select delivery date from popup
    And Select New order option from popup
    And User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then User should enter Units and Cases in product grid
      |70|80|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @AddCommentInSummaryPage
  Scenario: Adding comment to order in Summary page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|80|
    Then Click on Next button
    Then Click on Comment icon in Summary page
    And Enter Comment in summary page
      |Add Comment in Order|
    Then Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @OrderFromCatalog
  Scenario: Creating New order by using Catalog
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select catalog option
    And User should select Product from catalog and Enter Qty for the products
      |50|60|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

  @CustomerNotes
  Scenario: Adding notes to customer account
    Given User must be on Order Entry Page
    And User should click on Notes icon
    Then Add note in popup
      |Testing for Notes at customer level1|
    And User should select the Alert Type and Alert location to display notes
      |Both|Customer master|Order entry|
    Then Click on Save button

  @CopyingCustomerNote
  Scenario: Creating copy of customer note
    Given User must be on Order Entry Page
    And User should click on Notes icon
    And Read all the Notes in Customer note grid and select one note
      |Testing for Notes at customer level1|
    And Click on Copy button in Note grid
    Then Click on Save button

  @DeleteCustomerNote
  Scenario: Delet Customer note
    Given User must be on Order Entry Page
    And User should click on Notes icon
    And Read all the Notes in Customer note grid and select one note for Deleting
      |Testing for Notes at customer level1|
    Then Click on Ok button

  @ResetCustomerNote
    Scenario: Reseting the Customer Note
    Given User must be on Order Entry Page
    And User should click on Notes icon
    And Read all the Notes in Customer note grid and select one note
      |Testing for Notes at customer level1|
    Then Click on Reset button and Click on Ok button




