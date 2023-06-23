Feature: OMS CRM Tickets Page Verification under Admin portal

  Background: For login to application
    Given User enters correct URL and opened login page

  @CRM_Tickets_VerifyCRMTicketsTabs
  Scenario: TC001  Verify CRM Tickets Tabs Module
    Given  User able to open login page successfully
    When   User entered correct Admin username and password on the page
    Then   Admin Page opened successfully
    And    User click on Hamburger left Menu
    Then   User click on general settings menu
    And    Select Master Page option
    Then   Select and drag any value from Available app and drop inside Application menu
    And    Verify the dragged value is available in Application manu
