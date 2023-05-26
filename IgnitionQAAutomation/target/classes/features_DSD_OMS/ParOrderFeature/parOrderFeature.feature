Feature: Par Order
  Used for creation of New Par Order, Delete par,

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Par
    When User is on Home Page for Par
    Then User navigate to Client side for Par
    Then User should select Order Entry tab for Par
    Then User selects Account# for Par

  @CreateParOrder
  Scenario Outline: Creating new par order
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Click on New Par list button
    And User enters code and discription for Par list
    | ParDes1 |
    Then User clicks on save Par list
    Examples:
    | OG     |
    |SamplePar|

  @CreateMultiplePar
  Scenario Outline: Creating new par order
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Click on New Par list button
    And User enters code and discription to create multiple Par list and save all par lists
      | ParDes2 |
      | ParDes3 |
    Examples:
      | OG      |
      |SamplePar|

  @SearchForProduct
  Scenario Outline: Test scenario to search for product in Par list
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist "<ParList>" from drop down
    And User enters product# in search box and validates same product details displayed in Product grid
    Examples:
    |    OG    |   ParList |
    | SamplePar |  ParDes1 |

  @SearchForParOrder
  Scenario Outline: Test scenario to search for parlist and display details
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist "<ParList>" from drop down
    And Display all product# in par list
    Examples:
    |    OG    |  ParList |
    |SamplePar  | ParDes1 |

  @EditParList
  Scenario Outline: Test scenario to Edit Parlist from OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist "<ParList>" from drop down and count Products
    And User navigate to Product tab and adds New product and sequence no
      |20|
    Then User click on Save button
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist "<ParList>" from drop down and count Products after edit
    Examples:
      |  OG      |  ParList   |
      | SamplePar | ParDes1   |

  @DeleteParList
  Scenario Outline: Test scenario to Delete Parlist from OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist from drop down and user clicks on Delete Par
      |ParDes1|
      |ParDes2|
      |ParDes3|
    Examples:
    |  OG       |
    | SamplePar |



