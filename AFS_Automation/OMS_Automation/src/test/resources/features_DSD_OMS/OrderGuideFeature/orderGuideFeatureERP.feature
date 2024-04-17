Feature: Order GuideERP
  Used for creation of New OG in different ways, Deleting, Editing etc

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for OG
    When User is on Home Page for OG
    Then User navigate to Client side for OG
    Then User should select Order Entry tab for OG
    Then User selects Account# for OG

  @ReferenceStandardOrder
  Scenario Outline: Test scenario for creating OG using Standard order
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |Standard Order|
    And Check for popup to appear to select sub customer reference for Standard order
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>" and End date
    And User should make sure that customer reference "<OGType>" is same as of selected in OG page
    Then User clicks on Add product button and select Catalog from drop down for price Base OG
      |Catalog|
    And User should select products from catalog popup for Price base
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG        |  OGType                      |
      |StandardOG  | Standard Order               |

  @ReferencePriceGroupDealGroup
  Scenario Outline: Test scenario for creating customer Reference Price group Deal group
    Given User must be on Order Entry Page to select OG
    And User should navigate to OG
    Then User should click on Customer Reference drop down and select type of OG
      |Price group - deal group|
    And Check for popup to appear to select sub customer reference for Price group deal group
    Then User clicks on Create new button and should navigate to New OG page
    Then Then User enters Description "<OG>" and End date
    And User should make sure that customer reference "<OGType>" is same as of selected in OG page
    Then User clicks on Add product button and select Catalog from drop down for price Base OG
      |Catalog|
    And User should select products from catalog popup for Price base
    Then User click on Save button
    And User should navigate back to OG page and verify OG "<OG>"  existence
    And Clear filter to display both active and inactive OG
    Then User enters OG Description "<OG>" in search box and Delete the OG verify same in OG grid
    Examples:
      |  OG            |  OGType                   |
      |PricedealOG  | Price group - deal group  |