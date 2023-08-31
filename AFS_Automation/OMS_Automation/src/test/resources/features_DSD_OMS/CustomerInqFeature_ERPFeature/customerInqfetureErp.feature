Feature: Customer Inq in ERP
  All the scenarios that performs all the scenarios related to Customer inq(ERP)

  Background: For login to application and select Customer inq ERP
    Given User enters URL and is on login page and entered credentials Customer inq ERP
    When User is on Home Page for Customer inq ERP
    Then User navigate to Client side for Customer inq ERP

  @MainCustInq
  Scenario: Test scenario for creating new Main details, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    And User enters value to all the input box in Main page

  @ARRules
  Scenario: Test scenario for creating new AR Rule details, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    And User navigate to AR Rules tab and User enters value to all the input box in AR Rules page

  @Credit
  Scenario: Test scenario for entering values for Credit, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    And User navigate to Credit tab and User enters value to all the input box in Credit page

  @BillingInfo
  Scenario: Test scenario for entering values for Billing info, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    And User navigate to Billing Info tab and User enters value to all the input box in Billing Info page

  @Marketing
  Scenario: Test scenario for entering values for Billing info, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    And User navigate to Marketing tab and User enters value to all the input box in Marketing page

  @Pricing
  Scenario: Test scenario for entering values for Billing info, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    And User navigate to Pricing tab and User enters value to all the input box in Pricing page

  @OrderEntry
  Scenario: Test scenario for entering values for Order Entry, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    And User navigate to Order entry tab and User enters value to all the input box in Order entry page

  @Shipping
  Scenario: Test scenario for entering values for Shipping, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    And User navigate to Shipping tab and User enters value to all the input box in Shipping page

  @Ignition
  Scenario: Test scenario for entering values for Ignition, before that save all the values entered under all tabs, in Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    Then User clicks on Save button before adding values to ignition
    And User navigate to Ignition tab in ERP
    Then User clicks on Create new button and standing PO popup appeared
    And User selects 1 day from current date and 4 day from end date and Select Payment processing
    Then PO has been saved in ERP
    Then User selects time for order time for different days
    And User selects Order taker from drop down
    Then User clicks on Save button

  @MultipleStandingPO
  Scenario: Test scenario for creating multiple Standing PO
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    And User navigate to Ignition tab in ERP
    Then User clicks on Create new button and standing PO popup appeared
    And User selects 5 day from current date and 10 day from end date and Select Payment processing
    Then PO has been saved in ERP
    Then User clicks on Create new button and standing PO popup appeared
    And User selects 11 day from current date and 15 day from end date and Select Payment processing
    Then PO has been saved in ERP

  @EditStandingPO
  Scenario: Test scenario for editing Standing PO
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    And User navigate to Ignition tab in ERP
    Then User enters PO in search box and user should make sure that PO details displayed in grid
    And User should be able to select the PO details and edit end date as 16 days
    Then User changes PO value
    Then User clears search bar in ignition tab

  @DeleteStandingPO
  Scenario: Test scenario for Deleting Standing PO
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    And User navigate to Ignition tab in ERP
    Then User selects Standing PO# from the grid and click Delete in ERP

  @CopyCustomerInq
  Scenario: Test scenario for creating copy of customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User clicks on Copy button and popup should display in ERP
    And User should enter required details in ERP Copy popup

  @AddNote
  Scenario: Test scenario for adding note to customer inq (ERP)
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq
    Then Add note in popup in ERP cust inq
      |Testing for Notes at Customer inq|
    And User should select the Alert Type and Alert location to display notes in ERP cust inq
      |Both|Customer master|Order entry|
    Then Click on Save button in ERP cust inq

  @LogoutCompetitorPricing
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page