Feature: Inventory
  Used for performing different operations on inventory tab

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Inventory
    When User is on Home Page for Inventory
    Then User navigate to Client side for Inventory
    Then User should select Order Entry tab for Inventory
    Then User selects Account# for Inventory

  @AddingProductsToInventory
  Scenario: Test scenario for adding products to inventory
    Given User must be on Order Entry Page to select Inventory tab
    And User should navigate to Inventory tab
    Then User should be in Store inventory tab, in inventory page
    Then User should change store inventory dropdown value
    And User should click on Add product button and select products from Product popup and save
      |1 |1|
      |2 |1|
      |1 |2|

  @RunningTotal
  Scenario: Test scenario for finding running total unit in inventory
    Given User must be on Order Entry Page to select Inventory tab
    And User should navigate to Inventory tab
    Then User should be in Store inventory tab, in inventory page
    Then User should change store inventory dropdown value
    And User should compare total units with Running total units
      |Total Units|

  @DragAndDrop
  Scenario: Test scenario for Drag and drop operation in Inventory
    Given User must be on Order Entry Page to select Inventory tab
    And User should navigate to Inventory tab
    Then User should Drag and drop any of the table header for grouping
      |Total Units|

  @QuickEntryInventroy
  Scenario Outline: Test scneario for adding product from quick entry
    Given User must be on Order Entry Page to select Inventory tab
    And User should navigate to Inventory tab
    Then User should be in Store inventory tab, in inventory page
    Then User should change store inventory dropdown value
    And User enters product#, "<Case>", "<Unit>", "<Sequence>" in quick product entry
    Examples:
      |Case|Unit|Sequence|
      | 2  |  1 |  2     |

  @CancelInventroyDetails
  Scenario: Test scenario to cancel Inventory details
    Given User must be on Order Entry Page to select Inventory tab
    And User should navigate to Inventory tab
    Then User should be in Store inventory tab, in inventory page
    Then User should change store inventory dropdown value
    Then User goes through products under inventory as the product added using quick entry has not been saved
    And User cancel inventory details

