Feature: Admin setting
  Verifying Admin setting features for Restricted Products

  Background: For login to application and selecting Account#
    Given User enters URL and is on login page and entered credentials for Admin setting
    When User is on Home Page for Admin setting
    Then User Clicks on Permissions by drop down to select Customer Account#

  @AddProducts
  Scenario Outline: Test scenario for Adding product to restricted products
    Given User is on Home Page for Admin setting to select Admin option
    And User should enter menu "<Option>" in search bar to navigate to Authorized Products
    Then User should select "<MenuOption>" from horizantal menu to select Restricted product list
    And User should be on Restricted product list
    Then User should list all the products in Product grid
    And User Clicks on Add products button and user should make sure that Product popup has appeared
    Then User should select product no from popup and click on Ok
    Examples:
      |Option             | MenuOption               |
      |Authorized Products| Restricted product list  |

 @DeleteProducts
 Scenario Outline: Test scenario for Deleting product from restricted products
   Given User is on Home Page for Admin setting to select Admin option
   And User should enter menu "<Option>" in search bar to navigate to Authorized Products
   Then User should select "<MenuOption>" from horizantal menu to select Restricted product list
   And User should be on Restricted product list
   Then User should list all the products in Product grid
   And User should Select product from the Product grid and click on Delete button
   Examples:
     |Option             | MenuOption               |
     |Authorized Products| Restricted product list  |

 @AddCategory
 Scenario Outline: Test scenario for Adding category of product to restricted products group
   Given User is on Home Page for Admin setting to select Admin option
   And User should enter menu "<Option>" in search bar to navigate to Authorized Products
   Then User should select "<MenuOption>" from horizantal menu to select Restricted product list
   And User should be on Restricted product list
   Then User clicks on ProductGroup radio button and user should be navigated to Products restriction group
   And User clicks on Add Product group button and select category group from popup
   Examples:
     |Option             | MenuOption               |
     |Authorized Products| Restricted product list  |

 @DeleteCategory
 Scenario Outline: Test scenario for Deleting category of product from restricted products group
   Given User is on Home Page for Admin setting to select Admin option
   And User should enter menu "<Option>" in search bar to navigate to Authorized Products
   Then User should select "<MenuOption>" from horizantal menu to select Restricted product list
   And User should be on Restricted product list
   Then User clicks on ProductGroup radio button and user should be navigated to Products restriction group
   And User clicks on Delete group button
   Examples:
     |Option             | MenuOption               |
     |Authorized Products| Restricted product list  |
