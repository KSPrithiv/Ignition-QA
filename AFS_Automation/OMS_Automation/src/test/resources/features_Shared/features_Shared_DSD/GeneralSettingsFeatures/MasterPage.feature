Feature: MasterPage

  Background: For login to application
    Given User enters URL and is on login page


  @MasterPageFilter-IGNI-16896
  Scenario: Test scenario for Master Page filter from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Master page
    And User filters from Available Apps


  @SaveApplicationMenu-IGNI-16918
  Scenario: Test scenario for Master Page filter from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Master page
    And User changes on Application menu
#    And Click on Logout



