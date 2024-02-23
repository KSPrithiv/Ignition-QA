Feature: Customer Inq
  All the scenarios that performs all the scenarios related to Customer inq

  Background: For login to application and select Customer inq
    Given User enters URL and is on login page and entered credentials Customer inq
    When User is on Home Page for Customer inq
    Then User navigate to Client side for Customer inq

  @PrimaryCustInq
  Scenario: Test scenario for creating new Primary details, in Customer inq
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    And User enters value to all the input box in primary page

  @BillToCustInq
  Scenario: Test scenario to enter values in BillTo tab webelements
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    And User navigate to BillTo tab and User enteres the value for all web elements

  @OrdersCustInq
  Scenario: Test scenario to enter values in Orders tab webelements
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    And User navigate to Orders tab and User enteres the value for all web elements
        |10.25|500.10|

  @Deliveries
  Scenario: Test scenario to enter values in Orders tab webelements
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    And User navigate to Deliveries tab and User enteres the value for all web elements

  @Account
  Scenario: Test scenario to enter values in Account tab webelements
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    And User navigate to Account tab and User enteres the value for all web elements

  @Price
  Scenario: Test scenario to enter values in Price tab Webelements
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    And User navigate to Price tab and User enteres the value for all web elements

  @Misc/Tax
  Scenario: Test scenario to enter values in Misc.Tax tab Webelements
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    And User navigate to Misc.Tax tab and User enteres the value for all web elements

  @Dex/Edi
  Scenario:  Test scenario to enter values in Dex.Edi tab Webelements
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    And User navigate to Dex.Edi tab and User enteres the value for all web elements

  @Ignition
  Scenario: Test scenario to enter values in Ignition tab Webelements
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    Then User clicks on Save button before adding values to ignition in DSD
    And User navigate to Ignition tab
    Then User clicks on Create new button and standing PO popup appeared
    And User selects 1 day from current date and 4 day from end date and Select Payment processing
    Then PO has been saved
    Then User selects time for order time for different days
    And User selects Order taker from drop down

  @MultiplePO
  Scenario: Test scenario to create multiple PO in Ignition tab
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    And User navigate to Ignition tab
    Then User clicks on Create new button and standing PO popup appeared
    And User selects 5 day from current date and 10 day from end date and Select Payment processing
    Then PO has been saved
    Then User clicks on Create new button and standing PO popup appeared
    And User selects 11 day from current date and 15 day from end date and Select Payment processing
    Then PO has been saved
    #Then User clicks on Save button

  @EditPO
  Scenario: Test scenario to edit PO details in Ignition tab
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User enters Description of customer and load already saved details
    And User navigate to Ignition tab
    Then User enters PO in search box and user should make sure that PO details displayed in grid
    And User should be able to select the PO details and edit end date as 16 days
    Then User changes PO value
    Then User clears search bar in ignition tab
    #Then User clicks on Save button

  @DeleteStandingPO
  Scenario: Test scenario for Deleting Standing PO
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    And User navigate to Ignition tab
    Then User selects Standing PO# from the grid and click Delete
    #Then User clicks on Save button

  @SystemDefaultRealTimeChanges
  Scenario: Test scenario for verifying System default real time changes in Payment processing drop down
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button for copy of customer inq
    And User should select customer account# in customer inq
      |Customer|
    Then User should navigate to Telus tab
    And User click on Payment processing and verify visibility of System default Realtime charge option

  @AddNote
  Scenario: Test scenario for adding note to customer inq in DSD
    Given User must be on Client side and select Customer Inq page
    When User should confirm that he is in Customer Inq page
    Then User click on New button
    Then Add note in popup in cust inq
      |Testing for Notes at Customer inq|
    And User should select the Alert Type and Alert location to display notes in DSD cust inq
      |Both|Customer master|Order entry|
    Then Click on Save button in DSD cust inq
    Then User refreshes customer inq page
    And User should select customer account# in customer inq
      |Customer|
    Then User should click on customer note icon in customer inq page and validate that note added is existing in popup
      |Testing for Notes at Customer inq|
    Then User clicks on Save button






