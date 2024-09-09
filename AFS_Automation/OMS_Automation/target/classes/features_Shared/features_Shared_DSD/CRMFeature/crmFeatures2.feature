Feature: OMS CRM Tickets Page Verification under Client portal

  Background: For login to application
    Given User enters correct URL and opened login page

  @CRM_Tickets_VerifyCRMTickets_Screen_UnderClientPortal
  Scenario: TC015 Client portal Verify CRM Tickets Screen
    When   Enter Client Login credentials and Click on login button
    Then   Client home Page opened successfully
    And    User click on Hamburger left Menu
    Then   Click on settings button above of hamburger
    Then   Select CRM Tickets Module and Validate CRM Tickets page get opened
    And    Also Verify Page should display the list of tickets created

#  @CRM_Tickets_Verify_AddTickets_UnderClientPortal
#  Scenario: TC016 Client portal Verify client is able to Add new CRM Ticket
#    When   User click on the plus button from tickets page to add new ticket
#    Then   New ticket page opened successfully
#    Then   Provide all the mandatory fields and click on save button
#    And    Validate page should navigate back to the main page and new ticket should get created
#    And    Verify new ticket is created with next sequence number

  @CRM_Tickets_Verify_ExportTicketFunctionality_UnderClientPortal
  Scenario: TC018 Client portal Verify Export tickets functionality in CRM Tickets Screen
    When   User on the CRM tickets page verify Export CSV button available on the page
    Then   Click on Export CSV button and verify CSV file should get generated
    Then   Click on logout


  @CRM_Tickets_Validate_Module_Columns_According_To_Admin_Setting
  Scenario: TC019 Verify Admin Module Configuration Matches Client Module Dropdown Values
    Given User logged in as an admin
    When  User click on the Configuration tab under general settings menu
    And   User click on the Module Configuration option
    Then  User should see the following module values:
      | Not Specified  |
      | OMSi           |
      | ERPi           |
      | WMSi           |
      | RE             |
      | Other          |
    Then   Click on logout

    Given   User logged in as a client
    When    User click on the New Ticket option under settings->CRM Tickets
    Then    User should see the following module values in the dropdown:
      | Not Specified  |
      | OMSi           |
      | ERPi           |
      | WMSi           |
      | RE             |
      | Other          |
    Then   Click on logout

    Given   User logged in as an admin
    When    User click on the Configuration tab under general settings menu
    And     User click on the Module Configuration option
    Then    The displayed module values should match the client dropdown values

  @CRM_Tickets_Validate_Type_Columns_According_To_Admin_Setting
  Scenario: TC020 Verify Admin Type Configuration Matches Client Type Dropdown Values
    Given User logged in as an admin
    When  User click on the Configuration tab under general settings menu
    And   User click on the Type Configuration option
    Then  User should see the following type values:
      | Not Specified         |
      | Order management      |
      | Warehouse management  |
      | Broken product        |
    Then   Click on logout

    Given   User logged in as a client
    When    User click on the New Ticket option under settings->CRM Tickets
    Then    User should see the following type values in the dropdown:
      | Not Specified         |
      | Order management      |
      | Warehouse management  |
      | Broken product        |
    Then   Click on logout

    Given   User logged in as an admin
    When    User click on the Configuration tab under general settings menu
    And     User click on the Type Configuration option
    Then    The displayed type values should match the client dropdown values


  @CRM_Tickets_Validate_Reason_Columns_According_To_Admin_Setting
  Scenario: TC021 Verify Admin Reason Configuration Matches Client Type Dropdown Values
    Given User logged in as an admin
    When  User click on the Configuration tab under general settings menu
    And   User click on the Reason Configuration option
    Then  User should see the following reason values:
      | Not Specified                  |
      | Bug                            |
      | Technical assistance required  |
      | Complaint                      |
      | Problem                        |
    Then   Click on logout

    Given   User logged in as a client
    When    User click on the New Ticket option under settings->CRM Tickets
    Then    User should see the following reason values in the dropdown:
      | Not Specified                  |
      | Bug                            |
      | Technical assistance required  |
      | Complaint                      |
      | Problem                        |
    Then   Click on logout

    Given   User logged in as an admin
    When    User click on the Configuration tab under general settings menu
    And     User click on the Reason Configuration option
    Then    The displayed Reason values should match the client dropdown values


  @CRM_Tickets_Validate_Priority_Columns_According_To_Admin_Setting
  Scenario: TC022 Verify Admin Priority Configuration Matches Client Priority Dropdown Values
    Given User logged in as an admin
    When  User click on the Configuration tab under general settings menu
    And   User click on the Priority Configuration option
    Then  User should see the following priority values:
      | Not Specified |
      | Low           |
      | Medium        |
      | High          |
      | Critical      |
    Then   Click on logout

    Given   User logged in as a client
    When    User click on the New Ticket option under settings->CRM Tickets
    Then    User should see the following priority values in the dropdown:
      | Not Specified |
      | Low           |
      | Medium        |
      | High          |
      | Critical      |
    Then   Click on logout

    Given   User logged in as an admin
    When    User click on the Configuration tab under general settings menu
    And     User click on the Priority Configuration option
    Then    The displayed priority values should match the client dropdown values


  @CRM_Tickets_Validate_Category_Columns_According_To_Admin_Setting
  Scenario: TC023 Verify Admin Category Configuration Matches Client Category Dropdown Values
    Given User logged in as an admin
    When  User click on the Configuration tab under general settings menu
    And   User click on the Category Configuration option
    Then  User should see the following Category values:
      | Not Specified       |
      | System error        |
      | Question            |
      | IT support needed   |
    Then   Click on logout

    Given   User logged in as a client
    When    User click on the New Ticket option under settings->CRM Tickets
    Then    User should see the following Category values in the dropdown:
      | Not Specified       |
      | System error        |
      | Question            |
      | IT support needed   |
    Then   Click on logout

    Given   User logged in as an admin
    When    User click on the Configuration tab under general settings menu
    And     User click on the Category Configuration option
    Then    The displayed Category values should match the client dropdown values


  @CRM_Tickets_Validate_Action_Columns_According_To_Admin_Setting
  Scenario: TC024 Verify Admin Action Configuration Matches Client Action Dropdown Values
    Given User logged in as an admin
    When  User click on the Configuration tab under general settings menu
    And   User click on the Action Configuration option
    Then  User should see the following Action values:
      | Not Specified       |
    Then   Click on logout

    Given   User logged in as a client
    When    User click on the New Ticket option under settings->CRM Tickets
    Then    User should see the following Action values in the dropdown:
      | Not Specified       |
    Then   Click on logout

    Given   User logged in as an admin
    When    User click on the Configuration tab under general settings menu
    And     User click on the Action Configuration option
    Then    The displayed Action values should match the client dropdown values


  @CRM_Tickets_Validate_Feedback_Columns_According_To_Admin_Setting
  Scenario: TC025 Verify Admin Feedback Configuration Matches Client Feedback Dropdown Values
    Given User logged in as an admin
    When  User click on the Configuration tab under general settings menu
    And   User click on the Feedback Configuration option
    Then  User should see the following Feedback values:
      | Not Specified       |
    Then   Click on logout

    Given   User logged in as a client
    When    User click on the New Ticket option under settings->CRM Tickets
    Then    User should see the following Feedback values in the dropdown:
      | Not Specified       |
    Then   Click on logout

    Given   User logged in as an admin
    When    User click on the Configuration tab under general settings menu
    And     User click on the Feedback Configuration option
    Then    The displayed Feedback values should match the client dropdown values


  @CRM_Tickets_Validate_FeedbackType_Columns_According_To_Admin_Setting
  Scenario: TC026 Verify Admin FeedbackType Configuration Matches Client FeedbackType Dropdown Values
    Given User logged in as an admin
    When  User click on the Configuration tab under general settings menu
    And   User click on the FeedbackType Configuration option
    Then  User should see the following FeedbackType values:
      | Not Specified       |
    Then   Click on logout

    Given   User logged in as a client
    When    User click on the New Ticket option under settings->CRM Tickets
    Then    User should see the following FeedbackType values in the dropdown:
      | Not Specified       |
    Then   Click on logout

    Given   User logged in as an admin
    When    User click on the Configuration tab under general settings menu
    And     User click on the FeedbackType Configuration option
    Then    The displayed FeedbackType values should match the client dropdown values
