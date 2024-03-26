Feature: Competitive Pricing
  All the scenarios that performs all the scenarios related to Competitive pricing

  Background: For login to application and select Competitior pricing
    Given User enters URL and is on login page and entered credentials for Competitior pricing
    When User is on Home Page for Competitior pricing
    Then User navigate to Client side for Competitior pricing

  @ReportLocalChainERP
  Scenario Outline: Test scenario for generating report with Local chain in ERP env
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User navigates to "<Reportstab>" under competitor pricing and select "<Groupby>" tab under Reports
    Then User should select Group by in groupOne and even select chain
      |Local chain|
    Examples:
      |     Reportstab |  Groupby |
      |    Report      |  Group by |

  @ReportNationalChainERP
  Scenario Outline: Test scenario for generating report with National chain in ERP env
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User navigates to "<Reportstab>" under competitor pricing and select "<Groupby>" tab under Reports
    Then User should select Group by in groupOne and even select chain
      |National chain|
    Examples:
      |     Reportstab |  Groupby |
      |    Report       |  Group by |


  @ReportMarketSegment
  Scenario Outline: Test scenario for generating report with Market segment in ERP env
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User navigates to "<Reportstab>" under competitor pricing and select "<Groupby>" tab under Reports
    Then User should select Group by in groupOne and even select chain
      |Market segment|
    Examples:
      |     Reportstab |  Groupby |
      |    Report       |  Group by |

  @ReportPriceGroupDefaultSchedule
  Scenario Outline: Test scenario for generating report with Price base in ERP env
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User navigates to "<Reportstab>" under competitor pricing and select "<Groupby>" tab under Reports
    Then User should select Group by in groupOne and even select chain
      |Price group - default schedule|
    Examples:
      |     Reportstab |  Groupby |
      |    Report       |  Group by |
