Feature: Order control list1
  Used for cration of order for OCL, searching etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OCL
    When User is on Home Page for OCL
    Then User navigate to Client side for OCL
    Then User should select Order Entry tab for OCL

  @SearchByRoute
  Scenario: Test scenario to search based on Route_No in Route input box
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order traker from drop down
    And Change the delivery date 4 days after current date
    And User clicks on All radio button
    Then User enters Route# in Route search input box and count number of rows in OCL grid

  @CommentCustomerLevel
  Scenario: Test scenario for adding comment at customer level
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order traker from drop down
    And Change the delivery date 4 days after current date
    And User clicks on All radio button
    Then User should find the customer to whome comment has to be added and click on Comment icon
    Then Add note in popup
      |Testing for Notes at customer level_OCL|
    And User should select the Alert Type and Alert location to display notes
      |Both|Customer master|Order entry|
    Then Click on Save button
    And User should click on comment icon in OCL and verify customer note

  @CopyingCustomerNoteInOCL
  Scenario: Creating copy of customer note
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order traker from drop down
    And Change the delivery date 4 days after current date
    And User clicks on All radio button
    Then User should find the customer to whome comment has to be added and click on Comment icon
    And Read all the Notes in Customer note grid and select one note
      |Testing for Notes at customer level_OCL|
    And Click on Copy button in Note grid
    Then Click on Save button

  @DeleteCustomerNoteInOCL
  Scenario: Delet Customer note
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order traker from drop down
    And Change the delivery date 4 days after current date
    And User clicks on All radio button
    Then User should find the customer to whome comment has to be added and click on Comment icon
    And Read all the Notes in Customer note grid and select one note for Deleting
      |Testing for Notes at customer level_OCL|
    Then Click on Ok button

  @ResetCustomerNoteInOCL
  Scenario: Test scenario for adding comment at customer level and resetting the customer note
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order traker from drop down
    And Change the delivery date 4 days after current date
    And User clicks on All radio button
    Then User should find the customer to whome comment has to be added and click on Comment icon
    And Read all the Notes in Customer note grid and select one note
      |Testing for Notes at customer level_OCL|
    Then Click on Reset button and Click on Ok button
    And User should click on comment icon in OCL and verify customer note

  @RefreshInOCL
  Scenario: Test scenario for refreshing OCL, we can see the difference only when any other user is generating data in OCL
    Given User must be on Order Entry Page to select OCL
    And User should navigate to OCL
    Then User should select Order traker from drop down
    And Change the delivery date 4 days after current date
    Then the application should display all the account number in the grid in OCL

