Feature: Email

  Background: For login to application
    Given User enters URL and is on login page

  @TestEmail-IGNI-21243
  Scenario: Test scenario for sending test emails from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Emails page
    And User Sends Test Email from Emails Page

  @TestEmailEnabled-IGNI-21244
  Scenario: Test scenario for sending test emails from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User enabled Email Template from Emails Page

  @TestEmailDisabledCheck-IGNI-21245
  Scenario: Test scenario for sending test emails from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User disabled Email Template from Emails Page


  @EmailBodyChecks-IGNI-21246,21257,21258,21259,16289
  Scenario: Test scenario for changing test email body from General Settings
    Given User enters URL and is on login page
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User selects Email Template from Emails Page
   And User checks for Default & Delete Custom e-mail button
    And User Changes in email Body
    And User clicks on delete Custom e-mail button
    And User clicks on reset to Default

  @EmailRestoreToCompanyDefaultRole-IGNI-16290
  Scenario: Test scenario for changing test email body from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And Regular User selects Email Template from Emails Page
    And User Changes in email Body
    And User clicks on reset to Default

