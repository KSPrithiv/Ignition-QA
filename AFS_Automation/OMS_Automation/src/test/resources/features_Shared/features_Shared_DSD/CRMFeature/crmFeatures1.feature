Feature: OMS CRM Tickets Page Verification under Admin portal

  Background: For login to application
    Given User enters correct URL and opened login page

  @CRM_Tickets_VerifyCRMTicketsConfigureTab
  Scenario: TC011 Verify CRM Tickets Configure Tabs
    Then   User click on Configure tab and select any company
    And    Validate Configure page should display the list of base tables
    Then   Select any base table record and validate record get selected and highlighted with yellow color
    And    Also verify the right side grid should display the list of Configuration of the selected base table

  @CRM_Tickets_VerifyCRMTicketsAddConfigurations
  Scenario: TC012 Verify In CRM Tickets Configure Tabs and user can able to Add configuration
#    Then   User click on Configure tab and select any company
#    And    Validate Configure page should display the list of base tables
    Then   Select any base table record and validate record get selected and highlighted with yellow color
    Then   Click on plus button to add configuration under that base table
    And    Validate add pop up will get open with description text box
    Then   Provide appropriate description and click on save button
    And    Validate new code should get created for new configuration with next sequence number

  @CRM_Tickets_VerifyCRMTicketsEditConfigurations
  Scenario: TC013 Verify In CRM Tickets Configure Tabs and user can able to Edit configuration
#    Then   User click on Configure tab and select any company
#    And    Validate Configure page should display the list of base tables
#    Then   Select any base table record and validate record get selected and highlighted with yellow color
    Then   Select any row from table which we are going to edit
    Then   Click on Edit button to edit configuration under that base table
    And    Validate Edit pop up will get open with description text box enabled and code field disabled
    Then   Provide new appropriate description and click on Cancel button from pop up
    And    Validate the field should reverted back and display old value
    Then   Click on Edit button to edit configuration under that base table
    Then   Provide new appropriate description and click on Edit button from pop up
    And    Validate the field should save with new description and display new value

  @CRM_Tickets_VerifyCRMTicketsDeleteConfigurations
  Scenario: TC014 Verify In CRM Tickets Configure Tabs and user can able to Delete configuration
#    Then   User click on Configure tab and select any company
#    And    Validate Configure page should display the list of base tables
#    Then   Select any base table record and validate record get selected and highlighted with yellow color
    Then   Select any row from table which we are going to Delete
    Then   Click on Delete button to delete configuration under that base table
    And    Validate Delete pop up with cancel and okay button enabled
    Then   Click on Cancel button from pop up
    And    Validate the record should not get deleted
    Then   Click on Delete button to delete configuration under that base table
    Then   Click on Ok button from pop up
    And    Validate Record should get deleted successfully
    And    Click on Logout button to logout from Admin


