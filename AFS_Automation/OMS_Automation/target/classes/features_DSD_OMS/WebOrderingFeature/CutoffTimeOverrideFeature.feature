Feature: Admin setting for Cutoff Management-pickup order
  Verifying Admin setting features for Cutoff management-pickup order

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Admin setting
    When User is on Home Page for Admin setting
    #Then User Clicks on Permissions by drop down to select Customer Account#

  @CutoffTimeOverrideAddCompany
  Scenario Outline: Test scenario for adding Cutoff Time Override
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab for Cutoff management
    Then User should select "<MenuOption>" from horizontal menu to select Cutoff Time Override
    And User should click on Branch management toggle button set times for cutoff, Cutoff Time Override Adding Company
    Examples:
      | Option              |         MenuOption              |
      | Blackouts & Cutoffs |       Cutoff time override      |

  @CutoffTimeOverrideDeleteCompany
  Scenario Outline: Test scenario for deleting Cutoff Time Override
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab for Cutoff management
    Then User should select "<MenuOption>" from horizontal menu to select Cutoff Time Override
    And User should click on Branch management toggle button set times for cutoff, Cutoff Time Override Delete Company
    Examples:
      | Option              |         MenuOption              |
      | Blackouts & Cutoffs |       Cutoff time override      |

  @CutoffTimeOverrideAddCustomer
  Scenario Outline: Test scenario for adding Cutoff Time Override for customer
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab for Cutoff management
    Then User should select "<MenuOption>" from horizontal menu to select Cutoff Time Override
    And User should click on Branch management toggle button set times for cutoff, Cutoff Time Override Adding Customer
    Examples:
      | Option              |         MenuOption              |
      | Blackouts & Cutoffs |       Cutoff time override      |

  @CutoffTimeOverrideDeleteCustomer
  Scenario Outline: Test scenario for deleting Cutoff Time Override for customer
    Given User is on Home Page for Admin setting to select Admin option
    Then User refreshes page Clicks on Permissions by drop down to select Customer Account# grid for WebOrder
    And User should navigate to "<Option>" tab for Cutoff management
    Then User should select "<MenuOption>" from horizontal menu to select Cutoff Time Override
    And User should click on Branch management toggle button set times for cutoff, Cutoff Time Override Delete Customer
    Examples:
      | Option              |         MenuOption              |
      | Blackouts & Cutoffs |       Cutoff time override      |

