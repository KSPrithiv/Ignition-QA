Feature: Reports
  Used for to generate different reports

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Reports
    When User is on Home Page for Reports
    Then User navigate to Client side for Reports
    Then User should select Order Entry tab for Reports
    Then User selects Account# for Reports

