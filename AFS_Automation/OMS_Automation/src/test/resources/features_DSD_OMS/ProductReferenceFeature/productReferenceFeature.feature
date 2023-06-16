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
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG and select "<OG>" from grid
    Then User clicks on Product reference tab
    And then assign the Customer Account# to first product
    Examples:
      | OG       |
      | SamplePar |
