Feature: My Account Add Payment Info Save

  @MyAccount_AddPaymentInfoSave
  Scenario: My Account Add Payment Info Save
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    And User is on My Account Frame
    And user lands on Payment Page My Account
    And user selects a customer account from the dropdown payment info
    And user selects the resulted customer details from the table
    And user adds the address button for the selected user
    And enters all the fields and saves the page in Payment Info
    And user saves all the entered address fields
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page