@Lookup @Regression
Feature: Testing of Lookup Labels functionality
  Scenario: Checking Unit Label Validation on Lookup Label screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Label page
    And Waits for Label Lookup page to load
    When User clicks Unit label on Lookup Label page
    Then Validates Unit popup base elements are loaded for Label Lookup Page

  Scenario: Checking Location Label Validation on Lookup Label screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Label page
    And Waits for Label Lookup page to load
    When User clicks Location label on Lookup Label page
    Then Validates Location popup base elements are loaded for Label Lookup Page
    And User clicks From Location button on Lookup Label page
    And User Cancel button on Lookup Label page
    And User clicks To Location button on Lookup Label page
    And User Cancel button on Lookup Label page
    And User clicks Print Label Print button on Lookup Label page

  Scenario: Checking Receiving Unit Label Validation on Lookup Label screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Label page
    And Waits for Label Lookup page to load
    When User clicks Receiving Unit label on Lookup Label page
    Then Validates Receiving Unit popup base elements are loaded for Label Lookup Page

  Scenario: Checking Product Label Validation on Lookup Label screen
    Given User signs in the application
    And Main page is loaded
    And DockManagement Summary Page is validated
    And Go to Lookup Label page
    And Waits for Label Lookup page to load
    When User clicks Product label on Lookup Label page
    Then Validates Product popup base elements are loaded for Label Lookup Page