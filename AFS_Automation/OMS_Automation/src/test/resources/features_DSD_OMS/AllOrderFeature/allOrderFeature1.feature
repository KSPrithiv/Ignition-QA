Feature: All orders
  Test scenarios to create all orders, edit,delete etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for All order
    When User is on Home Page for All order
    Then User navigate to Client side for All order
    Then User should select Order Entry tab for All order

  @GroupLevelCalculation
  Scenario Outline: Test scenario for finding sum of the column for Qty and total
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    Then User clicks on dropdown in All order for group level calculation for Qty,Total and select "<Options>"
    And User validates the Sum amount in Qty and Total
    Examples:
      | Options |
      | Sum     |

  @GroupLevelAvgCalculation
    Scenario Outline: Test scenario for finding Avg of the column for Qty and total
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    Then User clicks on dropdown in All order for group level calculation for Qty,Total and select "<Options>"
    And User validates the Avg amount in Qty and Total
    Examples:
      | Options |
      | Avg     |

  @DragAndDropInAllOrder
  Scenario Outline: Test scenario for drag and drop of header
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    And User drag and drops "<Drag and Drop>" header
    Examples:
    | Drag and Drop |
    | Order Type    |

  @DragAndDropAndSum
  Scenario Outline: Test scenario for drag and drop, and find sum of total and Qty columns
    Given User must be on Order Entry Page to select All Orders
    And User should navigate to All Orders
    Then User clicks on Show all orders check box after Clicking All orders tab
    Then User clicks on dropdown in All order for group level calculation for Qty,Total and select "<Options>"
    And User validates the Sum amount in Qty and Total
    And User drag and drops "<Drag and Drop>" header
    Examples:
      | Drag and Drop | Options |
      | Order Type   |  Sum    |

