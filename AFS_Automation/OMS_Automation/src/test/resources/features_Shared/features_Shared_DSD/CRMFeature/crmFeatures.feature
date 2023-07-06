Feature: OMS CRM Tickets Page Verification under Admin portal

  Background: For login to application
    Given User enters correct URL and opened login page

  @CRM_Tickets_VerifyCRMTicketsTabs
  Scenario: TC001  Verify CRM Tickets Tabs Module
    Given  User able to open login page successfully
    When   User entered correct Admin username and password on the page
    Then   Admin Page opened successfully
    And    User click on Hamburger left Menu
    Then   Select CRM Tickets Module
    Then   Validate CRM Tickets page get opened
    And    Verify All four tabs in CRM module called CRM General, Purge, Notifications, Configure

  @CRM_Tickets_VerifyCRMTicketsGeneralTabs
  Scenario: TC002  Verify CRM Tickets General Tabs
    Then   Select CRM Tickets Module
    Then   Validate CRM Tickets page get opened
    And    Verify CRM General tab have buttons like Export, Notes, Reason, Source, Category, Action, Feedback, Feedback type
    Then   Also validate Ticket number is a field where user can increase or decrease the number

  @CRM_Tickets_VerifyCRMGeneralCancelAndSaveFunctionality
  Scenario: TC003  Verify CRM General Cancel And Save Functionality
    Then   Select CRM Tickets Module
    Then   Validate CRM Tickets page get opened
    And    Edit any field under CRM general tab
    And    Validate Cancel and Save buttons should get enabled
    Then   Click on Cancel button and Validate pop up message get come
    Then   Click on yes option from pop up to discard the changes which we made in above steps and Validate page no any changes displaying
    And    Again User Edit any field under CRM general tab
    And    Validate Cancel and Save buttons should get enabled
    Then   Click on Cancel button and Validate pop up message get come
    Then   Click on No option from pop up and Validate changes still displaying on the page
    Then   Click on Save button and Validate pop up display on the screen
    And    Click on ok button to save the changes
    And    Validate Changes on the screen

  @CRM_Tickets_VerifyPurgeTab
  Scenario: TC004  Verify Purge Tab under CRM Tickets
    When   User click on purge tab and Select any company
    Then   Validate purge screen should display with list of tickets
    And    Also validate items found field should display the number of tickets listed on the page

  @CRM_Tickets_AddNotification_Positive_Scenario
  Scenario: TC007_Positive Verify User can add Notifications under notification Tab
    When   User click on Notification tab and Select any company
    Then   Validate notification screen should display with list of notifications records
    Then   Click on + plus button to add notification and verify notification pop up should open
    And    Provide all the mandatory field values and click on save button
    And    Validate new record should get added under notifications

  @CRM_Tickets_AddNotification_Negative_Scenario
  Scenario: TC007_Negative Verify User can not able to add Notifications if mandatory field not entered by user
#    When   User click on Notification tab and Select any company
#    Then   Validate notification screen should display with list of notifications records
    Then   Click on + plus button to add notification and verify notification pop up should open
    And    Skip any mandatory field values and Validate error message for the respective fields
    And    Click on Cancel button from notification pop up

  @CRM_Tickets_EditNotification
  Scenario: TC009 Verify User can able to Edit Notifications
#    When   User click on Notification tab and Select any company
#    Then   Validate notification screen should display with list of notifications records
    When   User able to select any notification from the list of notifications which we want to Edit
    Then   Click on Edit button and Validate Notification pop up should display with all details
    Then   Edit any field and click on save button And Validate Changes

  @CRM_Tickets_DeleteNotification
  Scenario: TC010 Verify User can able to delete Notifications
#    When   User click on Notification tab and Select any company
#    Then   Validate notification screen should display with list of notifications records
    When   User able to select any notification from the list of notifications which we want to delete
    Then   Validate Edit and delete buttons get enabled
    Then   Click on delete button and click on Cancel button from pop up
    And    Validate notification page having same notification list as before
    Then   Click on delete button and click on ok button from pop up
    And    Validate notification page having less than 1 notification as before
