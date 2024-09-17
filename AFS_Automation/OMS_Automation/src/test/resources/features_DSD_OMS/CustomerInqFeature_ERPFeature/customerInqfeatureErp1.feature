Feature: Customer Inq in ERP
  All the scenarios that performs all the scenarios related to Customer inq(ERP)

  Background: For login to application and select Customer inq ERP
    Given User enters URL and is on login page and entered credentials Customer inq ERP
    When User is on Home Page for Customer inq ERP
    Then User navigate to Client side for Customer inq ERP

  @CancelCopy
  Scenario: Test scenario for canceling copy of Customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User clicks on Copy button and popup should display in ERP
    And User should enter required details in ERP Copy popup and user should cancel copy

  @CopyCustomerInq
  Scenario: Test scenario for creating copy of customer inq
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User clicks on Copy button and popup should display in ERP
    And User should enter required details in ERP Copy popup

  @CreateCopyForExistingCustomer
  Scenario: Test scenario for creating copy of customer inq for existing customer
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button in ERP Customer Inq for copy of customer inq
    And User should select customer account# in customer inq in ERP
      |Customer|
    Then User clicks on Copy button and popup should display in ERP
    And User should click on save button to save copy of customer inq in ERP

  @CustomerNameRequiredPopup
  Scenario: Test scenario for creating cancel of customer inq for existing customer
    Given User must be on Client side and select Customer Inq in ERP
    When User should confirm that he is in Customer Inq in ERP
    Then User click on New button to cancel creation of customer inq in ERP
    And User enters value to all the input box in Main page
    And User navigate to AR Rules tab and User enters value to all the input box in AR Rules page
    And User navigate to Credit tab and User enters value to all the input box in Credit page
    And User navigate to Billing Info tab and User enters value to all the input box in Billing Info page
    And User navigate to Marketing tab and User enters value to all the input box in Marketing page
    And User navigate to Pricing tab and User enters value to all the input box in Pricing page
    And User navigate to Order entry tab and User enters value to all the input box in Order entry page
    And User navigate to Shipping tab and User enters value to all the input box in Shipping page
    Then User clicks on Save button without entering customer name in ERP env


