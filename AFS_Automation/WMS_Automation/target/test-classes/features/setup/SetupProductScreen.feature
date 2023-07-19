@Setup @Regression
Feature: Testing of Product Setup UOM

  Scenario: Checking UI verification of UOM on Setup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Setup Product page
    And Clicks Add new on Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Warehouse Tab on Setup Product page
    And Validates Add, Edit, Delete buttons are displayed on Setup Product page
    And Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Validates Add, Edit, Delete buttons are displayed on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Setup Product page
    And Validates Items Count and Items Found on Setup Product page
    And Validates UOM grid should display all column names on Setup Product page

  Scenario: Checking UI verification of adding UOM on Setup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Product Tab on Setup Product page
    And Clicks Add new on Setup Product page
    And Types Product Code "200004" on Setup Product page
    And Types Long Description "200004 desc" on Setup Product page
    And Types Alt Description "200004 desc alt" on Setup Product page
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
    And Selects Warehouse "Warehouse 01" on Setup Product page
    And Selects Active "Yes" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks UOM Dropdown on Setup Product page
    And Validates UOM options on Setup Product page
    And Move to UOM Tab on Setup Product page
    And Validates Weight Value "0" on UOM popup on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Validates Weight or Tare Weight options on Setup Product page
    And Move to Weight Unit on Setup Product page
    And Clicks Tare Weight Unit on UOM popup on Setup Product page
    And Validates Weight or Tare Weight options on Setup Product page
    And Move to Tare Weight Unit on Setup Product page
    And Validates Width Value "0" on UOM popup on Setup Product page
    And Clicks Width Unit on UOM popup on Setup Product page
    And Validates Width or Height or Length options on Setup Product page
    And Move to Width Unit on Setup Product page
    And Clicks Next Width Unit on UOM popup on Setup Product page
    And Validates Width or Height or Length options on Setup Product page
    And Move to Next Width Unit on Setup Product page
    And Clicks Height Unit on UOM popup on Setup Product page
    And Validates Width or Height or Length options on Setup Product page
    And Move to Height Unit on Setup Product page
    And Clicks Next Height Unit on UOM popup on Setup Product page
    And Validates Width or Height or Length options on Setup Product page
    And Move to Next Height Unit on Setup Product page
    And Clicks Length Unit on UOM popup on Setup Product page
    And Validates Width or Height or Length options on Setup Product page
    And Move to Length Unit on Setup Product page
    And Clicks Next Length Unit on UOM popup on Setup Product page
    And Validates Width or Height or Length options on Setup Product page
    And Move to Next Length Unit on Setup Product page
    And Validates Cut Time Value "0" on UOM popup on Setup Product page
    And Clicks Cut Time Unit on UOM popup on Setup Product page
    And Validates Cut time options on Setup Product page
    And Move to Cut Time Unit on Setup Product page
    And Clicks Shelf Unit on UOM popup on Setup Product page
    And Validates Shelf Unit Value "0" on UOM popup on Setup Product page
    And Validates Size Code default value on UOM popup on Setup Product page
    And Validates OK and Cancel on UOM popup on Setup Product page are displayed

  Scenario: Checking Creating UOM on Setup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Setup Product page
    And Validates Setup Product page is displayed
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
    And Selects Warehouse "Warehouse 01" on Setup Product page
    And Selects Active "Yes" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Validates Weight Value "10" on UOM popup on Setup Product page
    And Enters Weight "AB" on Setup Product page
    And Validates Weight Value "" on UOM popup on Setup Product page
    And Enters Height "10" on Setup Product page
    And Validates Height Value "10" on UOM popup on Setup Product page
    And Enters Height "AB" on Setup Product page
    And Validates Height Value "" on UOM popup on Setup Product page
    And Enters Length "10" on Setup Product page
    And Validates Length Value "10" on UOM popup on Setup Product page
    And Enters Length "AB" on Setup Product page
    And Validates Length Value "" on UOM popup on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Uncheck Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Validates Size Code Value "16A" on UOM popup on Setup Product page
    And Selects UOM "BAGS" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Validates Weight Value "10" on UOM popup on Setup Product page
    And Enters Height "10" on Setup Product page
    And Validates Height Value "10" on UOM popup on Setup Product page
    And Enters Length "10" on Setup Product page
    And Validates Length Value "10" on UOM popup on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Validates Size Code Value "16A" on UOM popup on Setup Product page
    And Selects UOM "CARTON" on Setup Product page
    And Enters Pack "2" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Validates Weight Value "10" on UOM popup on Setup Product page
    And Enters Height "10" on Setup Product page
    And Validates Height Value "10" on UOM popup on Setup Product page
    And Enters Length "10" on Setup Product page
    And Validates Length Value "10" on UOM popup on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Validates Size Code Value "16A" on UOM popup on Setup Product page
    And Selects UOM "CARTON" on Setup Product page
    And Enters Pack "2" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Enters Pack "2" on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Validates Size Code Value "16A" on UOM popup on Setup Product page
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
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Product Tab on Setup Product page
    And Clicks Add new on Setup Product page
    And Types Product Code "200005" on Setup Product page
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
    And Selects Warehouse "Warehouse 01" on Setup Product page
    And Selects Active "Yes" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Validates Weight Value "10" on UOM popup on Setup Product page
    And Enters Height "10" on Setup Product page
    And Validates Height Value "10" on UOM popup on Setup Product page
    And Enters Length "10" on Setup Product page
    And Validates Length Value "10" on UOM popup on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Validates Size Code Value "16A" on UOM popup on Setup Product page
    And Selects UOM "CARTON" on Setup Product page
    And Clicks OK on Setup Product page
    And Select UOM from grid by index 0 on Setup Product page
    And User clicks Edit button on Setup Product page
    And Validates Dialog Title "Edit UOM" on Setup Product page
    And Selects UOM "CASES" on Setup Product page
    And Enters Weight "8" on Setup Product page
    And Validates Weight Value "8" on UOM popup on Setup Product page
    And Enters Height "9" on Setup Product page
    And Validates Height Value "9" on UOM popup on Setup Product page
    And Enters Length "7" on Setup Product page
    And Validates Length Value "7" on UOM popup on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "1D" on Setup Product page
    And Validates Size Code Value "1D" on UOM popup on Setup Product page
    And Clicks OK on Setup Product page
    And User clicks Edit button on Setup Product page
    And Validates Dialog Title "Edit UOM" on Setup Product page
    And Selects UOM "CASES" on Setup Product page
    And Enters Weight "5" on Setup Product page
    And Validates Weight Value "5" on UOM popup on Setup Product page
    And Enters Height "6" on Setup Product page
    And Validates Height Value "6" on UOM popup on Setup Product page
    And Enters Length "3" on Setup Product page
    And Validates Length Value "3" on UOM popup on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "3D" on Setup Product page
    And Validates Size Code Value "3D" on UOM popup on Setup Product page
    And Clicks Cancel on Setup Product page

  Scenario: Checking Deleting UOM on Setup Product screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Product Tab on Setup Product page
    And Clicks Add new on Setup Product page
    And Types Product Code "200009" on Setup Product page
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
    And Selects Warehouse "Warehouse 01" on Setup Product page
    And Selects Active "Yes" on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks UOM Tab on Setup Product page
    And Validates UOM tab details on Setup Product page
    And Clicks Add on Setup Product page
    And Validates Dialog Title "Add UOM" on Setup Product page
    And Clicks Weight Unit on UOM popup on Setup Product page
    And Enters Weight "10" on Setup Product page
    And Validates Weight Value "10" on UOM popup on Setup Product page
    And Enters Height "10" on Setup Product page
    And Validates Height Value "10" on UOM popup on Setup Product page
    And Enters Length "10" on Setup Product page
    And Validates Length Value "10" on UOM popup on Setup Product page
    And Check Include Opportunistic on Setup Product page
    And Enters Size Code "16A" on Setup Product page
    And Validates Size Code Value "16A" on UOM popup on Setup Product page
    And Selects UOM "CARTON" on Setup Product page
    And Clicks OK on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Setup Product page
    And Select UOM from grid by index 0 on Setup Product page
    And User clicks Delete button on Setup Product page