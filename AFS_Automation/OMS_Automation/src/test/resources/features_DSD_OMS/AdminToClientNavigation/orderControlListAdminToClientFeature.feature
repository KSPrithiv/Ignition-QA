Feature: scenarios for admin credentials and client credentials

Background: For login to application to verify admin settings in client side

  @SkipReasonCode
  Scenario Outline: Test scenario for verifying admin setting for OCL, For skip reason enable and disable
     Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
     Then User enters URL and is on login page and entered credentials for admin setting
     When User is on Home Page
     Then User navigate to Client side
     Then User should select Order Entry tab for admin
     #Then User selects Account# for Admin side setting
     And User should navigate to OCL tab for admin setting
     Then User should select Order taker from drop down
     And Change the delivery date 2 days after current date
     Then User Clicks on Untaken radio button
     Then User select OCL which is not skipped
     And User Clicks on Skip button
     Then User Clicks on Taken radio button
     And User verifies existence of customer account for which skip is enabled, exists under taken
     Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
     Examples:
     |  Setting                 |  Key                  |
     | Require skip reason code | CPOCLRequireSkipReason|

  @CallDesk
  Scenario Outline: Test scenario for verifying call desk existance
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    #Then User selects Account# for Admin side setting
    And User should navigate to OCL tab for admin setting
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User validates existence of call desk input box for not displaying
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
     Examples:
        |  Setting            |  Key                    |
        | Call desk field     | CPEnableOCLCallDeskField|

  @OrderTakerDisableAndPrintButtonVerification
  Scenario Outline: Test scenario for verifying order taker admin setting
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    #Then User selects Account# for Admin side setting
    And User should navigate to OCL tab for admin setting
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User validates that Order taker drop down now displaying
    Then User clicks on Print button and handle the new browser window
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting            |  Key                      |
      | Order taker field   | CPEnableOCLOrderTakerField|

  @OrderTakerEnableVerifyRoute
  Scenario Outline: Test scenario for verifying order taker admin setting and verify route details in client side
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    #Then User selects Account# for Admin side setting
    And User should navigate to OCL tab for admin setting
    Then User validates that Order taker drop down now displaying
    Then User should select Order taker from drop down
    And Change the delivery date 2 days after current date
    Then User enters Route# in Route search input box and count number of rows in OCL grid
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting            |  Key                      |
      |Order taker field    | CPEnableOCLOrderTakerField|

  @OrderTakerDisableVerifyRoute
  Scenario Outline: Test scenario for verifying order taker disabled in admin setting and verify route details in client side
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    #Then User selects Account# for Admin side setting
    And User should navigate to OCL tab for admin setting
    #Then User should select Order taker from drop down
    Then User validates that Order taker drop down not displaying
    And Change the delivery date 2 days after current date
    Then User enters Route# in Route search input box and count number of rows in OCL grid
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting            |  Key                      |
      | Order taker field   | CPEnableOCLOrderTakerField|