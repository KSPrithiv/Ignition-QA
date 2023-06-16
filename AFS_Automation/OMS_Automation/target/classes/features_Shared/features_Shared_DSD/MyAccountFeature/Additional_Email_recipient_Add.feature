Feature: Additional Email recipient Add

    @Additional_Email_recipient_Add
    Scenario: Provide all data to add Additional Email recipient
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    And User is on My Account Frame
    And User is on Additional email recipients Frame
    And User enters Email Address to add Additional email recipients
    And User is on Additional email recipients Frame
    #And users adds the Email Address for Additional email recipients
    #And User selects table content of first row and validate email address is added
    And users deletes the Email Address for Additional email recipients
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page