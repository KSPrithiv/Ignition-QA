Feature: Statements
  Contains all the functionalities that comes under statements

  Background: For login to application and select Statements
    Given User enters URL and is on login page and entered credentials for Statements
    When User is on Home Page for Statements
    Then User navigate to Client side for Statements

  @SearchCustomerAccount
   Scenario: Search for customer account# using search box
    Given User must be on Client side and select Statements
    Then User should confirm that he is in Statements page
    And User selects Customer Account#

  @SearchCustAddFilter
    Scenario: Search for customer account# using Add filter
    Given User must be on Client side and select Statements
    Then User should confirm that he is in Statements page
    And User searches for customer account# using Add filter

  @ClearSearchCustAddFilter
    Scenario: Search for customer account# using add filter and clear the filter value, verify total customer account# displayed
    Given User must be on Client side and select Statements
    Then User should confirm that he is in Statements page
    And User searches for customer account# using Add filter
    Then User clears Add filter value

  @WeeklyStatement
  Scenario: To genereate weekly statements
    Given User must be on Client side and select Statements
    Then User should confirm that he is in Statements page
    And User select Weekly check box in Statements
    Then User Selects Year month and date from respective dropdowns
    And User selects Customer Account# and Clicks on Generate button and verify for pdf for weekly

  @MonthlyStatement
  Scenario: To generate monthly statements
    Given User must be on Client side and select Statements
    Then User should confirm that he is in Statements page
    And User select Monthly check box in Statements
    Then User Selects Year month respective dropdowns
    And User selects Customer Account# and Clicks on Generate button and verify for pdf

  @DateStatement
  Scenario: To generate Date statements
    Given User must be on Client side and select Statements
    Then User should confirm that he is in Statements page
    And User select Date check box in Statements
    Then User Selects start and end dates
    And User selects Customer Account# and Clicks on Generate button and verify for pdf

  @SortAccount#
  Scenario: Test scenario for sorting customer Account#
    Given User must be on Client side and select Statements
    Then User should confirm that he is in Statements page
    And User moves mouse control to customer account# and clicks on sort arrow

  @SortCustomerName
  Scenario: Test scenario for sorting customer Name
    Given User must be on Client side and select Statements
    Then User should confirm that he is in Statements page
    And User moves mouse control to customer name and clicks on sort arrow