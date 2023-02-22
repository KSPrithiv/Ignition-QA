Feature: Order Guide
  Used for creation of New OG in different ways, Deleting, Editing etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OG
    When User is on Home Page for OG
    Then User navigate to Client side for OG
    Then User should select Order Entry tab for OG
    Then User selects Account# for OG

  @CancelOG
  Scenario Outline: Test scenario for Canceling order while creating
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>"
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Cancel button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      |  OG |
      |OGDis1|

  @QuickProduct
  Scenario Outline: For creation of OG using single product, sequence number and Customer reference
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>"
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
    |  OG |
    |OGDis1|

  @PrintOG
  Scenario Outline: Test scenario for printing OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    Then User clicks on print button
      Examples:
      |  OG |
      |OGDis1|

  @EditOrderGuide
  Scenario Outline: Edit the existing OG by adding some more products
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    And User enters multiple Quick Product number and Sequence number
      |4|
      |6|
      |8|
      |10|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      | OG |
      |OGDis1|

  @SearchForProduct
   Scenario: Searching for product in new OG page
     Given User must be on Order Entry Page to select OG
     And User should navigate to OG
     Then User enters OG Description in search box
       |OGDis1|
     And  User search for Product# in New OG page

   @DeleteProduct
   Scenario Outline: Deleting product from OG
     Given User must be on Order Entry Page to select OG
     And User should navigate to OG
     Then User enters OG "<OG>" Description in search box
     And User search for Product# in New OG page
     And User click on Delete button to remove product from OG
     Then User click on Save button
     And User should navigate back to OG page and verify OG "<OG>"  existence
     Examples:
       |  OG  |
       |OGDis1|

  @SequenceNo
  Scenario: Clear sequence number and selecting option No from popup
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG Description in search box
      |OGDis1|
    Then User click on More button
    And User selects Clear Sequence from drop down
    And User handles popup for clearing sequence number by selecting No

  @SequenceYes
  Scenario: Clear sequence number and selecting option Yes from popup
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG Description in search box
      |OGDis1|
    Then User click on More button
    And User selects Clear Sequence from drop down
    And User handles popup for clearing sequence number by selecting Yes
    Then User click on Save button

  @SequenceEdit
  Scenario Outline: Edit sequence number of any of the product in product grid
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    And User changes sequence number in product grid of OG
      |24|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
  Examples:
    |  OG  |
    |OGDis1|

  @MultipleProdOG
  Scenario Outline: Creating OG using multiple products, from Quick product and Catalog
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 1 and End date 2 day from current date
    And User enters multiple Product# Quick Product entry and catalog and Sequence number
      |12|Catalog|
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
    |   OG   |
    |OGDis14 |

  @OGFromOG
  Scenario Outline: Creating OG using OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 2 and End date 3 day from current date
    Then User clicks on Add product button and select OG from drop down
      | Order guides |
    And User should select "<OrderGuide>" from popup
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      | OG      | OrderGuide |
      | OGDis16 |SampleOG    |

  @OGFromOrder
  Scenario Outline: Creating OG using Order
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then User enters Description "<OG>" Start date 3 and End date 4 day from current date
    Then User clicks on Add product button and select Order from drop down
      |Orders|
    And User should select Order# from Order popup
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      | OG    |
      |OGDis17|










