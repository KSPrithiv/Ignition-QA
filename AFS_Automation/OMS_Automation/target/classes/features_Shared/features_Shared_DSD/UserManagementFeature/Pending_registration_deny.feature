Feature: Pending Registration and confirm

  @PendingRegistrationConfirm
  Scenario: Pending Registration of registered Users and Confirm
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    And User is on User Management Frame
    Then user lands on pending registrations page
    Then select user from the dropdown
    Then sales rep denies to activate the user



