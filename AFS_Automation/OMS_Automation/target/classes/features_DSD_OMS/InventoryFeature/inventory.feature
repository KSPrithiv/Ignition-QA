Feature: Inventory
  Used for performing different operations on inventory tab

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Inventory
    When User is on Home Page for Inventory
    Then User navigate to Client side for Inventory
    Then User should select Order Entry tab for Inventory
    Then User selects Account# for Inventory

  @DragAndDrop
  Scenario: Test scenario for Drag and drop operation in Inventory
    Given User must be on Order Entry Page to select Inventory tab
    And User should navigate to Inventory tab
    Then User should Drag and drop any of the table header for grouping
      |Total Units|