Feature: Order Guide1
  Used for creation of New OG in different ways, Deleting, Editing etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OG
    When User is on Home Page for OG
    Then User navigate to Client side for OG
    Then User should select Order Entry tab for OG
    Then User selects Account# for OG

  @MultipleProdOG
  Scenario Outline: Creating OG using multiple products, from Quick product and Catalog
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 2 and End date 3 day from current date
    And User enters multiple Product# Quick Product entry and catalog and Sequence number
      |12|Catalog|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |   OG   |
      |OGDis14 |

  @OGFromOG
  Scenario Outline: Creating OG using OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 4 and End date 5 day from current date
    Then User clicks on Add product button and select OG from drop down
      | Order guides |
    And User should select "<OrderGuide>" from popup
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      | OG      | OrderGuide |
      | OGDis16 |SampleOG    |

  @OGFromOrder
  Scenario Outline: Creating OG using Order
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 6 and End date 7 day from current date
    Then User clicks on Add product button and select Order from drop down
      |Orders|
    And User should select Order# from Order popup
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      | OG    |
      |OGDis17|

  @OGFromCatalog
  Scenario Outline: Creating OG using Catalog
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 8 and End date 9 day from current date
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

  @MultipleProdCatalog
  Scenario Outline: Creating OG using Catalog, by adding multiple product to OG, through search box
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 14 and End date 15 day from current date
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
    Then User enters Description "<OG>" Start date 10 and End date 11 day from current date
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
    Then User enters Description "<OG>" Start date 12 and End date 13 day from current date
    And User selects Day of week from drop down
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page, verify OG "<OG>" existence and verify that Week of day is selected
    Then User deletes "<OG>" created for day of week
    Examples:
      | OG      |
      |DayOfWeek|

  @ChangeCustomerAllocationLocalChain
  Scenario Outline: Test scenario for deleting customer allocation to Local chain
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>"
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup
    Then User click on Save button
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    And User should navigate to CustomerAllocation tab
    Then Select CustomerAllocation check box and click on Delete button
    Then User Clicks on Plus button and select "<option>" from drop down and select "<Reference1>" or "<Reference2>"
    Then User should navigate back to Product tab in OG
    And User validates that previously added products are removed from product grid
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG              |   option      |  Reference1  |  Reference2              |
      | ChangeNational   | Local chain   |     85C      |  WENDYS #0212 COLLEGE DR |

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
    Then User clicks on Create new button and should navigate to New OG page
    #Then User enters Description "<OG>" Start date 1 and End date 2 day from current date
    Then Then User enters Description "<OG>"
    And User selects Day of week from drop down
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    Then User enters OG "<OG>" Description in search box
    And User should navigate to CustomerAllocation tab
    Then Select CustomerAllocation check box and click on Delete button
    Then User Clicks on Plus button and select value from drop down
      |Customers|
    And User verify popup appears and enter account# in search box
    Then Select customer account# and verify that account# is added
    Then User should navigate back to Product tab in OG
    And User validates that previously added products are removed from product grid
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should select products from catalog popup
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG               |
      |OGProdVerification |

  @OGLocalChain
  Scenario Outline: For creating OG using local chain
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |Local chain|
    And Check for popup to appear to select sub customer reference for local chain
      |WENDYS #0212 COLLEGE DR|ALKI BAKERY|
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


