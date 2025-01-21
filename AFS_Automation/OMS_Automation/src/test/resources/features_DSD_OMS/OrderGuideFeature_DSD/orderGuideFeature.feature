Feature: Order Guide
  Used for creation of New OG in different ways, Deleting, Editing etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OG
    When User is on Home Page for OG
    Then User navigate to Client side for OG
    Then User should select Order Entry tab for OG
    Then User selects Account# for OG

  @CancelOG
  Scenario Outline: Test scenario for Canceling order guide while creating
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>"
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Cancel button
    And User should navigate back to OG page and verify OG "<OG>"  existence when cancelled
    Examples:
      |  OG  |
      |OGDis1|

  @QuickProduct
  Scenario Outline: For creation of OG using single product, sequence number and Customer reference
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    #Then User enters Description "<OG>" Start date 1 and End date 2 day from current date
    Then Then User enters Description "<OG>"
    #And User selects Day of week from drop down
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
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    Examples:
      | OG |
      |OGDis1|

  @SequenceSortDisplay
  Scenario Outline: Test scenario for verifying the seq numbers are displaying properly or not
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    Then User should click on arrow symbol for sorting sequence numbers
    Examples:
      |  OG  |
      |SampleOG|

  @DragAndDropInCreateOG
  Scenario Outline: Test sceanrio for dragging and droping feature in create order guide page
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG "<OG>" Description in search box
    And User must be on create OG page and "<Drag Drop>" the grid header
    Examples:
      |  OG     | Drag Drop     |
      | OGDis1  | UnitOfMeasure |

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

  @DragAndDropInOGPage
  Scenario Outline: Test scenario to test drag and drop functionality in OG page
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should select header in OG grid for "<Drag Drop>" functionality
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |Drag Drop| OG      |
      | Status  | OGDis1  |











