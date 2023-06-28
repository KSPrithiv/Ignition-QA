Feature: scenarios for User and Accounts admin feature, for Grid related settings

  Background: For login to application and selecting Account# for Grid admission control
    Given User enters URL and is on login page and entered credentials for Admin setting for grid
    When User is on Home Page for Admin setting for grid
    Then User Clicks on Permissions by drop down to select Customer Account# grid

  @LogoutGrid
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page