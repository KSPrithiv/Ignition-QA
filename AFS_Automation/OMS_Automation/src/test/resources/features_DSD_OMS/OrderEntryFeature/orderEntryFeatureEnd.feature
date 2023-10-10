Feature: Order entry End

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @CancelAndSkip
  Scenario: Test scenario for Skip using cancel button in new order entry page
    Given User must be on Order Entry Page
    Then Change the date 4 days after current date
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then User click on Cancel button and Popup should appear
    And User should click on Cancel and skip button by selecting reason
      |Closed|
    Then User should be navigated to Order Entry page
    Then Check for Remove Skip button is visible and Click on Remove Skip button

  @CancelAndSkipEnabled
  Scenario: Test scenario for verifying Cancel and Skip button is enabled in new OE page
    Given User must be on Order Entry Page
    Then Change the date 4 days after current date
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Click on Cancel button
    And Cancel popup should appear and verify button Cancel and Skip button
    Then User should be navigated to Order Entry page

  @CancelAndSkipDisabled
  Scenario: Test scenario for verifying Cancel and Skip button is disabled in new OE
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Click on Cancel button
    And Cancel popup should appear and verify button Cancel and Skip button for current date
    Then User should be navigated to Order Entry page

  @SkipOrder
  Scenario: Skip order, which will not let user to create New order for selected date
    Given User must be on Order Entry Page to Skip Order
    Then Change the date 4 days after current date
    Then Check for Skip button is visible and Click on Skip button and select reason
      |Closed|
    And Check for visibility of Remove Skip button

  @RemoveSkipOrder
  Scenario:Remove Skip order button, that appears in OE page
    Given User must be on Order Entry Page to Skip Order
    Then Change the date 4 days after current date
    Then Check for Remove Skip button is visible and Click on Remove Skip button

  @SkipFromNewOrderEntry
  Scenario: Skip the creation of order from new order entry page
    Given User must be on Order Entry Page to Skip Order
    Then Change the date 4 days after current date
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Click on Skip button in New order entry page and also select the reason
      |closed|
    Then User should be navigated to Order Entry page
    Then Check for Remove Skip button is visible and Click on Remove Skip button

  @LogoutOE
  Scenario:Loging out from the application
    And Refresh the page if any dialog box is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page