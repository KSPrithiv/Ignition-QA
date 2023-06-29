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
    Given User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Click on New Par list button
    And User enters code and discription for Par list
    | ParDes1 |
    Then User clicks on save Par list
    Examples:
    | OG     |
    |SampleOG|

  @CreateMultiplePar
  Scenario Outline: Creating new par order
    Given User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Click on New Par list button
    And User enters code and discription to create multiple Par list and save all par lists
      | ParDes2 |
      | ParDes3 |
    Examples:
      | OG      |
      |SampleOG|

  @SearchForProduct
  Scenario Outline: Test scenario to search for product in Par list
    Given User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist "<ParList>" from drop down
    And User enters product# in search box and validates same product details displayed in Product grid
    Examples:
    |    OG    |  ParList |
    | SampleOG |  ParDes2 |

  @SearchForParOrder
  Scenario Outline: Test scenario to search for parlist and display details
    Given User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist "<ParList>" from drop down
    And Display all product# in par list
    Examples:
    |    OG    |  ParList |
    |SampleOG  | ParDes2 |

  @ParProdQty
  Scenario Outline: Test scenario for editing par list by entering Qty for Par product
    Given User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist "<ParList>" from drop down
    And Display all product# in par list
    And User should enter valid value for Qty for the first product in product grid
    |50|
    |10|
    |5 |
    |20|
    Then User clicks on save Par list
    Examples:
      | OG        | ParList  |
      | SampleOG  | ParDes2  |

  @FilteringByParQty
  Scenario Outline: Test scenario to filter products based on Par product Qty
    Given User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist "<ParList>" from drop down and count Products
    And then user clicks on Addfilter button in Parlist card and enters the range for product part qty
    |5|20|
    Examples:
      |  OG      |  ParList   |
      | SampleOG | ParDes2    |

  @DeleteParList
  Scenario Outline: Test scenario to Delete Parlist from OG
    Given User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Selects parlist from drop down and user clicks on Delete Par
      |ParDes1|
      |ParDes2|
      |ParDes3|
    Examples:
    |  OG      |
    | SampleOG |



