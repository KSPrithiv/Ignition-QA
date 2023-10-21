@Lookup @Regression
Feature: Testing of Lookup Labels functionality
  Scenario: Checking Unit Label Validation on Lookup Label screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Label page
    And Waits for Label Lookup page to load
    When User clicks Unit label on Lookup Label page
    Then Validates Label Lookup Page base elements are loaded

  Scenario: Checking Location Label Validation on Lookup Label screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Label page
    And Waits for Label Lookup page to load
    When User clicks Location label on Lookup Label page
    Then



