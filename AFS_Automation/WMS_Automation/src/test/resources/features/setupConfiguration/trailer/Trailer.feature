@Setup @Regression
Feature: SetupConfiguration

  Scenario: Verify Search field on Trailer screen
    Given User signs in the application
    When Main page is loaded
    Then Go to SetupIcon and Configuration
    And  Click on Search field on Trailer Page
    Then Verify Search functionalities1
    And  Verify remove icon1
    And  Verify Search functionality with non existing search keyword1