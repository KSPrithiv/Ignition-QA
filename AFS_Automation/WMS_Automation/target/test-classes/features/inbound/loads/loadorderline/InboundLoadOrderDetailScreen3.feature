@Inbound @Regression
Feature: Testing of Inbound Load Order Details screen functionality

  Scenario: Verification of Image link on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Clicks Images button on Inbound Load Summary page
    And Validates Images page are displayed on Inbound Load Summary page

  Scenario: Verification of Сomment link on Load Order Details page
    Given User signs in the application
    And Main page is loaded
    
    And Go to Loads page
    And Inbound Load Summary page appears
    When Types start date by index 4 on Inbound Load Summary page
    And Validates loads are present on Inbound Load Summary page
    Then Select Load with index 0 on Inbound Load Summary page
    And Select Load Order with index 0 on Inbound Load Summary page
    And Clicks Comments button on Inbound Load Summary page
    And Validates Edit order popup on Inbound Load Summary page