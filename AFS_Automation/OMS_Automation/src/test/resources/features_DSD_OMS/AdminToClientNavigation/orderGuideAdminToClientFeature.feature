Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order guide test scenario

  @CustomerAccountReferenceNotDisplayed
  Scenario Outline: Test case for Displaying customer Account index and Customer account reference is not displaying
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User should navigate to Order Guide tab for admin setting
    And User should validate that customer account# index and customer reference is not visible
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                               |          Key                             |
      | Grouping by customer reference         | CPOrderGuidesEnableCustomerRefGrouping   |

  @CustomerAccountReferenceDisplay
  Scenario Outline: Test case for Displaying customer Account index and Customer account reference is displaying
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User should navigate to Order Guide tab for admin setting
    And User should validate that customer account# index and customer reference is visible
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                               |          Key                             |
      | Grouping by customer reference         | CPOrderGuidesEnableCustomerRefGrouping   |

  @CatalogDonotAutoLoadEnableGridView
  Scenario Outline: Test scenario for enable auto loading of products in catalog dialog box, in grid view
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to catalog search
    Then User should select "<CatalogSearchLayout>" in Catalog search layout and enable Do not load full catalog automatically
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User should navigate to Order Guide tab for admin setting
    Then User clicks on Create new button and should navigate to New OG page
#    Then User enters Description "<OG>" Start date 8 and End date 9 day from current date
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should verify products are not auto loaded select Product from catalog
    Examples:
      |Option             |   CatalogSearchLayout |
      |Catalog Search     |    Grid layout        |

  @CatalogDonotAutoLoadDisableGridView
  Scenario Outline: Test scenario for disable auto loading of products in catalog dialog box, in grid view
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to catalog search
    Then User should select "<CatalogSearchLayout>" in Catalog search layout and disable Do not load full catalog automatically
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User should navigate to Order Guide tab for admin setting
    Then User clicks on Create new button and should navigate to New OG page
#    Then User enters Description "<OG>" Start date 8 and End date 9 day from current date
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should verify products are auto loaded select Product from catalog
    Examples:
      |Option             |   CatalogSearchLayout |
      |Catalog Search     |    Grid layout        |

  @CatalogDonotAutoLoadEnableCardView
  Scenario Outline: Test scenario for enable auto loading of products in catalog dialog box, in card view
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to catalog search
    Then User should select "<CatalogSearchLayout>" in Catalog search layout and enable Do not load full catalog automatically
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User should navigate to Order Guide tab for admin setting
    Then User clicks on Create new button and should navigate to New OG page
#    Then User enters Description "<OG>" Start date 8 and End date 9 day from current date
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should verify products are not auto loaded select Product from catalog
    Examples:
      |Option             |   CatalogSearchLayout |
      |Catalog Search     |    Card layout        |

  @CatalogDonotAutoLoadDisableCardView
  Scenario Outline: Test scenario for disable auto loading of products in catalog dialog box, in card view
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to catalog search
    Then User should select "<CatalogSearchLayout>" in Catalog search layout and disable Do not load full catalog automatically
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting
    Then User should navigate to Order Guide tab for admin setting
    Then User clicks on Create new button and should navigate to New OG page
#    Then User enters Description "<OG>" Start date 8 and End date 9 day from current date
    Then User clicks on Add product button and select Catalog from drop down
      |Catalog|
    And User should verify products are auto loaded select Product from catalog
    Examples:
      |Option             |   CatalogSearchLayout |
      |Catalog Search     |    Card layout        |
