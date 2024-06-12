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