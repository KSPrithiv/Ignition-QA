Feature: Reports
  Used for to generate different reports

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Reports
    When User is on Home Page for Reports
    Then User navigate to Client side for Reports
    Then User should select Order Entry tab for Reports
    Then User selects Account# for Reports

  @ReportWithValidDate
  Scenario: Test scenrio for generating report with valid from and to date
    Given User must be on Order Entry Page to select Reports
    And User should navigate to Reports
    Then User should select from and to date for Reports generation
    And User should select Customer Account# to generate report
    Then User should verify excel and pdf buttons are enabled

  @ReportWithInvalidToDate
  Scenario: Test scenario for generating report with invalid to date
    Given User must be on Order Entry Page to select Reports
    And User should navigate to Reports
    Then User should select from and to date for Reports generation for invalid to date

  @ShowSelectedCustomer
  Scenario: Test scenario to test show selected customer toggle button
    Given User must be on Order Entry Page to select Reports
    And User should navigate to Reports
    Then User should select from and to date for Reports generation
    And User should select Customer Account#, show selected customer toggle button
    Then User should verify excel and pdf buttons are enabled

  @GenerateExcelReport
  Scenario: Test scenario for testing generation of excel report
    Given User must be on Order Entry Page to select Reports
    And User should navigate to Reports
    Then User should select from and to date for Reports generation
    And User should select Customer Account# to generate report
    Then User should click on excel button to make sure that reports are generated

  @GeneratePdfReport
  Scenario: Test scenario for testing generation of Pdf report
    Given User must be on Order Entry Page to select Reports
    And User should navigate to Reports
    Then User should select from and to date for Reports generation
    And User should select Customer Account# to generate report
    Then User should click on Pdf button to make sure that reports are generated

  @RouteExcelReport
  Scenario: Test scenario for testing generation of excel report for routes
    Given User must be on Order Entry Page to select Reports
    And User should navigate to Reports
    Then User should navigate to Routes tab
    Then User should select from and to date for Reports generation Routes tab
    And User should select Routes to generate report Routes tab
    Then User should click on excel button to make sure that reports are generated Routes tab

  @RoutePdfReport
  Scenario: Test scenario for testing generation of Pdf report for routes
    Given User must be on Order Entry Page to select Reports
    And User should navigate to Reports
    Then User should navigate to Routes tab
    Then User should select from and to date for Reports generation Routes tab
    And User should select Routes to generate report Routes tab
    Then User should click on Pdf button to make sure that reports are generated Routes tab

