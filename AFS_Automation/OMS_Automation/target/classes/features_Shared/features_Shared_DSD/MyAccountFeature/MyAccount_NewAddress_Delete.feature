Feature: My Account NewAddress Edit

  @MyAccount_NewAddress_Edit
  Scenario: My Account NewAddress Edit
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    And User is on My Account Frame
    And user lands on New Address Page
    And user selects a customer account from the dropdown
    And user selects the resulted customer details from the table
    And user deletes the customer details from the table
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page