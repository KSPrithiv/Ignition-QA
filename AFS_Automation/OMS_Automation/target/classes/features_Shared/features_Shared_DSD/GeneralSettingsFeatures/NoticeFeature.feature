Feature: Notice

  Background: For login to application
    Given User enters URL and is on login page


  @NoticeAddFilterStatus&Print-IGNI-7158&IGNI-7114
  Scenario: Test scenario for handling notices from General Settings
    Given User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Notices page
    Then User click on Add Filter with status and click print
    And Click on Logout


  @NoticeAddFilterDescription-IGNI-7147
  Scenario: Test scenario for handling notices from General Settings
    Given User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Notices page
    Then User click on Add Filter with description
    And Click on Logout

  @NoticeAddFilterDestination-IGNI-7131
  Scenario: Test scenario for handling notices from General Settings
    Given User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Notices page
    Then User click on Add Filter with destination
    And Click on Logout

  @NoticeAddFilterStartDate-IGNI-7127
  Scenario: Test scenario for handling notices from General Settings
    Given User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Notices page
    Then User click on Add Filter with Start Date
    And Click on Logout

  @NoticeAddFilterEndDate-IGNI-7130
  Scenario: Test scenario for handling notices from General Settings
    Given User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Notices page
    Then User click on Add Filter with End Date
    And Click on Logout

  @NoticeCreationRoute @IGNI-20814
  Scenario: Test scenario for creating notices Route from General Settings
    Given User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Notices page
    Then User click on Add Notice and Select Destination with StartEnd Dates
    And User enters Mandatory fields for Create Notice
    And User enter route recipient & click on Create Notice

  @NoticeCreationBranch @IGNI-21265
  Scenario: Test scenario for Creating notices Branch from General Settings
    Given User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Notices page
    Then User click on Add Notice and Select Destination with StartEnd Dates
    And User enters Mandatory fields for Create Notice
    And User enter branch recipient & click on Create Notice
    #    And Click on Logout


  @NoticeCreationChain @IGNI-21265
  Scenario: Test scenario for creating notices chain from General Settings
    Given User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Notices page
    Then User click on Add Notice and Select Destination with StartEnd Dates
    And User enters Mandatory fields for Create Notice
    And User enter chain recipient & click on Create Notice
    #    And Click on Logout
