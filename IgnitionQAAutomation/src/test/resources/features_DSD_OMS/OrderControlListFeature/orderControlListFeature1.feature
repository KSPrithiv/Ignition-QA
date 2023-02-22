Feature: Order control list1
  Used for cration of order for OCL, searching etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OCL
    When User is on Home Page for OCL
    Then User navigate to Client side for OCL
    Then User should select Order Entry tab for OCL
    Then User selects Account# for OCL

  @SearchByRoute
  Scenario: Test scenario to search based on Route_No in Route input box
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order traker from drop down
    And User clicks on All radio button
    Then User enters Route# in Route search input box and count number of rows in OCL grid
