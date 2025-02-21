Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @EnableAllProductFilter
  Scenario Outline: Test scenario for validating display of All product drop down filter
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for Catalog for admin setting
    Then User selects Account# for Catalog for admin setting
    And User should navigate to Catalog tab for admin setting
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User should verify whether All Product drop down is displayed
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |          Key                       |  Setting                                      |
      | CPEnableProductTypeFilter          | Product Type filter                           |

  @DisableAllProductFilter
  Scenario Outline: Test scenario for validating display of All product drop down filter
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for Catalog for admin setting
    Then User selects Account# for Catalog for admin setting
    And User should navigate to Catalog tab for admin setting
    And User should click on Reset filter button and all the products should displayed in Card view in Catalog page
    Then User should verify whether All Product drop down is not displayed
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |          Key                       |  Setting                                      |
      | CPEnableProductTypeFilter          | Product Type filter                           |
