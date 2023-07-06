Feature: Competitor pricing

  Background: For login to application and select Competitior pricing
    Given User enters URL and is on login page and entered credentials for Competitior pricing
    When User is on Home Page for Competitior pricing
    Then User navigate to Client side for Competitior pricing

  @LogoutCompetitorPricing
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
