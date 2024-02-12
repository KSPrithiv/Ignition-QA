Feature: Order control list
  Used for cration of order for OCL, searching etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OCL
    When User is on Home Page for OCL
    Then User navigate to Client side for OCL
    Then User should select Order Entry tab for OCL
    #Then User selects Account# for OCL

  @CreateOrderWithNote
  Scenario: For creating order in OCL and Order has been created with order note
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Untaken radio button and user clicks on Refresh button
    Then User clicks on Order icon in OCL grid
    Then User should select Note from popup and Order guide from popup for OG
    And User validate that he is in NewOE page
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |100|100|
    Then User should click on Comment icon in Order entry card
    And User should enter comment in comment popup
      |Comment at Order level for OCL|Order notes|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no for OCL
    #Then User should select Note from popup and Order guide from popup for OG
    Then User should select Note from popup and Order guide from popup
    Then User validate that he is in NewOE page
    And User Clicks on Back button in NewOE page and User must be in OCL page

  @OrderCommentInOCL
  Scenario: Test scenario to find the comment added to Order in OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Taken radio button
    And User enters OrderNo in search box to search for order
    Then User finds the comment for order in OCL

  #Admin setting need to be disabled
  @OrderIcon
  Scenario: Test scenario for verifying Order icon in OCL once order is created via OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Untaken radio button and user clicks on Refresh button
    Then User clicks on Order icon in OCL grid
    Then User should select Note from popup and Order guide from popup
    And User validate that he is in NewOE page
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |100|100|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no for OCL
    Then User should select Note from popup and Order guide from popup
    Then User validate that he is in NewOE page
    And User Clicks on Back button in NewOE page and User must be in OCL page
    Then User Clicks on Taken radio button
    And User should verify Order number created in OCL grid and Order icon in OCL

  @VerifyOrderType
  Scenario: Test scenario for verifying Order Type in OCL once order is created via OCL. Here Regular order has been created,and same has been passed as parameter
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Untaken radio button and user clicks on Refresh button
    Then User clicks on Order icon in OCL grid
    Then User should select Note from popup and Order guide from popup
    And User validate that he is in NewOE page
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |100|100|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no for OCL
    Then User should select Note from popup and Order guide from popup
    Then User validate that he is in NewOE page
    And User Clicks on Back button in NewOE page and User must be in OCL page
    Then User Clicks on Taken radio button
    And User should verify Order number created in OCL grid and Order type in OCL

  @AddFilterInOCL
  Scenario: Filtering of OCL details using customer account# using AddFilter
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User clicks on Add filter button and enter value for first search box and second search box
      |Customer key|

  @SkipInOCL
  Scenario: For skipping order from OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Untaken radio button
    Then User select OCL which is not skipped
    And User Clicks on Skip button and validates the skip popup selects the reason
      |closed|
    Then User validates skip option

  @VerifySkipInTaken
  Scenario: Test scenario for verifying skip under taken orders
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Taken radio button
    And User verifies existence of customer account for which skip is enabled, exists under taken

  @RemoveSkip
  Scenario: For remove skipping order from OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Taken radio button
    And User verifies existence of customer account for which skip is enabled, exists under taken
    Then User select OCL which is skipped
    And User handles Remove skip popup
    Then User validates Not skip option

  @DragAndDrop
  Scenario:Test scenario to Drag and drop OCL header
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    And User clicks on All radio button
    Then User should drag and drop grid header
      |Customer|

  @CreatePendingOrder
  Scenario: Test scenario for creating pending order via OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Untaken radio button
    Then User clicks on Order icon in OCL grid
    Then User should select Note from popup and Order guide from popup
    And User validate that he is in NewOE page
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|20|
    Then Click on Back button to handle Pending order Popup
    And Popup message for Pending order should be displayed
    Then User should be navigated to Order control list page

  @PrintOCL
  Scenario: Test scenario for printing OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User clicks on Print button and handle the new browser window


