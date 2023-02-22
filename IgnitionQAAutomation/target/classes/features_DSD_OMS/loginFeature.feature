Feature: Testing of AFS Application

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

  @ForgottenPassword
  Scenario: Send mail for Forgotten Password
    Given User on login page
    Then Click on Forgotten passowrd button
    Then Enter username in input box and click on send button
      |DivyaQA|
    Then Verify popup message displayed

  @ForgottenPasswordNegative
    Scenario: To test Forgotten password feature, with non existing user name
    Given User on login page
    Then Click on Forgotten passowrd button
    Then Enter username in input box and click on send button
      |DivyaQA|
    Then Verify popup message displayed

  @ValidCredetials
  Scenario:Enter valid user name and password, Validate Home page Test
    Given User on login page
    Then User entered username and password
    Then Admin Page is displayed
    Then Navigate to Client side
    Then Click on user Icon
    And Click on Logout

  @ForeignLanguage
    Scenario: Check for display of details in foreign language
    Given User on login page
    Then User entered username and password
    Then Admin Page is displayed
    Then Navigate to Client side
    Then User should select Order Entry tab
    Then User selects Account#
    And User on Order Entry Page
    Then Click on user Icon
    Then User changes language to some other language option and validates language
    And User resetting language back to
    |English (USA)|
    Then Click on user Icon
    And Click on Logout

  @Logout
  Scenario:Loging out from the application
    Then Click on user Icon
    And Click on Logout

  @RegistrationCancel
   Scenario: Enter all the details in Registration input boxes and cancel button
   Given User on login page
   And Click on Register here link
   Then Customer Registration page should get displayed
   And Enter values in input boxes
   Then click on Cancel button

@RegistrationAccount
  Scenario: Registration of user using  Customer account#
  Given User on login page
  And Click on Register here link
  Then Customer Registration page should get displayed
  And Enter values in input boxes
  Then click on Register button
  And Verify User is on Order Entry Page and logout

@DonotHaveAccount
  Scenario: Allowing new customer to register when not having an account
  Given User on login page
  And Click on Register here link
  Then Customer Registration page should get displayed
  And Click on Donot have account check box, Then Enter values in input boxes
  Then click on Register button
  And Verify User is on Order Entry Page and logout

@DonotHaveAccountCancel
Scenario: Allowing new customer to register when not having an account
  Given User on login page
  And Click on Register here link
  Then Customer Registration page should get displayed
  And Click on Donot have account check box, Then Enter values in input boxes
  Then click on Cancel button

   #Based on admin setting
  @ProductsCatalogCardView
  Scenario: Selecting Products to be ordered in login page, before loging in to application.Using Card view.
    Given User on login page
    When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty card view
      |  10  |  10  |
      |   5  |  10  |
      |   5  |  5   |
      |  10  |  5   |
      |  10  | 10   |
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Then Click on user Icon
    And Click on Logout

  @DeleteProductsAddByDeleteIcon
  Scenario: Add products to cart from external catalog, Delete added product using Delete Icon. Here Card view is used
  Given User on login page
  When User clicks on View product catalog and Product catalog should be displayed
    And user should click on Reset filter button and all the products should displayed in card view
    Then User enters Product# in Search bar in Catalog popup and enter Qty and delete the first product added
    |50|50|
    |40|30|
    |40|40|
    |40|40|
    |40|50|
    Then User click on cart and click on Checkout to order
    And Login to Application and Select customer account from popup
    Then User should navigate to My Cart and click on Chekout to order button
    And user should be on New Order entry page
    Then Enter PO# for New order
      |PO123|
    Then Click on Next button
    Then Click on SubmitOrder button
    Then User should be navigated to Order Entry page
    Then Click on user Icon
    And Click on Logout

    @DeleteItemsInCart
      Scenario: Add product to cart from external catalog and delete one of the product from Items in Cart page
      Given User on login page
      When User clicks on View product catalog and Product catalog should be displayed
      And user should click on Reset filter button and all the products should displayed in card view
      Then User enters Product# in Search bar in Catalog popup and enter Qty card view
        |50|50|
        |40|30|
        |40|40|
        |40|40|
        |40|50|
      Then User click on cart, Delete one product from cart and click on Checkout to order
      And Login to Application and Select customer account from popup
      Then User should navigate to My Cart and click on Chekout to order button
      And user should be on New Order entry page
      Then Enter PO# for New order
        |PO123|
      Then Click on Next button
      Then Click on SubmitOrder button
      Then User should be navigated to Order Entry page
      Then Click on user Icon
      And Click on Logout

@DeleteFromMyCart
Scenario: Add product to cart from external catalog and delete one of the product from My cart page
  Given User on login page
  When User clicks on View product catalog and Product catalog should be displayed
  And user should click on Reset filter button and all the products should displayed in card view
  Then User enters Product# in Search bar in Catalog popup and enter Qty card view
    |50|50|
    |40|30|
    |40|40|
    |40|40|
    |40|50|
  Then User click on cart and click on Checkout to order
  And Login to Application and Select customer account from popup
  Then User should navigate to My Cart, Delete one product and click on Chekout to order button
  And user should be on New Order entry page
  Then Enter PO# for New order
    |PO123|
  Then Click on Next button
  Then Click on SubmitOrder button
  Then User should be navigated to Order Entry page
  Then Click on user Icon
  And Click on Logout

  @ProductsCatalogListView
  Scenario: Adding product to cart, using list view
  Given User on login page
  When User clicks on View product catalog and Product catalog should be displayed
  And user should click on Reset filter button and all the products should displayed in List view
  Then User enters Product# in Search bar in Catalog popup and enter Qty List view
    |  10  |  10  |
    |   5  |  10  |
    |   5  |  5   |
    |  10  |  5   |
    |  10  |  10  |
  Then User click on cart and click on Checkout to order
  And Login to Application and Select customer account from popup
  Then User should navigate to My Cart and click on Chekout to order button
  And user should be on New Order entry page
  Then Enter PO# for New order
    |PO123|
  Then Click on Next button
  Then Click on SubmitOrder button
  Then User should be navigated to Order Entry page
  Then Click on user Icon
  And Click on Logout

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
   And user Should click on Reset Filer button and verifies that Category is set back to All category

  @Verify_Client_AdminLogin
  Scenario: Login as Admin once, Login as Client once and verify landing pages
    Given User on login page
    Then User should enter client username and password
    Then Admin Page is displayed
    Then Click on user Icon
    And Click on Logout
    When user enters admin username and password
    Then Admin landing page should displayed
    And Click on Logout







