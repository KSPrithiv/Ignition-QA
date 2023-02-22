Feature: Login

  Background: For login to application
    Given User enters URL and is on login page

  @InvalidCredentials
  Scenario Outline: Invalid userid and password
    Given User on login page
    Then User entered Invalid "<username>" and "<password>"
    Then Check for warning message
    Examples:
      | username | password |
      | !@##$@#$ | @$@#$$%#$|
      | 12738172 | 723472423|
      | alskjflsd|aksjflssa |

  @SalesHelp
  Scenario: Test scenario for handling Sales help from drop down
    Given User on login page
    Then User entered username and password for sales help
    Then Admin Page is displayed
    Then User navigate to Client side
    Then User should select Order Entry tab
    And User click on Question mark and selects Sales help option

  @eCommerceHelp
  Scenario: Test scenario for handling eCommerce drop down
    And User click on Question mark and selects ecommerce option
    Then Click on user Icon
    And Click on Logout

  @ForgottenPassword
  Scenario: Send mail for Forgotten Password
    Given User on login page
    Then Click on Forgotten password button
    Then Enter username in input box and click on send button
      |DivyaQA|
    Then Verify popup message displayed

  @ForgottenPasswordNegative
  Scenario: To test Forgotten password feature, with non existing user name
    Given User on login page
    Then Click on Forgotten password button
    Then Enter username in input box and click on send button
      |DivyaQA|
    Then Verify popup message displayed

  @ValidCredetials
  Scenario:Enter valid user name and password, Validate Home page Test
    Given User on login page
    Then User entered username and password
    Then Admin Page is displayed
    Then Click on user Icon
    And Click on Logout

  @Logout
  Scenario:Loging out from the application
    Given User on login page
    Then User entered username and password
    Then Admin Page is displayed
    Then Click on user Icon
    And Click on Logout

  @RegistrationCancel
  Scenario: Enter all the details in Registration input boxes and cancel button
    Given User on login page
    And Click on Register here link
    Then Customer Registration page should get displayed
    And Enter values in input boxes
    Then click on Cancel button

#This is based on admin setting
  @RegistrationAccount
  Scenario: Registration of user using  Customer account#
    Given User on login page
    And Click on Register here link
    Then Customer Registration page should get displayed
    And Enter values in input boxes
    Then click on Register button
    Then If user is navigated to OE page Logout from application

  @DonotHaveAccount
  Scenario: Allowing new customer to register when not having an account
    Given User on login page
    And Click on Register here link
    Then Customer Registration page should get displayed
    And Click on Donot have account check box, Then Enter values in input boxes
    Then click on Register button

  @DonotHaveAccountCancel
  Scenario: Allowing new customer to register when not having an account,cancel option
    Given User on login page
    And Click on Register here link
    Then Customer Registration page should get displayed
    And Click on Donot have account check box, Then Enter values in input boxes
    Then click on Cancel button

  @ProductsSeparatedByComma
  Scenario: Search for multiple products separeated by comma, in external catalog
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters multiple Product# in Search bar separated by comma and Read the product# available in catalog

  @SortByBestMatch
  Scenario: Sorting of items in ascending order
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in List view
    Then Click on sort by best match and select ascending order and verify the same
      |Sort by price (ascending)|

  @ResetFilter
  Scenario: Testing of Reset Filter button functionality
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User Clicks on Category drop down and selects the 1st category
      |Juices/Juice Drinks/Water|
    And user Should click on Reset Filer button and verifies that Category is set back to All category

   #Based on admin setting
  @ProductsCatalogCardView
  Scenario: Selecting Products to be ordered in login page, before loging in to application.Using Card view.
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty card view
      |10|
      |50|
      |50|
      |70|
      |60|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon
    And Click on Logout

  @ProductsCatalogListView
  Scenario: Adding product to cart, using list view
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in List view
    Then User enters Product# in Search bar in Catalog popup and enter Qty List view
      |10|
      |50|
      |50|
      |70|
      |60|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon
    And Click on Logout

  @DeleteProductsAddByDeleteIcon
  Scenario: Add products to cart from external catalog, Delete added product using Delete Icon. Here Card view is used
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty and delete the first product added
      |50|
      |40|
      |40|
      |40|
      |40|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon
    And Click on Logout

  @DeleteItemsInCart
  Scenario: Add product to cart from external catalog and delete one of the product from Items in Cart page
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty card view
      |50|
      |40|
      |40|
      |40|
      |40|
    Then User click on cart, Delete one product from cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon
    And Click on Logout

  @DeleteFromMyCart
  Scenario: Add product to cart from external catalog and delete one of the product from My cart page
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty card view
      |50|
      |40|
      |40|
      |40|
      |40|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart, Delete one product and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button and select option Continue without payment option
    And Click on Submit Order button and read Order_no
    Then User should be navigated to Order Entry page
    Then Click on user Icon
    And Click on Logout

  @Verify_Client_AdminLogin
  Scenario: Login as Admin once, Login as Client once and verify landing pages
    Given User on login page
    Then User entered username and password
    Then Admin Page is displayed
    Then Click on user Icon on Order Entry page
    And Click on Logout on Order Entry page
    Then user enters admin username and password
    And User should be navigated to Admin page
    Then Click on user Icon
    And Click on Logout

  @ForeignLanguage
  Scenario: Check for display of details in foreign language
    Given User on login page
    Then User entered username and password
    Then Admin Page is displayed
    Then Click on user Icon on Order Entry page
    Then User changes language to some other language option and validates language
    Then Click on user Icon on Order Entry page
    And User resetting language back to
      |English (USA)|
    Then Click on user Icon
    And Click on Logout
