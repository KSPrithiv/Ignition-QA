Feature: Product reference
  Used for representing different functionality of Product reference

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for PR
    When User is on Home Page for PR
    Then User navigate to Client side for PR
    Then User should select Order Entry tab for PR
    Then User selects Account# for PR

  @AssignCustomerAccount
  Scenario Outline: Test scenario for assigning customer account# to product
    Given User must be on Order Entry Page to select OG for Product reference
    And User should navigate to OG and select "<OG>" from grid for Product reference
    Then User clicks on Product reference tab
    And then assign the Customer Account# to first product
    Examples:
      | OG        |
      | SampleOG  |

  @GroupingOfProduct
  Scenario Outline: Test scenario for Grouping of product in product reference
    Given User must be on Order Entry Page to select OG for Product reference
    And User should navigate to OG and select "<OG>" from grid for Product reference
    Then User clicks on Product reference tab
    And Drag and Drop the table header and listout grouping
    |Category|
    Examples:
      | OG        |
      | SampleOG  |

  @SearchingForProduct
  Scenario Outline: Test scenario for searching of product in product reference
    Given User must be on Order Entry Page to select OG for Product reference
    And User should navigate to OG and select "<OG>" from grid for Product reference
    Then User clicks on Product reference tab
    And User search for product using Add filter in Product reference
    Examples:
      | OG        |
      | SampleOG  |



