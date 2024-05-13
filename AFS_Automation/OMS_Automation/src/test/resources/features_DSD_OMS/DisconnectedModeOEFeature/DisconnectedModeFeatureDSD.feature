Feature: Disconnected mode
  Used for Performing different operations in disconnected mode

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for DM
    When User is on Home Page for DM
    Then User navigate to Client side for DM
    Then User should select Order Entry tab for DM

  @DMProductComment
  Scenario: For adding comment to product level
    Given User should be in Order entry page
    When User Clicks on network symbol and click on toggle button to navigate to disconnected mode
    And Then User selects Go offline option in Disconnected mode popup
    Then User should get Customer account# popup
    And User should select Customer Account# from popup and select the delivery date from popup wait till synchronized
    Then User must be on Order Entry Page in disconnected mode
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |1|1|
    Then User should click on Comment icon in Product grid
    And should enter comment in comment popup
      |Comment at Product level|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page
