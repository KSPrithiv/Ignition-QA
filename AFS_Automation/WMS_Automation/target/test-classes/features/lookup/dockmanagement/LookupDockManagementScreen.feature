@Lookup @Regression
Feature: Testing of Lookup Dock Management screen functionality

  Scenario: Checking navigation functionality of Lookup Dock Management screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup DockManagement page
    And Waits for Dock Management Lookup page to load
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2022" date from input on Dock Management page
    And User types "11/10/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And User clicks item 1 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 2 on Dock Management page
    And Validates Comments Button is present on Inbound Order Details page
    And Validates Images Button is present on Inbound Order Details page
    And Validates Status, Door and Data on Inbound Order Details page
    And Clicks Route Back button on Inbound Order Details page
    And User clicks Back on Dock Management Summary page
    And User clicks not empty Trailer by index 0 on Dock Management Summary page
    And Validates "Change trailer" popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page
    And User clicks not empty Scheduled by index 0 on Dock Management Summary page
    And Validates Scheduled time popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page
    And Validates Receiving, Shipping, Production are disabled on DockManagement Lookup page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And Validates Receiving, Shipping, Production are enabled on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Production checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And Validates Color Indication labels are correct on DockManagement Lookup page
    And User clicks item 3 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 2 on Dock Management page
    And Validates Comments Button is present on Inbound Order Details page
    And Validates Images Button is present on Inbound Order Details page
    And Validates Status, Door and Data on Inbound Order Details page
    And Clicks Route Back button on Inbound Order Details page
    And User clicks Back on Dock Management Summary page
    And User clicks not empty Scheduled by index 2 on Dock Management Summary page
    And Validates Scheduled time popup is displayed on DockManagement Lookup page
    And User clicks Cancel on Dock Management Summary page

  Scenario: Checking Color Code of Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2021" date from input on Dock Management page
    And User types "11/15/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And Validates Color Indication labels are correct on DockManagement Lookup page

  Scenario: Checking Route/Load/Order of Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2020" date from input on Dock Management page
    And User types "11/15/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And User clicks item 1 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 1 on Dock Management page
    And Waits for Outbound Route Summary page to load
    And Click Back button on Outbound Route Summary page
    And User clicks Dock Mgmt Summary row 2 on Dock Management page
    And Waits for Outbound Route Summary page to load
    And Click Back button on Outbound Route Summary page
    And User clicks Back on Dock Management Summary page
    And User clicks item 8 on Dock Management page
    And User clicks Dock Mgmt Summary row 1 on Dock Management page
    And User waits for Inbound Order Details page to load

  Scenario: Checking Data Filtering of Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2021" date from input on Dock Management page
    And User types "11/15/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And Validates Receiving, Shipping, Production are disabled on DockManagement Lookup page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And Validates Receiving, Shipping, Production are enabled on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Production checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And User clicks Receiving checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Select All checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page
    And User clicks Select All checkbox on Dock Management page
    And User clicks Shipping checkbox on Dock Management page
    And User clicks Production checkbox on Dock Management page
    And Validates DockMgmt Summary Rows are displayed on DockManagement Lookup page

    #issue
  Scenario: Checking Waiting inbound of Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2021" date from input on Dock Management page
    And User types "11/15/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page

  Scenario: Checking Update Schedule Time of Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2020" date from input on Dock Management page
    And User types "11/15/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And User clicks not empty Scheduled by index 0 on Dock Management Summary page
    And Validates Scheduled time popup is displayed on DockManagement Lookup page
    And User types Scheduled date "01/01/2020" on Dock Management Summary page
    And User clicks OK on Dock Management Summary page

  Scenario: Checking Trailer Change of Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2022" date from input on Dock Management page
    And User types "11/15/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And User clicks not empty Trailer by index 0 on Dock Management Summary page
    And Validates "Change trailer" popup is displayed on DockManagement Lookup page
    And User selects trailer "TEST" on Dock Management Summary page
    And User clicks OK on Dock Management Summary page

  Scenario: Checking Navigate to Inbound/Outbound from DockManagement of Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2022" date from input on Dock Management page
    And User types "03/01/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And User clicks item 0 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page
    And User clicks Dock Mgmt Summary row 0 on Dock Management page
    And Validates Comments Button is present on Inbound Order Details page
    And Validates Images Button is present on Inbound Order Details page
    And Validates Status, Door and Data on Inbound Order Details page
    And Clicks Route Back button on Inbound Order Details page
    And Validates Item Details are displayed on DockManagement Lookup page
    And Validates DockManagement Lookup Page dates are displayed on DockManagement Lookup page

  Scenario: Checking Data In Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2022" date from input on Dock Management page
    And User types "03/01/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And Validates DockManagement Lookup Page dates are displayed on DockManagement Lookup page
    And Validates Receiving, Shipping, Production are disabled on DockManagement Lookup page
    And Validates Color Indication labels are correct on DockManagement Lookup page

  Scenario: Checking Navigate to DockManagement Summary of Lookup Dock Management screen
    Given User signs in the application
    When Main page is loaded
    And DockManagement Summary Page is validated
    Then Go to Lookup DockManagement page
    And Validates DockManagement Lookup Page base elements are loaded on DockManagement Lookup page
    And User types "01/01/2022" date from input on Dock Management page
    And User types "03/01/2022" date to input on Dock Management page
    And Validates Inbound and Outbound labels, items are displayed on DockManagement Lookup page
    And User clicks item 0 on Dock Management page
    And Validates Item Details are displayed on DockManagement Lookup page