Feature: Order Guide1
  Used for creation of New OG in different ways, Deleting, Editing etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OG
    When User is on Home Page for OG
    Then User navigate to Client side for OG
    Then User should select Order Entry tab for OG
    Then User selects Account# for OG

  @OGFromCatalog
  Scenario Outline: Creating OG using Catalog
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 10 and End date 11 day from current date
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
    |  OG   |
    |OGDis18|

  @OGExport
  Scenario Outline: Export OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    And User verifies New OG page and clicks on export button
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      |  OG     |
      |SampleOG |

  @OGImport
  Scenario Outline: Importing OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 12 and End date 13 day from current date
    And User verifies New OG page and clicks on import button
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG   |
      |OGDis19|

  @OGDayOfWeek
  Scenario Outline: Test scenario for changing Day of week and create OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 14 and End date 15 day from current date
    And User selects Day of week from drop down
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page, verify OG "<OG>"  existence and verify that Week of day is selected
    Examples:
      | OG      |
      |DayOfWeek|

  @MultipleProdCatalog
  Scenario Outline: Creating OG using Catalog, by adding multiple product to OG, through search box
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 16 and End date 17 day from current date
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup to add multiple products
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG   |
      |OGDis20|

  @OGHistorical
  Scenario Outline: Test scenario for creating Historical order guide
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>" and End date
    Then User selects type of OG from drop down to select historical OG
      | Historical|
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG |
      |OGHist|

  @ChangeCustomerAllocationLocalChain
  Scenario Outline: Test scenario for deleting customer allocation to National chain
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    And User should navigate to CustomerAllocation tab
    Then Select CustomerAllocation check box and click on Delete button
    Then User Clicks on Plus button and select "<option>" from drop down
    Then User should navigate back to Product tab in OG
    And User validates that previously added products are removed from product grid
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG         |   option      |
      | DayOfWeek   | National chain|

  @ChangeAccountAndCreateOG
  Scenario Outline: Test scenario for changing Customer Account# and create OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User Clicks on Customer Account_No button and select other Customer Account_No
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>"
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    And User changes the Customer Account# to the previous Account#
    Examples:
      |     OG    |
      |   OGDis21  |

  @DeleteCustomerAllocation
  Scenario Outline: Test scenario for deleting Customer allowcation
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    And User should navigate to CustomerAllocation tab
    Then Select CustomerAllocation check box and click on Delete button
    Then User Clicks on Plus button and select value from drop down
      |Customers|
    And User verify popup appears and enter account# in search box
    Then Select customer account# and verify that account# is added
    Then User should navigate back to Product tab in OG
    And User validates that previously added products are removed from product grid
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG    |
      |OGDis14 |

  @ActiveToExpired
  Scenario Outline: Test scenario to convert active OG to expired OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    And User selects end date as past date
    Then User should navigate back to OG page and verify OG "<OG>" by selecting status as expired
   # And Clear filter to display both active and inactive OG
   # Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG        |
      | OGDis1     |

  @OGLocalChain
  Scenario Outline: For creating OG using local chain
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |Local chain|
    And Check for popup to appear to select sub customer reference for local chain
    Then User clicks on Create new button and should navigate to New OG page
    And User validates Customer reference input box to verify the OG created
    |Local chain|
    Then Then User enters Description "<OG>" and End date
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup for Local chain
    Then User click on Save button
    #And User should navigate back to OG page and navigate back to "<OGType>" and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG       |
      |LocalChain1|

  @OGAddFilter
  Scenario: Will help to search Order guide using Add filter button
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User click on AddFilter button and handle different popup
      |Type|Regular|

  #@VerifyOGExistence
  #Scenario Outline: For creating OG by changing Customer Account#
  #  Given User must be on Order Entry Page to select OG
  #  And User should navigate to OG
  #  Then User clicks on Create new button and should navigate to New OG page
  #  Then Then User enters Description "<OG>" and End date
  #  And User enters Quick Product number and Sequence number
  #    |4|
  #  Then User click on Save button
    #And User should navigate back to OG page change account# and verify OG "<OG>"  existence
  #  And Clear filter to display both active and inactive OG
  #  Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
  #  Examples:
  #    |  OG      |
  #    |CustChange|

