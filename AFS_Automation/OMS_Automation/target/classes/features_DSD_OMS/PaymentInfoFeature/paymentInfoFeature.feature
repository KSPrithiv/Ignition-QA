Feature: Payment Info

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Payment
    When User is on Home Page for Payment
    Then User navigate to Client side for Payment

  @CreatingPaymentInfo
  Scenario: Test scenario for creating new payment method
    Given User should be on Client side page And User should navigate to PaymentInfo tab
    Then User should Click on Add Payment info button and should navigate to new payment info
    Then User enters all the details required to create payment info for Bank account option
    |Divya | AR | Checking - Personal |
    And User clicks on Save button and navigate to Payment Info page



