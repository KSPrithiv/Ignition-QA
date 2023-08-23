@Setup @Regression
Feature: SetupSystem

  Scenario: Verify Search field on LabelRule screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and System
    And  Click on Search field on LabelRule Page
    Then Verify Search functionalities2
    And  Verify remove icon2
    And  Verify Search functionality with non existing search keyword2