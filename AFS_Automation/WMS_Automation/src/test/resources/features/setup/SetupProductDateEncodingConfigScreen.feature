@Setup @Regression
Feature: Testing of Product Setup Date encoding
  @isofailed
  Scenario: Checking Navigation to Date encoding on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    Then Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page

  @isofailed
  Scenario: Checking UI verification of Date Encoding on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    When Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Setup Product page
    Then Validates Search Box and Add Filter are displayed on Setup Product page
    And Validates Items Count and Items Found on Setup Product page

  @isofailed
  Scenario: Checking filters of Date Encoding on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Validates Items Count and Items Found on Setup Product page
    When User clicks Add Filter on Setup Product page
    And User clicks Code Filter on Setup Product page
    And User checks Is Empty radio button on Setup Product page
    And User clicks Apply button on Setup Product page
    And Validates grid text "Adjust filter to display data" on Setup Product page
    Then User clicks Add Filter on Setup Product page
    And User clicks Clear All button on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Code Filter on Setup Product page
    And User types "BY LOT" filter on Setup Product page
    And User clicks Apply button on Setup Product page
    And Validates items are present on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Clear All button on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Desc Filter on Setup Product page
    And User checks Is Empty radio button on Setup Product page
    And User clicks Apply button on Setup Product page
    And Validates grid text "Adjust filter to display data" on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Clear All button on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Desc Filter on Setup Product page
    And User types "Manufacturer date" filter on Setup Product page
    And User clicks Apply button on Setup Product page
    And Validates items are present on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Clear All button on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Extract Date As Filter on Setup Product page
    And User checks Is Empty radio button on Setup Product page
    And User clicks Apply button on Setup Product page
    And Validates grid text "Adjust filter to display data" on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Clear All button on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Extract Date As Filter on Setup Product page
    And User types "1" filter on Setup Product page
    And User clicks Apply button on Setup Product page
    And Validates items are present on Setup Product page
    And User clicks Add Filter on Setup Product page
    And User clicks Clear All button on Setup Product page

  @isofailed
  Scenario: Checking search controls of Date Encoding on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    When Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Validates Items Count and Items Found on Setup Product page
    Then User clicks Add Filter on Setup Product page

  @isofailed
  Scenario: Checking UI verification of encoding tab on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    When Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    Then Clicks Extract date as dropdown on Setup Product page
    And Validates Extract date as options on Setup Product page
    And Clicks Extract date as dropdown on Setup Product page
    And Validates Extract Date As Text "(None)" on Date encoding popup on Setup Product page
    And Validates Day Mapping Text "(None)" on Date encoding popup on Setup Product page
    And Validates Month Mapping Text "(None)" on Date encoding popup on Setup Product page
    And Validates Year Mapping Text "(None)" on Date encoding popup on Setup Product page
    And Validates Week Mapping Text "(None)" on Date encoding popup on Setup Product page
    And Clicks Day Mapping dropdown on Setup Product page
    And Validates Day Mapping options on Setup Product page
    And Clicks Month Mapping dropdown on Setup Product page
    And Validates Month Mapping options on Setup Product page

  @isofailed
  Scenario: Checking UI verification of Used by tab on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    When Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    Then Clicks Add Date Encoding on Setup Product page
    And Clicks Used By Tab Label on Setup Product page
    And Validates Supplier and Product are displayed on Setup Product page

  @isofailed
  Scenario: Checking verification of Day mapping of encoding tab on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    When Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Day Mapping "Digit from char" on Setup Product page
    And Clicks Day Mapping Label on Setup Product page
    And Enter Day Mapping 1 "1" value on Date encoding popup on Setup Product page
    And Enter Day Mapping 2 "abc" value on Date encoding popup on Setup Product page
    And Enter Day Mapping 3 "??##%" value on Date encoding popup on Setup Product page
    And Enter Day Mapping 4 " " value on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Clicks Encoding Label on Setup Product page
    Then Selects Day Mapping "char to value" on Setup Product page
    And Clicks Day Mapping Label on Setup Product page
    And Validates Date Encoding Row "1" on Setup Product page
    And Validates Date Encoding Row "2" on Setup Product page
    And Validates Date Encoding Row "3" on Setup Product page
    And Validates Date Encoding Row "4" on Setup Product page
    And Validates Date Encoding Row "5" on Setup Product page
    And Validates Date Encoding Row "6" on Setup Product page
    And Validates Date Encoding Row "7" on Setup Product page
    And Validates Date Encoding Row "8" on Setup Product page
    And Validates Date Encoding Row "9" on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Date encoding popup on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Value "12" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Character "ch" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Edit on Date encoding popup on Setup Product page
    And Types character "8" on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Edit on Date encoding popup on Setup Product page
    And Types value "2" on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Delete on Date encoding popup on Setup Product page

  @isofailed
  Scenario: Checking verification of Month mapping of encoding tab on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    When Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Month Mapping "Digit from char" on Setup Product page
    And Clicks Month Mapping Label on Setup Product page
    And Enter Month Mapping 1 "1" value on Date encoding popup on Setup Product page
    And Enter Month Mapping 2 "abc" value on Date encoding popup on Setup Product page
    And Enter Month Mapping 3 "??##%" value on Date encoding popup on Setup Product page
    And Enter Month Mapping 4 " " value on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Clicks Encoding Label on Setup Product page
    And Selects Month Mapping "char to value" on Setup Product page
    Then Clicks Month Mapping Label on Setup Product page
    And Validates Date Encoding Row "1" on Setup Product page
    And Validates Date Encoding Row "2" on Setup Product page
    And Validates Date Encoding Row "3" on Setup Product page
    And Validates Date Encoding Row "4" on Setup Product page
    And Validates Date Encoding Row "5" on Setup Product page
    And Validates Date Encoding Row "6" on Setup Product page
    And Validates Date Encoding Row "7" on Setup Product page
    And Validates Date Encoding Row "8" on Setup Product page
    And Validates Date Encoding Row "9" on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Date encoding popup on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Value "12" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Character "ch" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Edit on Date encoding popup on Setup Product page
    And Types character "8" on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Edit on Date encoding popup on Setup Product page
    And Types value "2" on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Delete on Date encoding popup on Setup Product page

  @isofailed
  Scenario: Checking verification of Year mapping of encoding tab on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    When Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Year Mapping "Digit from char" on Setup Product page
    And Clicks Year Mapping Label on Setup Product page
    And Enter Year Mapping 1 "1" value on Date encoding popup on Setup Product page
    And Enter Year Mapping 2 "abc" value on Date encoding popup on Setup Product page
    And Enter Year Mapping 3 "??##%" value on Date encoding popup on Setup Product page
    And Enter Year Mapping 4 " " value on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Clicks Encoding Label on Setup Product page
    And Selects Year Mapping "char to value" on Setup Product page
    Then Clicks Year Mapping Label on Setup Product page
    And Validates Date Encoding Row "1" on Setup Product page
    And Validates Date Encoding Row "2" on Setup Product page
    And Validates Date Encoding Row "3" on Setup Product page
    And Validates Date Encoding Row "4" on Setup Product page
    And Validates Date Encoding Row "5" on Setup Product page
    And Validates Date Encoding Row "6" on Setup Product page
    And Validates Date Encoding Row "7" on Setup Product page
    And Validates Date Encoding Row "8" on Setup Product page
    And Validates Date Encoding Row "9" on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Date encoding popup on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Value "" on Month mapping on Setup Product page
    And Enter Character "" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Value "5" on Month mapping on Setup Product page
    And Enter Character "" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Value "" on Month mapping on Setup Product page
    And Enter Character "chr" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Edit on Date encoding popup on Setup Product page
    And Types character "8" on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Edit on Date encoding popup on Setup Product page
    And Types value "2" on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Delete on Date encoding popup on Setup Product page

  @isofailed
  Scenario: Checking verification of Week mapping of encoding tab on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    When Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    Then Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Week Mapping "Digit from char" on Setup Product page
    And Clicks Week Mapping Label on Setup Product page
    And Enter Week Mapping 1 "1" value on Date encoding popup on Setup Product page
    And Enter Week Mapping 2 "abc" value on Date encoding popup on Setup Product page
    And Enter Week Mapping 3 "??##%" value on Date encoding popup on Setup Product page
    And Enter Week Mapping 4 " " value on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Clicks Encoding Label on Setup Product page
    And Selects Week Mapping "char to value" on Setup Product page
    And Clicks Week Mapping Label on Setup Product page
    And Validates Date Encoding Row "1" on Setup Product page
    And Validates Date Encoding Row "2" on Setup Product page
    And Validates Date Encoding Row "3" on Setup Product page
    And Validates Date Encoding Row "4" on Setup Product page
    And Validates Date Encoding Row "5" on Setup Product page
    And Validates Date Encoding Row "6" on Setup Product page
    And Validates Date Encoding Row "7" on Setup Product page
    And Validates Date Encoding Row "8" on Setup Product page
    And Validates Date Encoding Row "9" on Setup Product page
    And Validates Add is enabled and Edit, Delete are disabled on Date encoding popup on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Value "" on Month mapping on Setup Product page
    And Enter Character "" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Value "5" on Month mapping on Setup Product page
    And Enter Character "" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Clicks Add on Date encoding popup on Setup Product page
    And Enter Value "" on Month mapping on Setup Product page
    And Enter Character "chr" on Month mapping on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Edit on Date encoding popup on Setup Product page
    And Types character "8" on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Edit on Date encoding popup on Setup Product page
    And Types value "2" on Date encoding popup on Setup Product page
    And Clicks OK on Setup Product page
    And Selects row "1" on Setup Product page
    And Clicks Delete on Date encoding popup on Setup Product page

  @isofailed
  Scenario: Checking validations of encoding tab on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    When Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    Then Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask" on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Validates warning message "Code cannot be blank" on Date encoding popup on Setup Product page
    And Enter Input Code "code" on Date encoding popup on Setup Product page
    And Enter Input Desc " " on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Validates warning message "Description cannot be blank" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask " " on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Validates warning message "Lot mask cannot be blank" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask" on Date encoding popup on Setup Product page
    And Selects Extract date as "(None)" on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Validates warning message "Select Extract date as" on Date encoding popup on Setup Product page

  @isofailed
  Scenario: Checking creation with mandatory values on Date encoding popup on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Waits for Setup Product page to load
    And Validates Setup Product page is displayed
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    When Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    Then Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "CODEE 5" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc 11" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 11" on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Clicks Product Label on Setup Product page
    And Clicks Add new on Setup Product page
    And Clicks Suppliers Tab on Setup Product page
    And Clicks Add on Setup Product page
    And User clicks Date encoding dropdown on Setup Product page
    And Validates "CODEE 5" option on Setup Product page
    And User clicks Date encoding dropdown on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "CODEE 5" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc 11" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 11" on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Validates warning message "\"CODEE 5 \" is a duplicate code" on Date encoding popup on Setup Product page
    And Clicks Cancel on Setup Product page
    And Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    And Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "CODE 55" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc 11" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 11" on Date encoding popup on Setup Product page
    And Clicks Cancel on popup on Setup Product page
    And Selects row by code "CODEE 5" on Setup Product page
    And User clicks Delete Settings button on Setup Product page
    And Clicks OK Button on Setup Product page

  @isofailed
  Scenario: Checking Editing date encoding on Setup Product screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Setup Product page
    And Validates Setup Product page is displayed
    And Clicks Date encoding Label on Setup Product page
    And Validates Date encoding tab grid should display all column names on Setup Product page
    When Clicks Add Date Encoding on Setup Product page
    And Validates Encoding and Used by are enabled and Day mapping, Month mapping, Year mapping and Week mapping are disabled on Setup Product page
    And Validates Date encoding fields are displayed correctly on Setup Product page
    And Selects Day Mapping "(None)" on Setup Product page
    And Selects Month Mapping "(None)" on Setup Product page
    And Selects Year Mapping "(None)" on Setup Product page
    And Selects Week Mapping "(None)" on Setup Product page
    Then Selects Extract date as "Production date" on Setup Product page
    And Enter Input Code "CODE10" on Date encoding popup on Setup Product page
    And Enter Input Desc "desc 11" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 11" on Date encoding popup on Setup Product page
    And Clicks Save on popup on Setup Product page
    And Selects row by code "CODE10" on Setup Product page
    And User clicks Edit Settings button on Setup Product page
    And Enter Input Desc "desc 12" on Date encoding popup on Setup Product page
    And Enter Input Lot Mask "lot mask 12" on Date encoding popup on Setup Product page
    And Selects Extract date as "Expiration date" on Setup Product page
    And Clicks Cancel on popup on Setup Product page
    And Selects row by code "CODE10" on Setup Product page
    And User clicks Delete Settings button on Setup Product page
    And Clicks OK Button on Setup Product page