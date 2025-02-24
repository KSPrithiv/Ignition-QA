Feature: Test scenarios for Admin reports, related to Web payments reports

  Background: For login to application and selecting Account# for Admin reports
    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
    When User is on Home Page for Admin setting for Admin reports
    #Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports

  @ReportCSVFile
  Scenario Outline: Test scenario for generating admin report in .csv form
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Web Payment
    Then User selects Start and End dates for Creating reports
    And User click Generate button and clicks on export .csv
    Examples:
    |Main menu |  Sub menu   |
    |  Reports |Web Payments |

#  @ReportPDFFile
#  Scenario Outline: Test scenario for generating admin report in .PDF form
#    Given User is on Home Page for Admin setting to select Admin option for Admin reports
#    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Web Payment
#    Then User selects Start and End dates for Creating reports
#    And User click Generate button and clicks on export .pdf for admin reports
#    Examples:
#      |Main menu |  Sub menu   |
#      |  Reports |Web Payments |

  @ResetAdminReport
  Scenario Outline: Test scenario for resetting Web page web elements
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>" for Reports, Web Payment
    Then User selects Start and End dates for Creating reports
    And User clicks on reset button value set to all web elements in WebPage should be reset
    Examples:
      |Main menu |  Sub menu   |
      |  Reports |Web Payments |