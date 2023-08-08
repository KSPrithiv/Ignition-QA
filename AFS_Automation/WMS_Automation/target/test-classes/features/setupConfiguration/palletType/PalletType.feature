@Setup @Regression
Feature: SetupConfiguration

  Scenario: Verify Search field on Pallet Type screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Configuration
    And  Click on Search field on Pallet Type Page
    Then Verify Search functionalities1
    And  Verify remove icon1
    And  Verify Search functionality with non existing search keyword1

  Scenario: Test Scenario for Creating PalletType
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Configuration
    And Go to Pallet Type Tab
    And Click on Add button
    And Creating Pallet with special characters and save
    And Click on Add button
    And Creating Pallet with duplicate code
    And Verify duplicate code message
    And Click on Add button
    And Verify empty code message
    And Click on Add button
    And Verify empty description message

  Scenario: Test Scenario for Deleting JobType
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Configuration
    And Go to Pallet Type Tab
    And Select Code and click on Delete

  Scenario: Verify Add Filter on Pallet screen
    Given User signs in the application
    And   Main page is loaded
    Then  Go to SetupIcon and Configuration
    And   Go to Pallet Type Tab
    And   User clicks Add Filter
    And   User clicks Code filter on Pallet page
    And   User enter Code and click on Apply button
    And   Verify Clear button
    And   User clicks Description filter On Pallet Page
    And   User enter Description and click on Apply button
    And   Verify Clear button
    And   User clicks Move inventory filter on Pallet page
    And   User enter Move inventory and click on Apply button
    And   Verify Clear button
