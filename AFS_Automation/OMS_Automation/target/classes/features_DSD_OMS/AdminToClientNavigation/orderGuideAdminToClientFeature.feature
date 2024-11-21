Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order guide test scenario

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