Feature: Order Guide2
  Used for creation of New OG in different ways, Deleting, Editing etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OG
    When User is on Home Page for OG
    Then User navigate to Client side for OG
    Then User should select Order Entry tab for OG
    Then User selects Account# for OG

  @OGPush
  Scenario Outline: Test scenario for creating push order guide
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 18 and End date 19 day from current date
    Then Then User enters Description "<OG>" and End date
    Then User selects type of OG from drop down
      | Push |
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG1>" in search box and Delete the OG verify same in OG grid
    Examples:
      |   OG    |   OG1    |
      | Push OG |Push OGPush OG|

  @OGPar
  Scenario Outline: Test scenario for creating Par order guide
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 20 and End date 21 day from current date
    Then Then User enters Description "<OG>" and End date
    Then User selects type of OG from drop down
      | Par Orders |
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG1>" in search box and Delete the OG verify same in OG grid
    Examples:
      |   OG    |   OG1       |
      | Par OG  | Par OGPar OG|

  @MarketSegment
  Scenario Outline: Test scenario for OG creation using Market segment
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |Market segment|
    And Check for popup to appear to select sub customer reference for market segment
    Then User clicks on Create new button and should navigate to New OG page
    And User validates Customer reference input box to verify the OG created
      |Market segment|
    Then Then User enters Description "<OG>" and End date
    And User should make sure that customer reference "<OGType>" is same as of selected in OG page
    Then User clicks on Add product button and select Catalog from drop down for Market segment OG
      |Catalog|
    And User should select products from catalog popup for Market segment
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    #And User should navigate back to OG page and navigate back to "<OGType>" and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG     |  OGType         |
      |MarketOG | Market segment  |

  @AllOG
  Scenario Outline:Test scenario for creating OG for all customers
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 22 and End date 23 day from current date
    Then Then User enters Description "<OG>" and clicks on All order check box
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG1>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG    |    OG1         |
      |AllOrder|AllOrderAllOrder|

  @PushOGWithoutValidToDate
  Scenario Outline: Test scenario for creating push order guide without any valid to date
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 7 and No selection of end date
    Then Then User enters Description "<OG>" and End date
    Then User selects type of OG from drop down
      | Push |
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG1>" in search box and Delete the OG verify same in OG grid
    Examples:
      |   OG     |     OG1     |
      | Push OG1 | Push OG1Push OG1|

  @ReferencePriceGroup
  Scenario Outline: Test scenario for creating customer Reference Price group base Scheduled
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |Price group - base schedule|
    And Check for popup to appear to select sub customer reference for Price group base schedule
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>" and End date
    And User should make sure that customer reference "<OGType>" is same as of selected in OG page
    Then User clicks on Add product button and select Catalog from drop down for price Base OG
      |Catalog|
    And User should select products from catalog popup for Price base
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG        |  OGType                      |
      |PriceBaseOG | Price group - base schedule  |

  @OGNationalChain
  Scenario Outline: For creating OG using National chain
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |National chain|
    And Check for popup to appear to select sub customer reference for National chain
    Then User clicks on Create new button and should navigate to New OG page
    And User validates Customer reference input box to verify the OG created
      |National chain|
    Then Then User enters Description "<OG>" and End date
    And User should make sure that customer reference "<OGType>" is same as of selected in OG page
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup for National chain
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
   # And User should navigate back to OG page and navigate back to "<OGType>" and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG           |   OGType        |
      | NationalChain1|  National chain |

  @AllCustomerAccount#
  Scenario Outline: For creating OG using All Customer Account# from customer reference drop down
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |All customer accounts #|
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 24 and End date 25 day from current date and validate all customer check box
    And User should make sure that customer reference "<OGType>" is same as of selected in OG page
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    #And User should navigate back to OG page and navigate back to "<OGType>" and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG           |   OGType                 |
      | AllCustomer1  |  All customer accounts # |

  @DragAndDropInOGPage
  Scenario Outline: Test scenario to test drag and drop functionality in OG page
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should select header in OG grid for "<Drag Drop>" functionality
    Examples:
      |Drag Drop|
      | Status  |

  @FilterInOGGrid
  Scenario Outline: Test scenario to test filter in OG grid functionality
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |All customer accounts #|
    And Clear filter to display both active and inactive OG
    Then User should use filter input box in the OG grid "<Type>" "<Status>"
    Examples:
    | Type  | Status |
    |Regular|Inactive|

  @SortingUsingArrow
  Scenario: Test scenario to test Sorting using arrow symbol
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |All customer accounts #|
    And Clear filter to display both active and inactive OG
    Then User should use arrow symbol to sort the value in the grid



