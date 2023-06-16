@Counting @Regression
Feature: Testing of Counting Count functionality

  Scenario: Checking Navigate to Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And Validates Edit and Delete buttons are disabled on Counting Sessions page

  Scenario: Checking Existing Count Session on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User clicks session dropdown on Counting Sessions page
    And Validates sessions are present in Session dropdown on Counting Sessions page
    And User clicks session page title on Counting Sessions page
    And User selects session "Blind Session - Active" on Counting Sessions page
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    And Validates Session Labels on Counting Sessions page are displayed
    And Validates Blind Label on Counting Sessions page is displayed

  Scenario: Checking Create New Session on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User clicks New Session button on Counting Sessions page
    And Validates Session name and Count type are displayed on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates session warning "Enter session name" on Counting Sessions page
    And User types session "Test session" name on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates session warning "Select count type" on Counting Sessions page
    And User types count type "Partailly Informed" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User selects session "Test session - Inactive" on Counting Sessions page
    And Validates session "Test session - Inactive" is saved on Counting Sessions page
    And Validates Session Labels on Counting Sessions page are displayed
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    And Validates Partially informed Label on Counting Sessions page is displayed
    And Validates Session details on Counting Sessions page
    And Validates Active Checkbox is not selected on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates items are not present on Counting Sessions page
    And Validates No Record on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Validates items are not present on Counting Sessions page
    And Validates No Record on Counting Sessions page
    And User clicks Assignments tab on Counting Sessions page
    And Validates items are not present on Counting Sessions page
    And Validates No Record on Counting Sessions page
    And User clicks New Session button on Counting Sessions page
    And Validates Session name and Count type are displayed on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page
    And User clicks Delete Session button on Counting Sessions page
    And User clicks Ok button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page

  Scenario: Checking add locations to the session on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User clicks New Session button on Counting Sessions page
    And Validates Session name and Count type are displayed on Counting Sessions page
    And User types session "Session123" name on Counting Sessions page
    And User types count type "Blind" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User selects session "Session123" on Counting Sessions page
    And Validates session "Session123" is saved on Counting Sessions page
    And Validates Locations, Products and Assignments Tabs are displayed on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User types Location code "TB04B" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User selects Location code "GOL" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User clicks Location code button on Counting Sessions page
    And Validates Location index popup is displayed on Counting Sessions page
    And Selects location by index 0 on Counting Sessions page
    And Validates Location Code is not empty on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User types Partial location code "PartName123" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User selects Location type "Floor Reserve" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User selects Zone "CHL" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User types Starting Location "101.056.01" on Counting Sessions page
    And User types Ending Location "101.060.01" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User selects session "Session123" on Counting Sessions page
    And User clicks Add location button on Counting Sessions page
    And Validates Add Location Popup on Counting Sessions page
    And User types Location code "testloc" on Counting Sessions page
    And User types Partial location code "testPartName" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User selects session "Session123" on Counting Sessions page
    And User clicks Delete Session button on Counting Sessions page
    And User clicks Ok button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page

  Scenario: Checking Sorting of the columns on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User selects session "SavInformed - Active" on Counting Sessions page
    And User clicks Location Column on Counting Sessions page
    And Validates Location Column Sorting Result on Counting Sessions page
    And User clicks Location Column on Counting Sessions page
    And Validates Location Column Sorting Result on Counting Sessions page
    And User clicks Zone Column on Counting Sessions page
    And Validates Zone Column Sorting Result on Counting Sessions page
    And User clicks Zone Column on Counting Sessions page
    And Validates Zone Column Sorting Result on Counting Sessions page
    And User clicks Type Column on Counting Sessions page
    And Validates Type Column Sorting Result on Counting Sessions page
    And User clicks Type Column on Counting Sessions page
    And Validates Type Column Sorting Result on Counting Sessions page
    And User clicks Status Column on Counting Sessions page
    And Validates Status Column Sorting Result on Counting Sessions page
    And User clicks Status Column on Counting Sessions page
    And Validates Status Column Sorting Result on Counting Sessions page
    And User clicks Counts Column on Counting Sessions page
    And Validates Counts Column Sorting Result on Counting Sessions page
    And User clicks Counts Column on Counting Sessions page
    And Validates Counts Column Sorting Result on Counting Sessions page
    And User clicks Release Date and Time Column on Counting Sessions page
    And Validates Release Date Time Column Sorting Result on Counting Sessions page
    And User clicks Release Date and Time Column on Counting Sessions page
    And Validates Release Date Time Column Sorting Result on Counting Sessions page

  Scenario: Checking Location Navigation on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User selects session "444444 - Inactive" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks table location by index 1 on Counting Sessions page
    And Waits for Location Lookup page to load
    And Validates Notification Warning "Location locked" on Location Lookup page is displayed
    And Validates Inventory details of location on Location Lookup page are loaded

  Scenario: Checking Locked location on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User selects session "444444 - Inactive" on Counting Sessions page
    And User clicks table location by index 1 on Counting Sessions page
    And Waits for Location Lookup page to load
    And Validates Inventory details of location on Location Lookup page are loaded
    And Validates Notification Warning "Location locked" on Location Lookup page is displayed
    And Validates Add location button is disabled on Lookup Location page
    And User checks table row by index 1 on Counting Sessions page
    And User clicks Delete Session button on Counting Sessions page
    And User clicks Yes button on Counting Sessions page
    And User selects reason "Create Inventory" on Counting Sessions page
    And User clicks Ok button on Counting Sessions page
    And Validates notification message contains "Location" message on Counting Sessions page
    And Validates notification message contains "is locked" message on Counting Sessions page

  Scenario: Checking Select All checkbox on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User selects session "SavInformed - Active" on Counting Sessions page
    And User clicks Select All Checkbox on Counting Sessions page
    And Validates location with index 0 is selected on Counting Sessions page
    And User clicks Select All Checkbox on Counting Sessions page
    And Validates location with index 0 is not selected on Counting Sessions page

  Scenario: Checking Count Details on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User selects session "Blind Session - Active" on Counting Sessions page
    And User clicks table count by index 0 on Counting Sessions page
    And Validates Count Details popup on Counting Sessions page
    And Validates Count History columns are displayed on Counting Sessions page
    And User clicks all inputs checkbox on Count details popup on Counting Sessions page
    And Validates Counted Location columns on Count details popup on Counting Sessions page

  Scenario: Checking Release Counts on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User selects session "SavInformed - Active" on Counting Sessions page
    And User checks table row by index 0 on Counting Sessions page
    And User clicks Location Release on Counting Sessions page
    And Validates Release counts popup is displayed on Counting Sessions page
    And Types Tasks "testTask" per Assignment on Counting Sessions page
    And Validates task per assignment value "" on Counting Sessions page
    And Types Tasks "test%$" per Assignment on Counting Sessions page
    And Validates task per assignment value "" on Counting Sessions page
    And Types Tasks "123" per Assignment on Counting Sessions page
    And Validates task per assignment value "123" on Counting Sessions page
    And Clears Tasks per Assignment on Counting Sessions page
    And Types Tasks "1" per Assignment on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates notification "You must put between 4 and 199 count tasks in each count book." on Counting Sessions page
    And Clears Tasks per Assignment on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page
    And User checks table row by index 0 on Counting Sessions page
    And User clicks Location Release on Counting Sessions page
    And Validates Release counts popup is displayed on Counting Sessions page
    And Clicks User directed counting radio button on Counting Sessions page
    And User types future Release date in 3 days on Counting Sessions page
    And User types future Release time "12:01" days on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User clicks Location Release on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page

  Scenario: Checking Product details in Product tab on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "SavInformed - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Validates Products tab screen is displayed on Counting Sessions page
    And Validates Delete and Reset Product are disabled on Counting Sessions page
    And Validates Generate locations button is displayed on Counting Sessions page
    And Validates Generate locations is enabled on Counting Sessions page
    And Validates Add Product is enabled on Counting Sessions page
    And Validates table rows are displayed on Counting Sessions page

  Scenario: Checking Reconcile session on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Location Reconcile on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page

  Scenario: Checking Search and Add Filter functionality on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And User searches for product "200007" on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User deletes product search input on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User searches for product "20" on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User deletes product search input on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Product Checkbox on Counting Sessions page
    And Types Product "200003" on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Owner Checkbox on Counting Sessions page
    And Types Owner "01" on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Description Checkbox on Counting Sessions page
    And Types Description "ALL" on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Counts Checkbox on Counting Sessions page
    And Types Counts "1" on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Book Cost Checkbox on Counting Sessions page
    And Types Book cost "80" on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Product Type Checkbox on Counting Sessions page
    And Types Product type "RCE" on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page

  Scenario: Checking Add Products from Product tab on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "50" number of products on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "DRY GOODS" product type on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Selects "A" movement class on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Types "250" minimum cost on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Types "2500" maximum cost on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Selects "01" owner dropdown on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Types "10005" supplier on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Types "200002" starting product range on Counting Sessions page
    And Types "200030" ending product range on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Types "200002" starting product range on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "200030" ending product range on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "UPC CODE" prod alias type on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "Damaged" inventory status on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "BREAK PACK" product type on Counting Sessions page
    And Selects "C" movement class on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "(Any)" product type on Counting Sessions page
    And Selects "A" movement class on Counting Sessions page
    And Types "10000" supplier on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "(Any)" product type on Counting Sessions page
    And Selects "A" movement class on Counting Sessions page
    And Types "10008" supplier on Counting Sessions page
    And Selects "01" owner dropdown on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "(Any)" product type on Counting Sessions page
    And Selects "A" movement class on Counting Sessions page
    And Types "10008" supplier on Counting Sessions page
    And Selects "01" owner dropdown on Counting Sessions page
    And Types "Damaged" inventory status on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "(Any)" product type on Counting Sessions page
    And Selects "A" movement class on Counting Sessions page
    And Types "10008" supplier on Counting Sessions page
    And Selects "01" owner dropdown on Counting Sessions page
    And Types "Stock" inventory status on Counting Sessions page
    And Types "GTIN" prod alias type on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page

  Scenario: Checking Sorting and Select All on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Clicks All Checkbox button on Counting Sessions page
    And Validates product with index 1 is selected on Counting Sessions page
    And Validates product with index 2 is selected on Counting Sessions page
    And Clicks All Checkbox button on Counting Sessions page
    And Validates product with index 1 is not selected on Counting Sessions page
    And Validates product with index 2 is not selected on Counting Sessions page
    And User clicks Product Column on Counting Sessions page
    And Validates Product Column Sorting Result on Counting Sessions page
    And User clicks Product Column on Counting Sessions page
    And Validates Product Column Sorting Result on Counting Sessions page
    And User clicks Owner Column on Counting Sessions page
    And Validates Owner Column Sorting Result on Counting Sessions page
    And User clicks Owner Column on Counting Sessions page
    And Validates Owner Column Sorting Result on Counting Sessions page
    And User clicks Description Column on Counting Sessions page
    And Validates Description Column Sorting Result on Counting Sessions page
    And User clicks Description Column on Counting Sessions page
    And Validates Description Column Sorting Result on Counting Sessions page
    And User clicks Book Cost Column on Counting Sessions page
    And Validates Book Cost Column Sorting Result on Counting Sessions page
    And User clicks Book Cost Column on Counting Sessions page
    And Validates Book Cost Column Sorting Result on Counting Sessions page
    And User clicks Product Type Column on Counting Sessions page
    And Validates Product Type Column Sorting Result on Counting Sessions page
    And User clicks Product Type Column on Counting Sessions page
    And Validates Product Type Column Sorting Result on Counting Sessions page
    And User clicks Counts Column on Counting Sessions page
    And Validates Counts Column Sorting Result on Counting Sessions page
    And User clicks Counts Column on Counting Sessions page
    And Validates Counts Column Sorting Result on Counting Sessions page

  Scenario: Checking Remove Products from Product Tab on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed - Inactive" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And User checks table row by index 1 on Counting Sessions page
    And Clicks Delete products button on Counting Sessions page
    And Validates dialog text "Remove highlighted items?" on Counting Sessions page
    And Validates Cancel and OK buttons are displayed on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page
    And User checks table row by index 2 on Counting Sessions page
    And Clicks Delete products button on Counting Sessions page
    And Validates dialog text "Remove highlighted items?" on Counting Sessions page
    And Validates Cancel and OK buttons are displayed on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page

  Scenario: Checking Generate locations from Product tab on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "SavInformed - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Clicks Generate locations button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page

  Scenario: Checking Delete Assignments on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "SavInformed - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page
    And Validates Release button is disabled on Counting Sessions page
    And Validates Delete button is disabled on Counting Sessions page
    And Validates Assignments columns are displayed on Counting Sessions page

  Scenario: Checking Assignment Details on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "SavInformed - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page

  Scenario: Checking Search Control and Add Filter and Sorting for Assignments on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "AP-Informed01 - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Assignments tab on Counting Sessions page
    And User clicks Clear Filter on Counting Sessions page
    And User clicks Add Filter on Counting Sessions page
    And Validates Assignment filters are displayed on Counting Sessions page

  Scenario: Checking Add Products from Product pab on Counting Sessions screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Counting Sessions page
    And Validates Counting Sessions page is displayed
    And User selects session "DEFAULT COUNT - Active" on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types product "000014" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types product "0000144" on Counting Sessions page
    And User clicks Save button on Counting Sessions page
   # And Validates "0000144 is not a valid Product Code." notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "50" number of products on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "Beef" product type on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "A" movement class on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "0030" supplier on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "GTIN" prod alias type on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Types "Hidden" inventory status on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "Sausage" product type on Counting Sessions page
    And Selects "B" movement class on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "Sausage" product type on Counting Sessions page
    And Selects "B" movement class on Counting Sessions page
    And Types "0022" supplier on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "Sausage" product type on Counting Sessions page
    And Selects "B" movement class on Counting Sessions page
    And Types "0022" supplier on Counting Sessions page
    And Selects "02" owner dropdown on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "Sausage" product type on Counting Sessions page
    And Selects "B" movement class on Counting Sessions page
    And Types "0022" supplier on Counting Sessions page
    And Selects "02" owner dropdown on Counting Sessions page
    And Types "Hidden" inventory status on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "Sausage" product type on Counting Sessions page
    And Selects "B" movement class on Counting Sessions page
    And Types "0022" supplier on Counting Sessions page
    And Selects "02" owner dropdown on Counting Sessions page
    And Types "Stock" inventory status on Counting Sessions page
    And Types "PRODUCT CODE" prod alias type on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And Clicks Add Product Button on Counting Sessions page
    And Validates "Add product" popup is displayed on Counting Sessions page
    And Selects "Sausage" product type on Counting Sessions page
    And Selects "B" movement class on Counting Sessions page
    And Types "0022" supplier on Counting Sessions page
    And Selects "02" owner dropdown on Counting Sessions page
    And Types "Stock" inventory status on Counting Sessions page
    And Types "PRODUCT CODE" prod alias type on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page