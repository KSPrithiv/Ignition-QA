@Setup @Regression
Feature: TaskGroup

  Scenario: Checking UI verification of Task Group screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Configuration
    And Go to TaskGroup Tab
    And Validate Add is enabled and Edit, Delete are disabled
    And Verify Search field
    And Verify Item found is displayed
    And Verify Add Filter button is displayed


  Scenario: Test Scenario for Creating TaskGroup
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Configuration
    And Go to TaskGroup Tab
    And Click on Add button
    And Creating TaskGroup with unique Code
    And Enter Save

  Scenario: Test Scenario for Deleting TaskGroup
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Configuration
    And Go to TaskGroup Tab
    And Select any Code and click on Delete

  Scenario: Verify Search field on Task Group screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Configuration
    And  Click on Search field on TaskGroup Page
    Then Verify Search functionalities1
    And  Verify remove icon1
    And  Verify Search functionality with non existing search keyword1