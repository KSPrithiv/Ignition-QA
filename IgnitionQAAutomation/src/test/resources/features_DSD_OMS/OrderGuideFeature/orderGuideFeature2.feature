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

  @MarketSegment
  Scenario Outline: Test scenario for OG creation using Market segment
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |Market segment|
    And Check for popup to appear to select sub customer reference
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>" and End date
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and navigate back to local chain "<OGType>" and verify OG "<OG>"  existence
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
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and navigate back to local chain "<OGType>" and verify OG "<OG>"  existence
    Examples:
      |  OG        |  OGType                      |
      |PriceBaseOG | Price group - base schedule  |

  @OGNationalChain
  Scenario Outline: For creating OG using local chain
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |National chain|
    And Check for popup to appear to select National Chain "<Chain>"
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>" and End date
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and navigate back to local chain "<OGType>" and verify OG "<OG>"  existence
    Examples:
      |  OG           |   OGType        |  Chain             |
      | NationalChain1|  National chain | ASSISTED LIVING LG |

  @OGDelete
  Scenario Outline: Deleting Order guide and verifying it in OG grid
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG   |
      |OGDis1 |
      |OGDis14|
      |OGDis16|
      |OGDis17|
      |OGDis18|
      |OGDis19|
      |DayOfWeek|
      |OGDis20|
      |OGHist |
