Feature: Order Guide3
  Used for creation of New OG in different ways, Deleting, Editing etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OG
    When User is on Home Page for OG
    Then User navigate to Client side for OG
    Then User should select Order Entry tab for OG
    Then User selects Account# for OG

  @OGDeleteCancel
  Scenario Outline: Test scenario for cancel deleteing of OG
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User enters OG Description "<OG>" in search box and Delete cancel the OG verify same in OG grid
    Examples:
      |  OG   |
      |OGDis16 |

  @OGDelete
  Scenario Outline: Deleting Order guide and verifying it in OG grid
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |All customer accounts #|
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG   |
      |OGDis1 |
      |OGDis14|
      |OGDis16|
      |OGDis17|
      |OGDis18|
      |OGDis19|
      |OGDis20|
      |OGHist |
      |Par OGPar OG|
      |Push OGPush OG|
      |Push OG1Push OG1|
      |AllOrderAllOrder|
      | AllCustomer1   |
      | DayOfWeek      |
      | LocalChain1    |
      | NationalChain1 |
      |MarketOG        |
      |PriceBaseOG     |
      |CustChange      |
    #  | QToOG |
