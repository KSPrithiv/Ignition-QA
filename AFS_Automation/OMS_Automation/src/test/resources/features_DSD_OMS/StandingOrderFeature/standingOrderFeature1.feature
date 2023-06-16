Feature: Standing Order1
  Creation of Standing order and all operation related to standing order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for SO
    When User is on Home Page for SO
    Then User navigate to Client side for SO
    Then User should select Order Entry tab for SO
    Then User selects Account# for SO

  @StandingOrderRegisterExcel
  Scenario: Test scenario for generating Excel sheet for standing order registeration
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User should click on Standing Order Register button
    Then User should search for Customer and Route in Standing order register popup
    And User should click on Excel button, should download csv files

  @StandingOrderRegisterPdf
  Scenario: Test scenario for generating Excel sheet for standing order registeration
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User should click on Standing Order Register button
    Then User should search for Customer and Route in Standing order register popup
    And User should click on PDF button, should Open new browser

  @GenerateStandingOrder
  Scenario:Test scenario for generating standing order
    Given User must be on Order Entry Page to select Standing Order and navigate to standing order
    And User should click on Generate Standing order  button
    Then User should select From and To date in Generate standing order(s) popup, Click on Ok
    And User should click on ok, in All task completed popup