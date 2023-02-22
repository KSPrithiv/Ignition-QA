Feature: Par Order
  Used for creation of New Par Order, Delete par,

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @CreateParOrder
  Scenario Outline: Creating new par order
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Click on New Par list button
    And User enters code and discription for Par list
    | ParCode1 | ParDes1 |
    Then User clicks on save Par list
    Examples:
    | OG      |
    |SampleOG1|

  @CreateMultiplePar
  Scenario Outline: Creating new par order
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on ParList tab and Click on New Par list button
    And User enters code and discription to create multiple Par list
      | ParCode1 | ParDes1 |
      | ParCode2 | ParDes2 |
      | ParCode3 | ParDes3 |
    Then User clicks on save Par list
    Examples:
      | OG      |
      |SampleOG1|

  @SearchForProduct
  Scenario: Test scenario to search for product in Par list
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
