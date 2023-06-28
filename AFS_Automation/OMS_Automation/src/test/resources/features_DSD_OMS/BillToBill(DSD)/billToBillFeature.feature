Feature: Bill to bill
  All the scenarios that performs generation of bills

  Background: For login to application and select Bill to billing
    Given User enters URL and is on login page and entered credentials for Bill to bill
    When User is on Home Page for bill to bill
    Then User navigate to Client side for bill to bill

  @WeeklyBillToBill @sanity
  Scenario: To generate Bill to Bill (DSD) weekly
    Given User must be on Client side and select Bill to Bill(DSD)
    Then User should confirm that he is in Bill to bill page
    And User select Weekly radio button
    Then User select Bill group# check box
    And User clicks on Load button
    Then In Bill Selection page user should click on Bill Selection group#
    And User click on Print button on Bill selection page
    And User clicks on Print button in Print customer billing popup

  @MonthlyBillToBill
  Scenario: To generate bill to bill (DSD) monthly
    Given User must be on Client side and select Bill to Bill(DSD)
    Then User should confirm that he is in Bill to bill page
    And User select Monthly radio button
    Then User select Bill group# check box
    And User clicks on Load button
    Then In Bill Selection page user should click on Bill Selection group#
    And User click on Print button on Bill selection page
    And User clicks on Print button in Print customer billing popup

  @CancelBillToBill
  Scenario: To cancel generation of bill to bill(DSD)
    Given User must be on Client side and select Bill to Bill(DSD)
    Then User should confirm that he is in Bill to bill page
    And User select Monthly radio button
    Then User select Bill group# check box
    And User clicks on Load button
    Then In Bill Selection page user should click on Bill Selection group#
    And User should click on Cancel button in Bill Selection page

  @UndoBilling
  Scenario: To Undo Billing in bill to bill(DSD)
    Given User must be on Client side and select Bill to Bill(DSD)
    Then User should confirm that he is in Bill to bill page
    And User select Weekly radio button
    Then User select Bill group# check box
    And User clicks on Load button
    Then In Bill Selection page user should click on Bill Selection group#
    And User should click on UndoBill button in Bill Selection page

  @SelectTaggle
  Scenario: To select range of group and usage of select range taggle button
    Given User must be on Client side and select Bill to Bill(DSD)
    Then User should confirm that he is in Bill to bill page
    And User select Weekly radio button
    Then User select Bill group# check box
    And User clicks on Load button
    Then User selects From range as 2 and to range as 6
    And User click on Print button on Bill selection page
    And User clicks on Print button in Print customer billing popup