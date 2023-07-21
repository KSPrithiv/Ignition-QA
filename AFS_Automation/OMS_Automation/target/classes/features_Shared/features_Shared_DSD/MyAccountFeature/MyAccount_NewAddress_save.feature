Feature: My Account NewAddress save

  @MyAccount_NewAddress_save
  Scenario: My Account NewAddress save
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    And User is on My Account Frame
    And User expands the My account and its associated frames by shrinking hamburger
    And user lands on New Address Page
    And user selects a customer account from the dropdown
    And user selects the resulted customer details from the table
    And user adds the address button for the selected user
    And enters all the fields in the address page and saves the page
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page