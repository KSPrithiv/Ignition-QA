@Setup @Regression
Feature: SetupWarehouse

  Scenario: Verify Search field on DockDoorGroup screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Warehouse
    And  Click on Search field on DockDoorGroup Page
    Then Verify Search functionalities2
    And  Verify remove icon2
    And  Verify Search functionality with non existing search keyword2