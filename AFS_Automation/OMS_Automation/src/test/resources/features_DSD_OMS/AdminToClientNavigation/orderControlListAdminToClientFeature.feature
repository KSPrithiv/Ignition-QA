Feature: scenarios for admin credentials and client credentials

Background: For login to application to verify admin settings in client side

  @SkipReasonCode
  Scenario Outline: Test scenario for verifying admin setting for OCL, For skip reason enable and disable
     Given User enters URL and is on login page for admin and client Test scenarios
     When User should land on landing page and verify
     Then User Clicks on Permissions by drop down to select Customer Account# for admin security
     And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
     Then User should disable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
     And User logs out from Admin site, logs in to client credentials
     Then User navigate to Client side
     And User should navigate to OCL for admin setting
     Then User should select Order taker from drop down
     And Change the delivery date 2 days after current date
     Then User Clicks on Untaken radio button
     Then User select OCL which is not skipped
     And User Clicks on Skip button
     Then User Clicks on Taken radio button
     And User verifies existence of customer account for which skip is enabled, exists under taken
     Then User sign out from client side and sign in to admin side
     Then User Clicks on Permissions by drop down to select Customer Account# for admin security
     And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
     Then User should enable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
     Examples:
      |Main menu    |Sub menu          |  Setting                 | Identifier   |  IdentifierForSetting |
      |Web Ordering |Order Control List| Require skip reason code |     id       | CPOCLRequireSkipReason|

  @CallDesk
  Scenario Outline: Test scenario for verifying call desk existance
     Given User enters URL and is on login page for admin and client Test scenarios
     When User should land on landing page and verify
     Then User Clicks on Permissions by drop down to select Customer Account# for admin security
     And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
     Then User should disable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
     And User logs out from Admin site, logs in to client credentials
     Then User navigate to Client side
     And User should navigate to OCL for admin setting
     Then User validates existence of call desk input box for not displaying
     Then User sign out from client side and sign in to admin side
     Then User Clicks on Permissions by drop down to select Customer Account# for admin security
     And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
     Then User should enable "<Setting>" in admin side by using "<Identifier>", "<IdentifierForSetting>"
     Examples:
        |Main menu    |Sub menu          |  Setting            | Identifier   |  IdentifierForSetting |
        |Web Ordering |Order Control List| Call desk field     |     id       | CPEnableOCLCallDeskField|
