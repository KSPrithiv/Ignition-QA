Feature: Badge Builder Icon Selection
  Background: For login to application and to select Badge Builder
    Given User enters URL and entered to login page


    @VerifyColorChangeInProductIcon-CatalogProductSearch
    Scenario: Test Scenario to verify change in catalog product icon color from Order Entry page
      And    Login to Client portal BadgeBuilder1
      Then   User should navigate to Client side1
      And    Click on the Order Entry tab2
      And   Select Account and start Order - CatchWeightItems
      And   Add Product to the grid and check Icon Color


#    @VerifyColorChangeInProductIcon-OpenOrder
#    Scenario:  Test Scenario to verify change in product icon color from Open Orders Page
#      Given  User should navigate to Open Orders Tab
#      Then   Start Order
#      And    Compare Color of Product Icon

    @VerifyChangeInProductIcon-StandingOrder
    Scenario:  Test Scenario to verify change in product icon color from Standing Order Page
      Given  User should navigate to Standing Order Tab1
      Then   Click on New Standing order and select date
      And    Compare Color of Product Icon of Standing Order


  @VerifyColorChangeInProductIcon-OrderGuide
  Scenario:  Test Scenario to verify change in product icon color from Order Guide Page
    Given User should navigate to OrderGuide Tab1
    And   Add Product to the Order Guide grid1
    Then  Check Icon color
    And   Logout1