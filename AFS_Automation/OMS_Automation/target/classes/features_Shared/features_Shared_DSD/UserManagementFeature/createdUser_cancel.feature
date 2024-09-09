Feature: Create the User and cancel

  @CreateUserandCancel
  Scenario: Provide all data to create a new User and Cancel it
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    #Then User navigate to Client side for User Management and select user Management tab
    And User is on User Management Frame
    Then CompanyAdmin cancels the newly created User details
