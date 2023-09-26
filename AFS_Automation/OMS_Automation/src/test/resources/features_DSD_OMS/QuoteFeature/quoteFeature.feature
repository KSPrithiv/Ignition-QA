Feature: Quotes
  Used for cration of Quotes and test different functionality

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Quotes
    When User is on Home Page for Quotes
    Then User navigate to Client side for Quotes
    Then User should select Order Entry tab for Quotes
    Then User selects Account# for Quotes

  @QuickProdQuote
  Scenario Outline: Test scenario for creating Quotes
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
          |40|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
    |QuoteName|
    | Quote123|

  @CancelQuoteInSummarypage
  Scenario Outline: Test scenario for canceling of Quote after creation
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page and click on cancel button
    Examples:
      |QuoteName|
      | Quote123|

  @CancelQuoteCreation
  Scenario Outline:  Test scenario for canceling of Quote while creating
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on Cancel button in New Quote page
    Examples:
      |QuoteName|
      | Quote123|

  @QuoteFromCatalog
   Scenario Outline: Test scenario for creating Quote using catalog
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    And User clicks on Plus symbol in new Quote page and selects Catalog option from drop down
    Then User addes some products from catalog
    |30|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|
      | Quote123|

   @QuoteFromOG
     Scenario Outline: Test scenario for creating quote using OG
     Given User must be on Order Entry Page
     And User clicks on drop down next to Start order button and select Quote option
     Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
     Then User should select Note from popup and Order guide from popup for quote
     And User clicks on Plus symbol in new Quote page and selects OG option from drop down
     Then User enters some Qty to product in Product grid
       |40|40|
     Then Click on create button in New Quote page
     And User click on Back to orderlist button from Quote summary page and Read order number
     Then Verify User is on Order Entry Page and verify Quote is existing
     Examples:
       |QuoteName|
       | Quote123|

    @ConvertQuoteToOrder
    Scenario Outline: Test scenario for converting Quote to Order
      Given User must be on Order Entry Page
      And User clicks on drop down next to Start order button and select Quote option
      Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
      Then User should select Note from popup and Order guide from popup for quote
      Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
        |40|40|
      Then Click on create button in New Quote page
      And User click on Back to orderlist button from Quote summary page and Read order number
      Then Verify User is on Order Entry Page and verify Quote is existing
      Then User selects Quote in Order Entry grid
      And User should be navigated to Quote summary page and click on Convert Order button
      Then Enter PO# for New order
        |PO123|
      Then Enter Pro# in Quick Product Entry area
      And Check for Case and Unit input box enabled or not based on that enter value
        |20|20|
      Then Click on Next button
      And Click on SubmitOrder button
      Then User should be navigated to Order Entry page
      Examples:
        |QuoteName|
        | Quote123|

  @ConvertQuoteToOG
  Scenario Outline: Test scenario for converting Quote to OG
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page and click on Convert OG button
    Then User enters Description "<OG>" Start date 8 and End date 9 day from current date for Quote to OG
    Then User click on Save button to convert Quote as OG
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Then User should navigated to Order Entry page from OG page
    Examples:
      |QuoteName| OG   |
      | Quote123|QToOG|

  @CreateCopyQuote
  Scenario Outline: Test scenario to create copy of Quote
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on create button in New Quote page
    Then User click on Copy button in summary page and enter Quote name "<QuoteName1>" and Click on Create button
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|QuoteName1|
      | Quote123|Quote111  |

  @PrintQuote
  Scenario Outline: Test scenario for printing details of quote
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    And User click on Print button
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|QuoteName1|
      | Quote123|Quote111  |
