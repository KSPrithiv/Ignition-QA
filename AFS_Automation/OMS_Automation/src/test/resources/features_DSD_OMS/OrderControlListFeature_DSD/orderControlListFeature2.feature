Feature: Order control list
  Used for cration of order for OCL, searching etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OCL
    When User is on Home Page for OCL
    Then User navigate to Client side for OCL
    Then User should select Order Entry tab for OCL

  @VerifyingCustomerNote
  Scenario: Test scenario for verifying customer note in OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User should search for valid customers in OCL
      |Milos|
    Then User Clicks on Untaken radio button and user clicks on Refresh button
    Then User should add customer note using Order control List
    Then User clicks on Order icon in OCL grid
    Then User should verify Note content from popup and select Order guide from popup
    And User validate that he is in NewOE page
    Then Enter PO# for New order
      |PO123|
    Then Click on Add product drop down and select catalog option
    And User should select Product from catalog and Enter Qty for the products for OCL
      |1|1|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no for OCL
    Then User should select Note from popup and Order guide from popup for OCL
    Then User validate that he is in NewOE page for OCL
    And User Clicks on Back button in NewOE page and User must be in OCL page
    Then User Clicks on Taken radio button
    And User should verify Order number created in OCL grid and Order icon in OCL

  @LastDeliveryDateColumn
  Scenario: Test case to verify existance of cal delivery date column and dates in that column
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Untaken radio button and user clicks on Refresh button
    Then User should search for valid customers in OCL
      |Milos|
    And User verify last delivery date column

  @OrderFromOrderHistory
  Scenario: Test scenario for creating order using order history in OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User should search for valid customers in OCL
      |Milos|
    Then User Clicks on Untaken radio button and user clicks on Refresh button
    Then User should add customer note using Order control List
    Then User clicks on Order icon in OCL grid
    Then User should verify Note content from popup and select Order guide from popup
    And User validate that he is in NewOE page
    Then Enter PO# for New order
      |PO123|
    Then User should click on Copy from dropdown and Select Order history
      |Order history|
    Then User verifies Order history page and add history Order to order
    And Click on Copy button
    Then User should select Note from popup and Order guide from popup
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no for OCL
    Then User should select Note from popup and Order guide from popup for OCL
    Then User validate that he is in NewOE page for OCL
    And User Clicks on Back button in NewOE page and User must be in OCL page
    Then User Clicks on Taken radio button
    And User should verify Order number created in OCL grid and Order icon in OCL

#  @TakenRadioButton
#  Scenario: Test scenario for verifying taken radio button and to verify taken orders
#    Given User must be on Order Entry Page to select OCL
#    And User should navigate to OCL
#    Then User should select Order taker from drop down
#    And Change the delivery date 2 days after current date
#    Then User Clicks on Untaken radio button
#    Then User should search for valid customers in OCL
#      |Milos|
#    And User verifies already taken order numbers

  @CallBackChangeTime
  Scenario: Test scenario for changing call back time and validate in OCL grid
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User Clicks on Untaken radio button
    Then User should search for valid customers in OCL
      |Milos|
    Then User changes call back time