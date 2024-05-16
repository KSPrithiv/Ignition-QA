Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @AutoPopulateCustomerAccountEnabled
  Scenario Outline: Test scenario for enabling Auto populate next available customer number when creating new or copy customers
    Given User should verify admin setting "<Setting>" is enabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    And User must be on Client side and select Customer Inq in ERP for admin setting
    Then User should verify customer account# default value
    Examples:
      |          Key                                   |  Setting                                                                         |
      | CPIncludeAutomaticallyPopulateCustomerNo       | Auto populate next available customer number when creating new or copy customers |

  @AutoPopulateCustomerAccountDisable
  Scenario Outline: Test scenario for disabling Auto populate next available customer number when creating new or copy customers
    Given User should verify admin setting "<Setting>" is disabled by using "<Key>"
    Then User enters URL and is on login page and entered credentials for admin setting
    When User is on Home Page
    Then User navigate to Client side
    And User must be on Client side and select Customer Inq in ERP for admin setting
    Then User should verify customer account# is empty
    Examples:
      |          Key                                   |  Setting                                                                         |
      | CPIncludeAutomaticallyPopulateCustomerNo       | Auto populate next available customer number when creating new or copy customers |

