Feature: scenarios for admin credentials and client credentials

  Background: For login to application to verify admin settings in client side

  @AdminSecurityDisableSettings
  Scenario Outline: Test scenario for verifing admin security scenario, to disable admin setting and verify in client side
    Given User enters URL and is on login page for admin and client Test scenarios
    When User should land on landing page and verify
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    Then User searches for "<AdminControl1>" "<AdminControl2>" "<AdminControl3>" and disable all of them
    And User logs out from Admin site, logs in to client credentials
    Then User navigate to Client side
    And User navigate to Customer Inq ERP env and Select Customer Account#
      |Customer #|
    #Then User navigate to main tab and verify Primary contact has been non editable
    #Then User should log out from client and login with admin credentials
    #Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    #And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    #And User should enable all disabled admin settings "<AdminControl1>" "<AdminControl2>" "<AdminControl3>"
    Examples:
      |Main menu|Sub menu    | AdminControl1                                                    |  AdminControl2                           |   AdminControl3                               |
      |Security |Permissions | Allow user to only modify contact information in Customer Master.|Allow user to modify Customer Master data.| Allow user to create new Customer Master data.|

  @AdminSecurityEnablingSettings
  Scenario Outline: Test scenario for verifing admin security scenario, to Enable admin setting and verify in client side
    Given User enters URL and is on login page for admin and client Test scenarios
    When User should land on landing page and verify
    Then User Clicks on Permissions by drop down to select Customer Account# for admin security
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>"
    And User should enable all disabled admin settings "<AdminControl1>" "<AdminControl2>" "<AdminControl3>"
    And User logs out from Admin site, logs in to client credentials
    Then User navigate to Client side
    And User navigate to Customer Inq ERP env and Select Customer Account#
      |Customer #|
    Then User navigate to main tab and verify Primary contact has been editable
    Examples:
      |Main menu|Sub menu    | AdminControl1                                                    |  AdminControl2                           |   AdminControl3                               |
      |Security |Permissions | Allow user to only modify contact information in Customer Master.|Allow user to modify Customer Master data.| Allow user to create new Customer Master data.|