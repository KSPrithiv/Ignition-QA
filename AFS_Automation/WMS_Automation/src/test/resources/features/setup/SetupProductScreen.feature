@Setup @Regression
Feature: Testing of Product Setup UOM

  Scenario: Checking UI verification of UOM on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    When Clicks Add new on Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Warehouse Tab on Setup Product page
    Then Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Validates Add, Edit, Delete buttons are displayed on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Setup Product page
    And Validates Items Count and Items Found on Setup Product page
    And Validates UOM grid should display all column names on Setup Product page

  Scenario: Checking UI verification of adding UOM on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Setup Product page
    And Waits for Setup Product page to load
    When Clicks Product Tab on Setup Product page
    And Clicks Add new on Setup Product page
    And Types Product Code "200004" on Setup Product page
    And Types Long Description "200004 desc" on Setup Product page
    And Types Alt Description "200004 desc alt" on Setup Product page
    And Types Size Code "1" on Setup Product page
    Then Types Voiced Code "code" on Setup Product page
    And Types Max Stack "1" on Setup Product page
    And Types High "1" on Setup Product page
    And Selects Product Type "*DEL* 64 Oz Ice cream" on Setup Product page
    And Selects Movement Class "A" on Setup Product page

  Scenario: Checking Creating UOM on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Clicks Product Tab on Setup Product page
    And Clicks Add new on Setup Product page
    And Types Product Code "200004" on Setup Product page
    And Types Long Description "200007 desc" on Setup Product page
    And Types Alt Description "200007 desc alt" on Setup Product page
    And Types Size Code "1" on Setup Product page
    And Types Voiced Code "code" on Setup Product page
    And Types Max Stack "1" on Setup Product page
    And Types High "1" on Setup Product page
    And Selects Product Type "*DEL* 64 Oz Ice cream" on Setup Product page
    And Selects Movement Class "A" on Setup Product page
    And Clicks Save on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Clicks Warehouse Tab on Setup Product page
    And Clicks Add on Setup Product page
    And Selects Warehouse "Warehouse 02" on Setup Product page
    And Selects Active "Yes" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Enters Weight "AB" on Setup Product page
    And Validates Weight Value "" on UOM popup on Setup Product page
    And Enters Height "10" on Setup Product page
    And Enters Height "AB" on Setup Product page
    And Validates Height Value "" on UOM popup on Setup Product page
    And Enters Length "10" on Setup Product page
    And Enters Length "AB" on Setup Product page
    And Validates Length Value "" on UOM popup on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Uncheck Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Selects UOM "BAGS" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Enters Height "10" on Setup Product page
    And Enters Length "10" on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Selects UOM "CARTON" on Setup Product page
    And Enters Pack "2" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Enters Height "10" on Setup Product page
    And Enters Length "10" on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Selects UOM "CARTON" on Setup Product page
    And Enters Pack "2" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Enters Pack "2" on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Clicks OK on Setup Product page
    And Validates Alert "Uom is required" on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks OK on Setup Product page
    And Validates Alert "Uom is required" on Setup Product page
    And Validates Alert "Packsize must be more than 1" on Setup Product page
    And Clicks Cancel on Setup Product page

  Scenario: Checking Editing UOM on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Clicks Product Tab on Setup Product page
    When Clicks Add new on Setup Product page
    And Types Product Code "200005" on Setup Product page
    And Types Long Description "200007 desc" on Setup Product page
    And Types Alt Description "200007 desc alt" on Setup Product page
    And Types Size Code "1" on Setup Product page
    Then Types Voiced Code "code" on Setup Product page
    And Types Max Stack "1" on Setup Product page
    And Types High "1" on Setup Product page
    And Selects Product Type "*DEL* 64 Oz Ice cream" on Setup Product page
    And Selects Movement Class "A" on Setup Product page
    And Clicks Save on Setup Product page

  Scenario: Checking Deleting UOM on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    
    And Go to Setup Product page
    And Waits for Setup Product page to load
    When Clicks Product Tab on Setup Product page
    And Clicks Add new on Setup Product page
    And Types Product Code "200009" on Setup Product page
    And Types Long Description "200007 desc" on Setup Product page
    Then Types Alt Description "200007 desc alt" on Setup Product page
    And Types Size Code "1" on Setup Product page
    And Types Voiced Code "code" on Setup Product page
    And Types Max Stack "1" on Setup Product page
    And Types High "1" on Setup Product page
    And Selects Product Type "*DEL* 64 Oz Ice cream" on Setup Product page
    And Selects Movement Class "A" on Setup Product page
    And Clicks Save on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Clicks Warehouse Tab on Setup Product page
    And Clicks Add on Setup Product page
    And Selects Warehouse "Warehouse 02" on Setup Product page
    And Selects Active "Yes" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Enters Height "10" on Setup Product page
    And Enters Length "10" on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Selects UOM "CARTON" on Setup Product page
    And Clicks OK on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Setup Product page
    And Select UOM from grid by index 0 on Setup Product page
    And User clicks Delete button on Setup Product page