Feature: Admin setting
  Verifying Admin setting features for Restricted Products

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Admin setting
    When User is on Home Page for Admin setting
    Then User Clicks on Permissions by drop down to select Customer Account#

  @LogoutOE
  Scenario:Loging out from the application
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page