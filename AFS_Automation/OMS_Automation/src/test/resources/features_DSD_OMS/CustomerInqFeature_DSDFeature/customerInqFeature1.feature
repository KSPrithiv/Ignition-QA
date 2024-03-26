Feature: Customer Inq
  All the scenarios that performs all the scenarios related to Customer inq

  Background: For login to application and select Customer inq
    Given User enters URL and is on login page and entered credentials Customer inq
    When User is on Home Page for Customer inq
    Then User navigate to Client side for Customer inq

  @CancelCopy
  Scenario: Test scenario for canceling copy of Customer inq
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User clicks on Copy button and popup should display after entering values should cancel copy

  @CopyCustomerInq
  Scenario: Test scenario for creating copy of Customer inq
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User clicks on Copy button and popup should display
    Then User clicks on Save button

  @CreateCopyForExistingCustomer
  Scenario: Test scenario for creating copy of customer inq for existing customer
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button for copy of customer inq
    And User should select customer account# in customer inq
      |Customer|
    Then User clicks on Copy button and popup should display
    And User should click on save button to save copy of customer inq

  @CustomerNameRequiredPopup
  Scenario: Test scenario for Name required popup while saving customer inq details and not entering customer name
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button to cancel creation of customer inq
    And User enters value to all the input box in primary page
    And User navigate to BillTo tab and User enteres the value for all web elements
    And User navigate to Orders tab and User enteres the value for all web elements
      |10.25|500.10|
    And User navigate to Deliveries tab and User enteres the value for all web elements
    And User navigate to Account tab and User enteres the value for all web elements
    And User navigate to Price tab and User enteres the value for all web elements
    And User navigate to Misc.Tax tab and User enteres the value for all web elements
    And User navigate to Dex.Edi tab and User enteres the value for all web elements
    Then User clicks on Save button without entering customer name


