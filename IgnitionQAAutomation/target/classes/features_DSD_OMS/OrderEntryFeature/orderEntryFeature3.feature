Feature: Order Entry3
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#


    # Admin setting for hiding zero's=>'Hide leading zeros', Scenario only for DSD
  @HideZeros
  Scenario: HideZeros that appears in Account# or product#
    Given User must be on Order Entry Page
    And User should verify the account_No
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup
    Then User should find select Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |10|20|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

    @AddDeliveryAddress
    Scenario: For Adding new Delivery address
      Given User must be on Order Entry Page
      And User should verify the account_No
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup
      Then User should find select Order guide from popup
      Then Enter PO# for New order
        |PO123|
      Then Enter Pro# in Quick Product Entry area
      And Check for Case and Unit input box enabled or not based on that enter value
        |10|20|
      Then Click on Next button and Add new Delivery Addresss
      |Abcd|Address_line2|City_name|CA|Australia|123456|
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page

  @EditDeliveryAddress
  Scenario: For Editing existing Delivery address
    Given User must be on Order Entry Page
    And User should verify the account_No
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup
    Then User should find select Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |10|20|
    Then Click on Next button and Edit Delivery Addresss
      |Address_line2|Address_line12|
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page

    @QtyInAscending
    Scenario: Compare Total number of lines with number of products in summary page
      Given User must be on Order Entry Page
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup
      Then User should find select Order guide from popup
      Then Enter PO# for New order
        |PO123|
      Then Enter Prod_No in Quick Product Entry area
        |  15  |  15  |
        |  25  |  10  |
        |  20  | 25   |
        |  10  | 20   |
        |  20  | 20   |
      And Click on Aroow symbol to display products based on descending order of units
      Then Click on Next button
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page

      @ChangingRoute
      Scenario: Creating New order by entering Product# in Searchbar, New order entry page
        Given User must be on Order Entry Page
        And Select 1st route from Route popup
        Then User must click Start Order button
        Then User should make selection between Pending order or Start New order
        Then User should select Note from popup
        Then User should find select Order guide from popup
        Then Enter PO# for New order
          |PO123|
        And Read 2nd route value and select 2nd route with that validate route has changed or not
        Then Enter Pro# in Quick Product Entry area
        And Check for Case and Unit input box enabled or not based on that enter value
          |50|20|
        And Find total amount from New oe page
        Then Click on Next button
        And Click on SubmitOrder button
        Then User should be navigated to Order Entry page

    @AddingNewPayment
    Scenario: Adding New payment details to the customer
      Given User must be on Order Entry Page
      And Select 1st route from Route popup
      Then User must click Start Order button
      Then User should make selection between Pending order or Start New order
      Then User should select Note from popup
      Then User should find select Order guide from popup
      Then Enter PO# for New order
        |PO123|
      Then Enter Pro# in Quick Product Entry area
      And Check for Case and Unit input box enabled or not based on that enter value
        |50|20|
      Then Click on Next button and add new Payment method
      |Bank account|Divya|AR|Savings - Personal|123|2345723498|
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page

  @DeletePayment
  Scenario: Deleting payment details of customer
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup
    Then User should find select Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |50|20|
    Then Click on Next button and Delete Payment method
      |Divya AR|
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page




