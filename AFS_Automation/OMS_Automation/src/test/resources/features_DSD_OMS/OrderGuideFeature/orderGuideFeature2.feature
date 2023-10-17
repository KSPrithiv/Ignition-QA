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
    Then User enters Description "<OG>" Start date 8 and End date 9 day from current date
    Then Then User enters Description "<OG>" and End date
    Then User selects type of OG from drop down
      | Push |
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      |   OG    |
      | Push OG |

  @OGPar
  Scenario Outline: Test scenario for creating Par order guide
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 15 and End date 16 day from current date
    Then Then User enters Description "<OG>" and End date
    Then User selects type of OG from drop down
      | Par Orders |
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      |   OG    |
      | Par OG |

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
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup
    Then User click on Save button
    #And User should navigate back to OG page and navigate back to "<OGType>" and verify OG "<OG>"  existence
    Examples:
      |  OG     |  OGType         |
      |MarketOG | Market segment  |

  @AllOG
  Scenario Outline:Test scenario for creating OG fo all customers
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 10 and End date 11 day from current date
    Then Then User enters Description "<OG>" and clicks on All order check box
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      |  OG |
      |AllOrder|

  @PushOGWithoutValidToDate
  Scenario Outline: Test scenario for creating push order guide without any valid to date
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 12 and No selection of end date
    Then Then User enters Description "<OG>" and End date
    Then User selects type of OG from drop down
      | Push |
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      |   OG    |
      | Push OG1 |

  @ReferencePriceGroup
  Scenario Outline: Test scenario for creating customer Reference Price group base Scheduled
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |Price group - base schedule|
    And Check for popup to appear to select sub customer reference
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>" and End date
    And User should make sure that customer reference "<OGType>" is same as of selected in OG page
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup
    Then User click on Save button
    #And User should navigate back to OG page and navigate back to "<OGType>" and verify OG "<OG>"  existence
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
    And User should select products from catalog popup
    Then User click on Save button
   # And User should navigate back to OG page and navigate back to "<OGType>" and verify OG "<OG>"  existence
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
    Then User enters Description "<OG>" Start date 13 and End date 14 day from current date and validate all customer check box
    And User should make sure that customer reference "<OGType>" is same as of selected in OG page
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup
    Then User click on Save button
    #And User should navigate back to OG page and navigate back to "<OGType>" and verify OG "<OG>"  existence
    Examples:
      |  OG           |   OGType                 |
      | AllCustomer1  |  All customer accounts # |

  @OGDeleteCancel
  Scenario Outline: Test scenario for cancel deleteing of OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG Description "<OG>" in search box and Delete cancel the OG verify same in OG grid
    Examples:
      |  OG   |
      |OGDis16 |

  @DragAndDropInOGPage
  Scenario Outline: Test scenario to test drag and drop functionality in OG page
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should select header in OG grid for "<Drag Drop>" functionality
    Examples:
      |Drag Drop|
      | Status  |

  @OGDelete
  Scenario Outline: Deleting Order guide and verifying it in OG grid
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |All customer accounts #|
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG   |
      |OGDis14|
      |OGDis16|
      |OGDis17|
      |OGDis18|
      |OGDis19|
      |OGDis20|
      |OGHistory|
      |Par OGPar OG|
      |Push OGPush OG|
      |Push OG1Push OG1|
      |AllOrderAllOrder|
      | AllCustomer1   |
      | DayOfWeek      |
      | LocalChain1    |
      | NationalChain1 |
    #  | QToOG |

