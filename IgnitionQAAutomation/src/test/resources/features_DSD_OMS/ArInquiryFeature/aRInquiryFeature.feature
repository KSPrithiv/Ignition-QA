Feature: AR Inquiry
  All the scenarios that performs all functionality related to AR Inquiry tab

  Background: For login to application and select AR Inquiry
    Given User enters URL and is on login page and entered credentials for AR Inquiry
    When User is on Home Page for AR Inquiry
    Then User navigate to Client side for AR Inquiry

  @AddfilterSearch
  Scenario: For searching of Invoice number using Add filter button
    Given User must be on Client side and select AR Inquiry
    When User navigated to AR Inquiry validate the page
    And User should select Customer Account#
    Then User search for invoice using Add filter button

  @SearchSearchbar
  Scenario: For searching of Invoice number using search bar
    Given User must be on Client side and select AR Inquiry
    When User navigated to AR Inquiry validate the page
    And User should select Customer Account#
    Then User search for invoice using Search bar

  @AddPayment
  Scenario: To add new payment method
    Given User must be on Client side and select AR Inquiry
    When User navigated to AR Inquiry validate the page
    And User should select Customer Account#
    Then User should select Invoice check box
    And User should click on Post button and navigated to PostPayment page
    Then User should click on Add payment button and add details of payment method
      |Divya | AR | Checking - Personal |
    Then User should select Add payment method and then user click on Post button

  @PostInvoice
  Scenario: For Posting Invoice
    Given User must be on Client side and select AR Inquiry
    When User navigated to AR Inquiry validate the page
    And User should select Customer Account#
    Then User should select Invoice check box
    And User should click on Post button and navigated to PostPayment page
    Then User should select Add payment method and then user click on Post button

  @CancelInvoicePost
  Scenario: To cancel Posting invoice
    Given User must be on Client side and select AR Inquiry
    When User navigated to AR Inquiry validate the page
    And User should select Customer Account#
    Then User should select Invoice check box
    And User should click on Post button and navigated to PostPayment page
    Then User should select Add payment method and then user click on Cancel button
