Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

    @InventoryCatalog
    Scenario Outline: Test scenario for validating Catalog is loading automatically or not
      Given User enters URL and is on login page for admin and client Test scenarios
      When User should land on landing page and verify
      Then User Clicks on Permissions by drop down to select Customer Account# for admin security
      And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
      Then User should enable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
      And User logs out from Admin site, logs in to client credentials
      Then User navigate to Client side
      Then User should select Order Entry tab for Inventory
      Then User selects Account# for Inventory
      And User should navigate to Inventory tab
      And User should click on Add product button and validate automatic load of products in product dialog box
      Then User sign out from client side and sign in to admin side
      Then User Clicks on Permissions by drop down to select Customer Account# for admin security
      And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
      Then User should disable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
      Examples:
        |Main menu    |Sub menu          |  Setting                               | Identifier   |  IdentifierForSetting       |
        |Web Ordering |Catalog Search    | Do not load full catalog automatically |     id       | CPCatalogSearchDoNotAutoLoad|