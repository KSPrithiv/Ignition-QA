Feature: Competitive Pricing
  All the scenarios that performs all the scenarios related to Competitive pricing

  Background: For login to application and select Competitior pricing
    Given User enters URL and is on login page and entered credentials for Competitior pricing
    When User is on Home Page for Competitior pricing
    Then User navigate to Client side for Competitior pricing

@ReportSingleCustomer
Scenario Outline: Test scenario for generating report with single customer Account#
Given User must be on Client side and select Competitor pricing page
When User should confirm that he is in Competitor pricing page
And User navigates to "<Reportstab>" under competitor pricing and select "<Groupby>" tab under Reports
Then User should select customer account# in groupOne and even select customer
|Customer account #|
Examples:
|     Reportstab |  Groupby |
|    Report       |  Group by |

@ReportMultipleCustomer
Scenario Outline: Test scenario for generating report with Multiple customer Account#
Given User must be on Client side and select Competitor pricing page
When User should confirm that he is in Competitor pricing page
And User navigates to "<Reportstab>" under competitor pricing and select "<Groupby>" tab under Reports
Then User should select multiple customer account# in groupOne and even select customer
|Customer account #|
Examples:
|     Reportstab |  Groupby |
|    Report       |  Group by |

@ReportAscending
Scenario Outline: Test scenario for generating report with ascending order
Given User must be on Client side and select Competitor pricing page
When User should confirm that he is in Competitor pricing page
And User navigates to "<Reportstab>" under competitor pricing and select "<Groupby>" tab under Reports
Then User should select customer account# in groupOne and even select customer and select ascending order radio button
|Customer account #|
Examples:
|     Reportstab |  Groupby |
|    Report       |  Group by |

@ReportDescending
Scenario Outline: Test scenario for generating report with ascending order
Given User must be on Client side and select Competitor pricing page
When User should confirm that he is in Competitor pricing page
And User navigates to "<Reportstab>" under competitor pricing and select "<Groupby>" tab under Reports
Then User should select customer account# in groupOne and even select customer and select descending order radio button
|Customer account #|
Examples:
|     Reportstab |  Groupby |
|    Report       |  Group by |

