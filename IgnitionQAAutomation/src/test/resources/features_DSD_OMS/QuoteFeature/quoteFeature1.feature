Feature: Quotes1
  Used for cration of Quotes and test different functionality

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Quotes
    When User is on Home Page for Quotes
    Then User navigate to Client side for Quotes
    Then User should select Order Entry tab for Quotes
    Then User selects Account# for Quotes

  @DeleteProductQuote
  Scenario Outline: Test scenario to create Quote with multiple products and delete one of the product from quote
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should find select Order guide from popup
    Then User should select Note from popup
    Then Enter multiple Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
      |20|10|
      |40|50|
      |15|20|
      |30|20|
    And User selects one product from product grid and click on delete button
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|
      | Quote123|

  @EditQuote
  Scenario Outline: Test scenario to edit Quote by adding Product from Quick product entry
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should find select Order guide from popup
    Then User should select Note from popup
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page and click on Edit button
    Then If user navigates to payment and address page click on Back button or else add product# in Quick product entry
      |20|15|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|
      | Quote123|

  @EditQuoteOG
  Scenario Outline: Test scenario for editing quote by adding OG to quote
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should find select Order guide from popup
    Then User should select Note from popup
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page and click on Edit button
    Then If user navigates to payment and address page click on Back button or else Click on Add product and select OG
      |20|15|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|
      | Quote123|

  @CancelWhileEditing
  Scenario Outline: test scenario for cancelling quote at the time of edit quote
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should find select Order guide from popup
    Then User should select Note from popup
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page and click on Edit button
    Then If user navigates to payment and address page click on Back button or else add product# in Quick product entry
      |20|15|
    Then Click on Cancel button in New Quote page
    Examples:
      |QuoteName|
      | Quote123|

  @CommentInQuote
  Scenario Outline: Test scenario for adding comment to quote
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should find select Order guide from popup
    Then User should select Note from popup
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    And User click on Comment Icon in Quote page and select Internal comment flag
      |Adding Comment in Quote|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|
      | Quote123|

  @NavigateQuoteSummay
  Scenario Outline: Test scenario for navigating from OE page to Quote summary page
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should find select Order guide from popup
    Then User should select Note from popup
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page
    Examples:
      |QuoteName|
      | Quote123|

  @DeleteCancel
  Scenario Outline: Test scenario for deleting or canceling Quote
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should find select Order guide from popup
    Then User should select Note from popup
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