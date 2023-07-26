Feature: MerchantGateway

  Background: For login to application
    Given User enters URL and is on login page


  @AddMerchant-IGNI-20600
  Scenario: Test scenario for without Saving from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Merchant page
    And User Admin uses SSL from Merchant Gateway Page
    And Click on Logout
    And User clicks Yes on popup


  @AddMerchant-IGNI-20819
  Scenario: Test scenario for Adding new Merchant from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Merchant page
    And User Admin adds new Merchant from Merchant Gateway Page

  @EditMerchant-IGNI-20820
  Scenario: Test scenario for Editing new Merchant from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Merchant page
    And User Admin edit Merchant from Merchant Gateway Page
#    And Click on Logout



  @OverRideMerchant-IGNI-20822
  Scenario: Test scenario for OverRide Merchant from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Merchant page
    And User Admin Override Merchant from Merchant Gateway Page

    @DeleteMerchant-IGNI-20821
  Scenario: Test scenario for Editing new Merchant from General Settings
    When User on login page
    When user enters admin username and password
    Then Admin Page is displayed
    And User Navigates to Merchant page
    And User Admin delete Merchant from Merchant Gateway Page
#    And Click on Logout
