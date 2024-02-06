Feature: scenarios for User and Accounts admin feature, for Grid related settings

  Background: For login to application and selecting Account# for Grid admission control
    Given User enters URL and is on login page and entered credentials for Admin setting for grid
    When User is on Home Page for Admin setting for grid
    Then User Clicks on Permissions by drop down to select Customer Account# grid

  @AvailableGrid
  Scenario Outline: Test scenario to verifing avaiablity of grid from Available grid to Grid configuration
    Given User is on Home Page for Admin setting to select Admin option for grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User navigates to Available Grid and selects one of the grid type
    And User navigates to "<ConfigTab1>" and the selected grid type should be loaded
    #And User clicks on save button to save Grid configuration
    Examples:
      |Main menu|Sub menu       | ConfigTab1         |
      |Grids    |Configuration  | Grid Configuration |

  @CheckAvailabilityOfGrid
  Scenario Outline: Test scenario for verifying availablity of same grid under Configuration tab and Available grids tab
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should validate that it is Grid Configuration page, then click on Grid type Drop Down
    Then User reads all the grid names
    And User navigate to Available grid tab and finds all the grids available and disable any grid
    Then User navigates back to Grid configuration tab and checks for available grid type in drop down
    #And User clicks on save button to save Grid configuration
    And User should enable disabled grid in Available grid tab
    Then User navigates back to Grid configuration tab and checks for available grid type in drop down after enabling tab
    #And User clicks on save button to save Grid configuration
    Examples:
      |Main menu|Sub menu       |
      |Grids    |Configuration  |

  @CheckAvailablityOfGridheader
  Scenario Outline: Test scenario for disable one of the grid column and verifying same in Grid Configuration
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    And User navigate to Available grid tab and select one of the grid and read all the column header available for selected grid
    Then User should validate that it is Grid Configuration page, then click on Grid type Drop Down
    And User should select Grid type "<Grid type>" from the drop down
    And User clicks on save button to save Grid configuration
    Then User validates availablity of disabled column in grid "<Grid type>"
    And User again enables column availability in Available grid
   # Then User should navigate back to Grid configuration and click on Save button
    Examples:
      |Main menu|Sub menu       |Grid type  |
      |Grids    |Configuration  |Order Entry|

  @AddGrid
  Scenario Outline: Test scenario for adding new grid
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should validate that it is Grid Configuration page, then click on Grid type Drop Down
    And User should select Grid type "<Grid type>" from the drop down
    And User clicks on Grid option"<Grid option>" and select add option from drop down
    Then User enters "<Grid name>" in grid name input box and saves it
    Examples:
      |Main menu|Sub menu       |Grid type  | Grid name |Grid option |
      |Grids    |Configuration  |Order Entry| New       |Add         |

  @CopyGrid
  Scenario Outline: Test scneario for crating copy of the grid
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should validate that it is Grid Configuration page, then click on Grid type Drop Down
    And User should select Grid type "<Grid type>" from the drop down
    And User should Click and select "<Grid name>" from grids dropdown
    And User clicks on Grid option"<Grid option>" to copy and selects option from drop down
    Examples:
      |Main menu|Sub menu       |Grid type  | Grid name |Grid option |
      |Grids    |Configuration  |Order Entry| New       |Copy        |

  @DefaultGridInClient
  Scenario Outline: Test scenario to set any grid as default(in Admin), and verify the same in client
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should validate that it is Grid Configuration page, then click on Grid type Drop Down
    And User should select Grid type "<Grid type>" from the drop down
    And User should Click and select "<Grid name>" from grids dropdown
    Then User clicks on Default grid toggle button
    Then User logout from Admin page and log in with client credentials
    Then User navigates to Order entry page and in new order entry page finds same grid as default grid "<Grid name>"
      |PO123|
    Then User Clicks on Permissions by drop down to select Customer Account# for grids
    And User should navigate back to "<Main menu>" via search bar and select "<Sub menu>"
    Then User should validate that it is Grid Configuration page, then click on Grid type Drop Down
    And User should select Grid type "<Grid type>" from the drop down
    Then User should reset Default grid toggle button "<Grid name1>"
    Examples:
      |Main menu|Sub menu       |Grid type  | Grid name| Grid name1 |
      |Grids    |Configuration  |Order Entry| New      | Main       |

  @DeleteGrid
  Scenario Outline: Test scenario for Deleting grid
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User should validate that it is Grid Configuration page, then click on Grid type Drop Down
    And User should select Grid type "<Grid type>" from the drop down
    And User should Click and select "<Grid name>" from grids dropdown
    And User clicks on Grid option"<Grid option>" to delete and selects option from drop down
    And User should select Grid type "<Grid type>" from the drop down
    And User should Click and select "<Grid name1>" from grids dropdown
    And User clicks on Grid option"<Grid option>" to delete and selects option from drop down
    And User should Click and select "<Grid name>" from grids dropdown
    And User clicks on save button to save Grid configuration
    Examples:
      |Main menu|Sub menu       |Grid type  |Grid name  |Grid name1        |Grid option |
      |Grids    |Configuration  |Order Entry|New        |New - Copy        |Delete      |





