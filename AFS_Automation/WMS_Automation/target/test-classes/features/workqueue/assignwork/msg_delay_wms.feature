
Feature: JIRA

  Scenario: JIRA scenario

    Given User signs in the application JIRA
    Then user navigates to issues that results waterfall options
    Then user clicks on import issues from CSV option
    Then user chooses file to upload the JIRA ticket in CSV format
    Then user goes to next wizard by clicking next button
    Then user selects the project to which the ticket will be exported and mapped
    Then user goes to next wizard by clicking next button
