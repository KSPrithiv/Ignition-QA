Feature: Competitive Pricing
  All the scenarios that performs all the scenarios related to Competitive pricing

  Background: For login to application and select Competitior pricing
    Given User enters URL and is on login page and entered credentials for Competitior pricing
    When User is on Home Page for Competitior pricing
    Then User navigate to Client side for Competitior pricing

  @AddCompetitor
  Scenario Outline: For adding new competitor pricing
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User selects Customer reference "<CustRef>" "<CustRef1>" and Select customer Account#
    Then User click on Add competitor button and Enters Competitor details and clicks on Add button
    Examples:
    |CustRef           | CustRef1               |
    |Customer account #| All customer accounts #|

  @AddProduct
  Scenario Outline: For Adding Product to competitor
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User selects Customer reference "<CustRef>" "<CustRef1>" and Select customer Account#
    Then User clicks on competitor drop down and select the competitor based on previously created competitor
    And User should click on Plus button for adding products, using filter input box
    Then User selects Sold by uom, base uom, competitor pricing and comment, then user clicks on Save button
    |10.50|Comment Test1|
    |20.60|Comment Test2|
    |15.80|Comment Test3|
    |40.00|Comment Test4|
    |25.00|Comment Test5|
    Examples:
      | CustRef            |  CustRef1               |
      | Customer account # | All customer accounts # |

  @SearchForProduct
  Scenario Outline: For Searching product in competitor pricing
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User selects Customer reference "<CustRef>" "<CustRef1>" and Select customer Account#
    Then User clicks on competitor drop down and select the competitor based on previously created competitor
    And User search for product using Add filter
    Examples:
      | CustRef            |CustRef1|
      | Customer account # | All customer accounts # |

  @SearchingProductSearchBar
  Scenario Outline: For searching of products in competitor pricing using Search bar
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User selects Customer reference "<CustRef>" "<CustRef1>" and Select customer Account#
    And User search for product using Search bar
    Examples:
      | CustRef            | CustRef1|
      | Customer account # |  All customer accounts # |

  @DeleteProduct
  Scenario Outline: For Deleting Product to competitor
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User selects Customer reference "<CustRef>" "<CustRef1>" and Select customer Account#
    Then User clicks on competitor drop down and select the competitor based on previously created competitor
    And User selects one of the product from grid and delete it and click on save button
        Examples:
      | CustRef            |CustRef1  |
      | Customer account # |  All customer accounts # |

  @DeleteCompetitorData
  Scenario Outline: For Deleting competitor record
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User selects Customer reference "<CustRef>" "<CustRef1>" and Select customer Account#
    Then User clicks on competitor drop down and select the competitor based on previously created competitor
    And User clicks on delete competitor record button
    Examples:
      | CustRef            | CustRef1 |
      | Customer account # |   All customer accounts # |

  @LoadingExistingData
  Scenario Outline: For loading competitor data
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User selects Customer reference "<CustRef>" "<CustRef1>" and Select customer Account#
    And User Click on Load existing data and select competitor in popup
    Examples:
      | CustRef            |CustRef1|
      | Customer account # |  All customer accounts # |

  @DuplicateProduct
  Scenario Outline: Test scenario for verifying Duplicate products are not added in competitor pricing
    Given User must be on Client side and select Competitor pricing page
    When User should confirm that he is in Competitor pricing page
    And User selects Customer reference "<CustRef>" "<CustRef1>" and Select customer Account#
    And User search for product in catalog dialog box, to make sure that duplicate products are not added to competitive pricing
    Examples:
      | CustRef            | CustRef1|
      | Customer account # |  All customer accounts # |


