Feature: Order Guide3
  Used for creation of New OG in different ways, Deleting, Editing etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OG
    When User is on Home Page for OG
    Then User navigate to Client side for OG
    Then User should select Order Entry tab for OG
    Then User selects Account# for OG

  @OGDeleteCancel
  Scenario Outline: Test scenario for cancel deleting of OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User clicks on Create new button and should navigate to New OG page
    #Then User enters Description "<OG>" Start date 1 and End date 2 day from current date
    Then Then User enters Description "<OG>"
    And User selects Day of week from drop down
    And User enters Quick Product number and Sequence number
      |4|
    Then User click on Save button
    Then User enters OG Description "<OG>" in search box and Delete cancel the OG verify same in OG grid
    Examples:
      |  OG   |
      |OGDeleteCancel |

  @OGDelete
  Scenario Outline: Deleting Order guide and verifying it in OG grid
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG            |
      | OGDeleteCancel |
