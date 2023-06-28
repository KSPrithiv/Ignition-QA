Feature: Inventory
  Used for performing different operations on inventory tab

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Inventory
    When User is on Home Page for Inventory
    Then User navigate to Client side for Inventory
    Then User should select Order Entry tab for Inventory
    Then User selects Account# for Inventory

  @LogoutInventory
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page