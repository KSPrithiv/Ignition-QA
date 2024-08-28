Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side, For Order entry test scenario

  @DisablingSalesHelp
  Scenario Outline: Test scenario for verifying functionality of Non Presence of Sales help
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for sales help
    Then User navigate to Client side for sales help
    Then User should select Order Entry tab for sales help
    And User click on Question mark and should validate no sales help option displayed
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                      |          Key                         |
      | For disabling Sales help      | CPMasterNotificationsSalesHelp       |

  @DisablingCommerceHelp
  Scenario Outline: Test scenario for verifying functionality of Non Presence of eCommerce
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for sales help
    Then User navigate to Client side for sales help
    Then User should select Order Entry tab for sales help
    And User click on Question mark and should validate no ecomerce help option displayed
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                          |          Key                         |
      | For disabling eCommerce help      | CPMasterNotificationsHelp            |

  @SalesHelp
  Scenario Outline: Test scenario for handling Sales help from drop down
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for sales help
    Then User navigate to Client side for sales help
    Then User should select Order Entry tab for sales help
    And User click on Question mark and selects Sales help option
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                      |          Key                         |
      | For disabling Sales help      | CPMasterNotificationsSalesHelp       |

  @SalesHelpDisable
  Scenario Outline: Test scenario for handling Sales help from drop down is disabled
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for sales help
    Then User navigate to Client side for sales help
    Then User should select Order Entry tab for sales help
    And User click on Question mark and selects Sales help option and check for non existance
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      |  Setting                      |          Key                         |
      | For disabling Sales help      | CPMasterNotificationsSalesHelp       |

  @eCommerceHelp
  Scenario Outline: Test scenario for handling eCommerce drop down
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for sales help
    Then User navigate to Client side for eCommerce help
    Then User should select Order Entry tab for eCommerce help
    And User click on Question mark and selects ecommerce option
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      | Setting                      | Key                       |
      | For disabling eCommerce help | CPMasterNotificationsHelp |

  @eCommerceHelpDisable
  Scenario Outline: Test scenario for handling eCommerce drop down when admin setting is disabled
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    When User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page for sales help
    Then User navigate to Client side for eCommerce help
    Then User should select Order Entry tab for eCommerce help
    And User click on Question mark and selects ecommerce option and check for non existance
    Then User sign out from client side for Admin setting changes
    And User should set admin setting "<Setting>" "<Key>" as default before making changes
    Examples:
      | Setting                      | Key                       |
      | For disabling eCommerce help | CPMasterNotificationsHelp |

  @RegisterHereEnabled
  Scenario Outline: Test scenario for verifying Register here enabled
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>" in common and company
    When User enters URL and is on login page for admin setting
    And Verify Register here link is visible in login page
    #And User should set admin setting "<Setting>" "<Key>" as default before making changes in common and company
    Examples:
      | Setting               | Key                       |
      | Registration message  | CPEnableUserRegistration  |

  @EnableCustomerRegistration
  Scenario Outline: Test scenario for verifying functioning of "Enable new customer registration from login page" taggle button is enabled
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>" in common and company
    When User enters URL and is on login page for admin setting
    Then User click on Register here button, and verify check box
    And User should set admin setting "<Setting>" "<Key>" as default before making changes in common and company
    Examples:
      | Setting                                         | Key                          |
      | Enable new customer registration from login page|CPEnableCustomerRegistration  |

  @DisableCustomerRegistration
  Scenario Outline: Test scenario for verifying functioning of "Enable new customer registration from login page" taggle button is disabled
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>" in common and company
    When User enters URL and is on login page for admin setting
    Then User click on Register here button, and verify check box is not displayed
    And User should set admin setting "<Setting>" "<Key>" as default before making changes in common and company
    Examples:
      | Setting                                         | Key                          |
      | Enable new customer registration from login page|CPEnableCustomerRegistration  |

  @RegisterHereDisable
  Scenario Outline: Test scenario for verifying Register here is disabled
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>" in common and company
    When User enters URL and is on login page for admin setting
    And Verify Register here link is non visible in login page
    And User should set admin setting "<Setting>" "<Key>" as default before making changes in common and company
    Examples:
      | Setting               | Key                       |
      | Registration message  |  CPEnableUserRegistration |

