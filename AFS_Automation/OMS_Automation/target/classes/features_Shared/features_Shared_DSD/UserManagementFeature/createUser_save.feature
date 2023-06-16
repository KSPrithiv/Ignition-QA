Feature: Create User and Save

    @CreateUserandSave
    Scenario: Provide all data to create a new User and Save it
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    #Then User navigate to Client side for User Management and select user Management tab
    And User is on User Management Frame
    Then CompanyAdmin creates a new User and Register