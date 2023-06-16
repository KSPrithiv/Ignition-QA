Feature: Additional customer accounts search

  @Additional_customer_accounts_search
  Scenario: Search customers from Additional customer accounts
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    And User is on My Account Frame
    And User is on Additional customer accounts
    And user clears and clicks customer account search box
    And user fetches the account number in the account details table
    And user validates Grid should display customer account no
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page