Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @CustInqStoreDeptVariable
  Scenario Outline: Test scenario for Customer inq, by setting admin "Auto populate next available customer number when creating new or copy customers" with default setting for store as variable
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to Customer inq
    Then User should enable Auto populate next available customer number when creating new or copy customers
    And User should enable Use default Settings for Store Number, variable radio button
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select customer inq tab for admin for variable values, for store and dept
    Examples:
      |Option             |
      |Customer Inquiry   |

  @CustInqStoreDeptFixed
  Scenario Outline: Test scenario for Customer inq, by setting admin "Auto populate next available customer number when creating new or copy customers" with default setting for store as Fixed
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to Customer inq
    Then User should enable Auto populate next available customer number when creating new or copy customers
    And User should enable Use default Settings for Store Number and Dept Number, Fixed radio button
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select customer inq tab for admin for Fixed values, for store and dept
    Examples:
      |Option             |
      |Customer Inquiry   |

  @CustInqStoreDeptManual
  Scenario Outline: Test scenario for Customer inq, by setting admin "Auto populate next available customer number when creating new or copy customers" with default setting for store as Fixed
    Given User enters URL and is on login page and entered credentials for Admin settings
    When User is on Home Page for Admin settings
    Then User Clicks on Permissions by drop down to select Customer Account#s
    And User should enter menu "<Option>" in search bar to navigate to Customer inq
    Then User should disable Auto populate next available customer number when creating new or copy customers
    And User should enable Use default Settings for Store Number and Dept Number, Manual radio button
    And User should save all the details
    And User logs out from Admin site, logs in to client credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select customer inq tab for admin for Manual values, for store and dept
    Examples:
      |Option             |
      |Customer Inquiry   |