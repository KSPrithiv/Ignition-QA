Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

    @InventoryCatalogDisabled
    Scenario Outline: Test scenario for validating Catalog is loading automatically or not
      #Given User enters URL and is on login page for admin and client Test scenarios
      #When User should land on landing page and verify
      #Then User Clicks on Permissions by drop down to select Customer Account# for admin security
      #And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
      #Then User should enable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
      #And User logs out from Admin site, logs in to client credentials
      #Then User navigate to Client side
      #Then User should select Order Entry tab for Inventory
      #Then User selects Account# for Inventory
      #And User should navigate to Inventory tab
      #And User should click on Add product button and validate automatic load of products in product dialog box
      #Then User sign out from client side and sign in to admin side
      #Then User Clicks on Permissions by drop down to select Customer Account# for admin security
      #And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
      #Then User should disable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"

      Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
      Then User enters URL and is on login page and entered credentials for admin setting
      When User is on Home Page
      Then User navigate to Client side
      Then User should select Order Entry tab for Inventory for admin setting
      Then User selects Account# for Inventory for admin setting
      And User should navigate to Inventory tab for admin setting
      And User should click on Add product button and validate automatic load of products in product dialog box disabled
      Then User sign out from client side for Admin setting changes
      And User should disable admin setting "<Setting>" using "<Key>"
      Examples:
        |  Setting                               |               Key           |
        | Do not load full catalog automatically | CPCatalogSearchDoNotAutoLoad|

    @InventoryCatalogEnabled
    Scenario Outline: Test scenario for enabled admin setting and verifying catalog dialog box is loaded with products
      Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
      Then User enters URL and is on login page and entered credentials for admin setting
      When User is on Home Page
      Then User navigate to Client side
      Then User should select Order Entry tab for Inventory for admin setting
      Then User selects Account# for Inventory for admin setting
      And User should navigate to Inventory tab for admin setting
      And User should click on Add product button and validate automatic load of products in product dialog box enabled
      Then User sign out from client side for Admin setting changes
      And User should set admin setting "<Setting>" "<Key>" as default before making changes
      Examples:
        |  Setting                               |               Key           |
        | Do not load full catalog automatically | CPCatalogSearchDoNotAutoLoad|