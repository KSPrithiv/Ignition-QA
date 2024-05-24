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
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter multiple Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |1|1|
      |2|1|
      |1|1|
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
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |1|1|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page and click on Edit button
    Then User should navigate to new Quotes page add product# in Quick product entry
      |2|1|
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
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page and click on Edit button
    Then User should navigate to new Quotes page Click on Add product and select OG "<OG>"
      |20|15|
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|    OG   |
      | Quote123| SampleOG|

  @CancelWhileEditing
  Scenario Outline: test scenario for cancelling quote at the time of edit quote
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
    And User should be navigated to Quote summary page and click on Edit button
    Then User should navigate to new Quotes page add product# in Quick product entry
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
    Then User should select Note from popup and Order guide from popup for quote
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
    Then User should select Note from popup and Order guide from popup for quote
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

  @SkipQuoteFromOE
  Scenario: Test scenario to verify skip in Quote
    Given User must be on Order Entry Page
    Then Change the date 4 days after current date
    And User verifies skip button in OE page when Quotes is already created
    Then User should reset the delivery date to current date

  @SkipQuoteInNewOE
  Scenario: Test scenario to verify skip in New OE page, when Quote is already existing
    Given User must be on Order Entry Page
    Then Change the date 4 days after current date
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup for quote
    And User verifies Skip button in New OE page
    Then User should navigate to OE page, User should select the current date as delivery date

  @BogoItemsInQuote
  Scenario Outline: Test scenario for adding bogo item to quote and verify the behaviour
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter BOGO Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |40|40|
    And User verifies the products added to Quote
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Examples:
      |QuoteName|
      | Quote123|

  @BogoItemsInQuoteToOrder
  Scenario Outline: Test scenario for adding BOGO item to quote and create Order for that Quote
    Given User must be on Order Entry Page
    And User clicks on drop down next to Start order button and select Quote option
    Then User enters Quote name "<QuoteName>" and Quote End date click on OK button
    Then User should select Note from popup and Order guide from popup for quote
    Then Enter BOGO Pro# in Quick Product Entry area in New Qutoe page and enter Qty for Case and Unit
      |2|1|
    And User verifies the products added to Quote
    Then Click on create button in New Quote page
    And User click on Back to orderlist button from Quote summary page and Read order number
    Then Verify User is on Order Entry Page and verify Quote is existing
    Then User selects Quote in Order Entry grid
    And User should be navigated to Quote summary page and click on Convert Order button
    Then Enter PO# for New order for Quote to Order
      |PO123|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Examples:
      |QuoteName|
      | Quote123|