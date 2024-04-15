Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @AdminSecurityDisableSettings
  Scenario Outline: Test scenario for verifying admin security scenario, to disable admin setting and verify in client side
    Given User enters URL and is on login page for admin and client Test scenarios
    When User should land on landing page and verify
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User drag and drop menu tab option in Admin setting
      #And User should enable all disabled admin settings "<AdminControl1>"
    And User logs out from Admin site, logs in to client credentials
    Then User navigate to Client side
    Then User should select Order Entry tab for admin
    Then User selects Account# for Admin side setting



    Examples:
      |Main menu    |Sub menu    |
      |Web ordering |Navigation  |

