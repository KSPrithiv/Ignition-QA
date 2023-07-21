Feature: Manage Registration and Cancel

  @ManageRegistrationandCancel
  Scenario: Manage by Updating the information of registered Users
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    And User is on User Management Frame
#    Then CompanyAdmin creates a new User and Register
    Then user is on Manage Registration Frame

    Then select Customer Account with add filter

    Then user is on User index table without Add filter

    Then user has done changes in the manage registration page and updated
      | 341 |
    Then user updates the modified UserInfo
    Then user either deletes the primary account or leave it based on the presence of Primary delete button
    Then user enters the fetched customer account in the account field
    Then user adds the primary account for that sales representative
    Then enters email ID
    Then user adds emailID
    Then user cancels the manage registration page
#    Then user lands on pending registrations page
#    Then select user from the dropdown



