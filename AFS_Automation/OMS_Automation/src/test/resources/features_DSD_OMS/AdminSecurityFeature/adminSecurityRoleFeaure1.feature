Feature: scenarios for admin security and submenu roles, for creating role, editing etc

  Background: For login to application and selecting Account# for admin security
    Given User enters URL and is on login page and entered credentials for Admin setting for admin security
    When User is on Home Page for Admin setting for admin security
   # Then User Clicks on Permissions by drop down to select Customer Account# for admin security

  @LogoutAdimSecurity
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page