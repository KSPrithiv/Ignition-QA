Feature: Additional Email recipient Delete_enabled

  @Additional_Email_recipient_Delete_enabled
  Scenario: Delete Additional Email recipient
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    And User is on My Account Frame
    And User is on Additional email recipients Frame
    And User enters Email Address to add Additional email recipients
    #And users deletes the Email Address for Additional email recipients
    And users validated the delete of the Email Address for Additional email recipients
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page