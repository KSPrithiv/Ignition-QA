Feature: Order Entry for ERP env
  Used for cration of New order in different ways

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

@OEUsingSubstituteProductOk
Scenario: Creating New order by entering Product# in Quick order entry, verify substitute product dialog box and select Ok button
   Given User must be on Order Entry Page
   Then User must click Start Order button
   Then User should make selection between Pending order or Start New order
   Then User should select Note from popup and Order guide from popup
   Then Enter PO# for New order
      |PO123|
   Then Enter Pro# in Quick Product Entry area for substitute product
   And Check for Case and Unit input box enabled or not based on that enter value
      |2|1|
   And User should handle substitute product dialog box by using Ok button
   Then Click on Next button
   And Click on SubmitOrder button
   Then User should be navigated to Order Entry page

  @OEUsingSubstituteProductSkipSubstitute
  Scenario: Creating New order by entering Product# in Quick order entry, verify substitute product dialog box and select Skip substitute button
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area for substitute product
    And Check for Case and Unit input box enabled or not based on that enter value
      |2|1|
    And User should handle substitute product dialog box by using skip substitute button
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |2|1|
    Then Click on Next button
    And Click on SubmitOrder button
    Then User should be navigated to Order Entry page