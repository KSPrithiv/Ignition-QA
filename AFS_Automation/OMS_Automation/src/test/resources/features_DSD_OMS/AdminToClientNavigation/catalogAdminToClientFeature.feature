Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @CatalogProductsAutomaticLoad
  Scenario Outline: Test scenario for validating Catalog is loading automatically or not
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for Catalog for admin setting
    Then User selects Account# for Catalog for admin setting
    And User should navigate to Catalog tab for admin setting
    Then User verifies whether products are getting loaded automatically or not in catalog enabled setting
    Then User sign out from client side for Admin setting changes
    And User should disable admin setting "<Setting>" using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for Catalog for admin setting
    Then User selects Account# for Catalog for admin setting
    And User should navigate to Catalog tab for admin setting
    Then User verifies whether products are getting loaded automatically or not in catalog disabled setting
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |          Key                    |  Setting                                      |
      | CPCatalogDoNotAutoLoad          | Do not load full catalog search automatically |

