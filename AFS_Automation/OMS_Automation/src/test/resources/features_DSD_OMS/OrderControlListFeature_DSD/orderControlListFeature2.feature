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
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no for OCL
    Then User should select Note from popup and Order guide from popup for OCL
    Then User validate that he is in NewOE page for OCL
    And User Clicks on Back button in NewOE page and User must be in OCL page
    Then User Clicks on Taken radio button
    And User should verify Order number created in OCL grid and Order icon in OCL


