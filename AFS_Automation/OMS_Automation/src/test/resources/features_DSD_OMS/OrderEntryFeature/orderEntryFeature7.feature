Feature: Order Entry7
  Used for cration of New order in different ways
  Used for canceling order, editing of order, skipping of order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials
    When User is on Home Page
    Then User navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#

  @EditWithOutChangeing
  Scenario:Test scenario for creating Order and edit it without making any changes, or usage of back to orderlist in summary page
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      |PO123|
    Then Enter Pro# in Quick Product Entry area
    And Check for Case and Unit input box enabled or not based on that enter value
      |80|60|
    Then Click on Next button
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Enter Order# in Search box in Order Entry page
    Then Click on Order number in Order Entry page
    Then Click on Next button
    And User should be in Order summary page and click on back to Orderlist button

  @FiltersInCatalogIndexPage
  Scenario Outline: Test scenario for filtering of products in catalog index popup
    Given User must be on Order Entry Page
    Then User must click Start Order button
    Then User should make selection between Pending order or Start New order
    Then User should select Note from popup and Order guide from popup
    Then Enter PO# for New order
      | PO123 |
    Then Click on Add product drop down and select catalog option
    And User should validate Catalog dialogbox and use filters in customer index dialogbox "<Category>","<Sub Category>","<Brand>","<OG>"
    Examples:
      | Category                | Sub Category | Brand       | OG        |
      |Juices/Juice Drinks/Water| Breakfast    | DR PEPPER   | SampleOG  |

  @ContactInformation
  Scenario: Test scenario for finding the contact information details
    Given User must be on Order Entry Page
    Then User clicks on icon next to address

  @PrivacyPolicy
  Scenario: Test scenario for finding the contact information details
    Given User must be on Order Entry Page
    Then User clicks on Privacy policy link and window with pivacy policy will open, user handles it

