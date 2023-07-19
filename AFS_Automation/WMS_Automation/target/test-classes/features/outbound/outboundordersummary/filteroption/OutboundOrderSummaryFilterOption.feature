@Outbound @Regression
Feature: Testing of Outbound Summary Filter Option functionality

  Scenario: Checking Filtering Start and End Date
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    And Validates Outbound Order Summary dates
    Then Filling start date "01/01/2022" and end date "01/31/2022" on Outbound Order Summary page
    And Validates Outbound Order Summary start date "01/01/2022" and end date "01/31/2022"

  Scenario: Checking Filtering Enter Order Data
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    And Validates Outbound Order Summary dates
    Then Filling start date "02/01/2022" and end date "02/28/2022" on Outbound Order Summary page
    And Searches for order "S00001545" on Outbound Order Summary page
    And Validates Outbound Order Summary grid with order "S00001545"
    And User searches for Order that does not exist in DB on Outbound Order Summary page
    And Validates No Record Outbound Order Summary grid

  Scenario: Checking Filtering Get Status
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    Then User clicks All Status button on Outbound Order Summary page
    And Validates Cancelled status
    And Validates Open status
    And Validates Closed status
    And Validates Shipment In Progress status
    And Filling start date "01/01/2019" and end date "01/01/2022" on Outbound Order Summary page
    And Select Outbound Order Open status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order Status is Open
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Closed status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order Status is Closed
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Cancelled status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order Status is Cancelled
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Shipment In Progress status
    And Validates Items Count on Outbound Order Summary page
    And Select Outbound Order Open status
    And Select Order checkbox with index 0 on Outbound Order Summary page
    And Select Order checkbox with index 1 on Outbound Order Summary page
    And Selecting Outbound Order Release option on Outbound Order Summary page
    And Validates popup Release assignment title on Outbound Order Summary page
    And Click Cancel button on Outbound Order Summary page

  Scenario: Checking Filtering Account Index Search
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    Then Validates Account Field contains "Enter a account" text
    And Enter Account "00" on Outbound Order Summary page
    And Validates Account dropdown value "001001"
    And Filling start date "03/23/2021" and end date "01/01/2022" on Outbound Order Summary page
    And Clears Enter Account field on Outbound Order Summary page
    And Selects Account "001001" on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Account value "001001" is correct on Outbound Order Summary page
    And Validates Account code "Test Account" is correct on Outbound Order Summary page
    And Click Back button on Outbound Order Summary page
    And Clears Enter Account field on Outbound Order Summary page
    And Selects Account "001001" on Outbound Order Summary page
    And Selects last order on Outbound Order Summary page
    And Validates Account value "001001" is correct on Outbound Order Summary page
    And Validates Account code "Test Account" is correct on Outbound Order Summary page
    And Click Back button on Outbound Order Summary page
    And Click Search account on Outbound Order Summary page
    And Validates Account popup is displayed
    And Click Cancel button on Outbound Order Summary page
    And Clears Account field on Outbound Order Summary page
    And Enter Account "test" on Outbound Order Summary page
    And Validates Account "TEST123" on Outbound Order Summary page
    And Validates Account "TESTCODE" on Outbound Order Summary page
    And Click clear on Outbound Order Summary page
    And Click Search account on Outbound Order Summary page
    And Searches account "test" on Outbound Order Summary page
    And Validates account "test" on Outbound Order Summary page
    And Click Clear account index on Outbound Order Summary page
    And Searches account "->BY CLICKING ASSIGNFF" on Outbound Order Summary page
    And Validates Adjust filter to display data on Outbound Order Summary grid
    And Click Cancel button on Outbound Order Summary page

  Scenario: Checking Filtering Search by door
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    Then Filling start date "01/01/2019" and end date "01/01/2022" on Outbound Order Summary page
    And Validates default "Select door" door dropdown value
    And Selects "DOOR" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR" option
    And Click Back button on Outbound Order Summary page
    And Selects "D1" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "D1" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR01" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR01" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR02" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR02" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR03" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR03" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR04" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR04" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR05" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR05" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR06" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR06" option
    And Click Back button on Outbound Order Summary page

  Scenario: Check Order type functionality
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    And Filling start date "01/01/2017" and end date "01/01/2022" on Outbound Order Summary page
    And User clicks order type dropdown on Outbound Order Summary page
    Then Validates Order types are not empty on Outbound Order Summary page
    And User selects "Customer Order" option dropdown on Outbound Order Summary page
    And Validates orders are found on Outbound Order Summary page
    And User clicks order type dropdown on Outbound Order Summary page
    And User selects "Outbound Transfer" option dropdown on Outbound Order Summary page
    And Validates orders are found on Outbound Order Summary page

  Scenario: Check Get Filter product
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    Then Validates default "Enter a product" product value
    And Validates Outbound Order Summary dates
    And Filling start date "01/01/2019" and end date "01/01/2022" on Outbound Order Summary page
    And Enters Product "219032" on Outbound Order Summary page
    And Validates Product "219032" on Outbound Order Summary page
    And Selects Outbound Order product "219032" on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates product "219032" in order on Outbound Order Summary page
    And Click Back button on Outbound Order Summary page
    And Filling current start date and tomorrow end date on Outbound Order Summary page
    And Selects Outbound Order product "200002" on Outbound Order Summary page
    And Validates No Record Outbound Order Summary grid

  Scenario: Check Get Order Display Grid Data
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    Then Filling start date "01/01/2019" and end date "01/01/2022" on Outbound Order Summary page
    And Select Outbound Order Open status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Open status for order
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Closed status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Closed status for order
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Cancelled status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Cancelled status for order
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Shipment In Progress status
    And Validates Items Count on Outbound Order Summary page
    And Select Outbound Order All Status status
    And Selects "DOOR" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR" option
    And Click Back button on Outbound Order Summary page
    And Selects "D1" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "D1" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR01" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR01" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR02" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR02" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR03" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR03" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR04" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR04" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR05" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR05" option
    And Click Back button on Outbound Order Summary page
    And Selects "DOOR06" door option on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Outbound Order door "DOOR06" option
    And Click Back button on Outbound Order Summary page
    And Selects "Select door" door option on Outbound Order Summary page
    And Validates All Filters Panel is not active on Outbound Order Summary page
    And Validates order columns are displayed on Outbound Order Summary page
    And Select Order checkbox with index 0 on Outbound Order Summary page
    And Validates All Filters Panel is active on Outbound Order Summary page
    And Select Order checkbox with index 0 on Outbound Order Summary page
    And Validates Order Statuses are displayed on Outbound Order Summary page
    And Validates Orders Count is displayed on Outbound Order Summary page

  Scenario: Check Get Order Route Status
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    When Go to Outbound Order page
    And Waits for Outbound Order Summary page to load
    And Validates Outbound Order Summary page is displayed
    Then Filling start date "01/01/2019" and end date "01/01/2022" on Outbound Order Summary page
    And Validates Outbound Order Summary status default value
    And Select Outbound Order Open status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Open status for order
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Closed status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Closed status for order
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Cancelled status
    And Validates orders are found on Outbound Order Summary page
    And Selects first order on Outbound Order Summary page
    And Validates Cancelled status for order
    And Click Back button on Outbound Order Summary page
    And Select Outbound Order Shipment In Progress status
    And Validates Orders Count is displayed on Outbound Order Summary page
    And Select Outbound Order Open status
    And Validates orders are found on Outbound Order Summary page
    And Select Order checkbox with index 0 on Outbound Order Summary page
    And Select Order checkbox with index 1 on Outbound Order Summary page
    And Selecting Outbound Order DOOR option on Outbound Order Summary page
    And Validates popup Assign door title on Outbound Order Summary page
    And Click Cancel button on Outbound Order Summary page