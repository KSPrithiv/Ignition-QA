Feature: Statements1
  Contains all the functionalities that comes under statements

  Background: For login to application and select Statements
    Given User enters URL and is on login page and entered credentials for Statements
    When User is on Home Page for Statements
    Then User navigate to Client side for Statements

  @LogoutStatements
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page