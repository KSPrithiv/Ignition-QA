@Counting @Regression
Feature: Testing of Counting Count functionality
  Scenario: Checking Release Counts on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 1 on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 3 on Counting Sessions page
    And User checks table row by index 0 on Counting Sessions page
    When User clicks Location Release on Counting Sessions page
    And Validates Release counts popup is displayed on Counting Sessions page
    And Types Tasks "testTask" per Assignment on Counting Sessions page
    And Validates task per assignment value "" on Counting Sessions page
    And Types Tasks "test%$" per Assignment on Counting Sessions page
    And Validates task per assignment value "" on Counting Sessions page
    And Types Tasks "123" per Assignment on Counting Sessions page
    And Validates task per assignment value "123" on Counting Sessions page
    And Clears Tasks per Assignment on Counting Sessions page
    And Types Tasks "1" per Assignment on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    Then Validates notification "You must put between 4 and 199 count tasks in each count book." on Counting Sessions page
    And Clears Tasks per Assignment on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page
    And User checks table row by index 1 on Counting Sessions page
    And User clicks Location Release on Counting Sessions page
    And Validates Release counts popup is displayed on Counting Sessions page
    And Clicks User directed counting radio button on Counting Sessions page
    And User types future Release date in 3 days on Counting Sessions page
    And User types future Release time "12:01" days on Counting Sessions page
    And User clicks Save button on Counting Sessions page
    And User clicks Location Release on Counting Sessions page
    And User clicks Save button on Counting Sessions page

  Scenario: Checking Product details in Product tab on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    When User clicks session dropdown on Counting Sessions page
    And User selects session with index 3 on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    Then Validates Products tab screen is displayed on Counting Sessions page
    And Validates Delete and Reset Product are disabled on Counting Sessions page
    And Validates Generate locations button is displayed on Counting Sessions page
    And Validates Generate locations is enabled on Counting Sessions page
    And Validates Add Product is enabled on Counting Sessions page
    And Validates table rows are displayed on Counting Sessions page

  Scenario: Checking Reconcile session on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    When User clicks session dropdown on Counting Sessions page
    And User selects session with index 1 on Counting Sessions page
    Then User clicks Location Reconcile on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page

  @loader1
  Scenario: Checking Search and Add Filter functionality on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And User clicks session dropdown on Counting Sessions page
    When User selects session with index 1 on Counting Sessions page
    And Validates Session details on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And User searches for product with index 0 on Counting Sessions page
    Then User deletes product search input on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 1 on Counting Sessions page
    And User searches for product with index 4 on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User deletes product search input on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Product Checkbox on Counting Sessions page
    And Types Product by index 4 on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clears Search button on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 2 on Counting Sessions page
    And User clears Search button on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Owner Checkbox on Counting Sessions page
    And Types Owner by index 4 on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Description Checkbox on Counting Sessions page
    And Types Description by index 4 on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Book Cost Checkbox on Counting Sessions page
    And Types Book cost "0" on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Checks Product Type Checkbox on Counting Sessions page
    And Types Product type by index 1 on Counting Sessions page
    And Clicks Apply Button on Counting Sessions page
    And Validates items are present on Counting Sessions page
    And User clicks Add filter button on Counting Sessions page
    And Clicks Clear All Button on Counting Sessions page
    And Validates items are present on Counting Sessions page

    @loader1
#  Scenario: Checking Add Products from Product tab on Counting Sessions screen
#    Given User signs in the application
#    And Main page is loaded
#    And Go to Counting Sessions page
#    And Waits for Counting Sessions page to load
#    And User clicks session dropdown on Counting Sessions page
#    When User selects session with index 1 on Counting Sessions page
#    And User clicks Products tab on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    Then Validates "Add product" popup is displayed on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Types "50" number of products on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Selects product type by index 2 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Selects movement class by index 1 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Selects owner dropdown by index 1 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Types supplier by index 2 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Types prod alias type by index 2 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Types inventory status by index 2 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Selects product type by index 5 on Counting Sessions page
#    And Selects movement class by index 3 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Selects product type by index 2 on Counting Sessions page
#    And Selects movement class by index 1 on Counting Sessions page
#    And Types supplier by index 2 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Selects product type by index 2 on Counting Sessions page
#    And Selects movement class by index 1 on Counting Sessions page
#    And Types supplier by index 2 on Counting Sessions page
#    And Selects owner dropdown by index 1 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Selects product type by index 2 on Counting Sessions page
#    And Selects movement class by index 1 on Counting Sessions page
#    And Types supplier by index 2 on Counting Sessions page
#    And Selects owner dropdown by index 1 on Counting Sessions page
#    And Types inventory status by index 2 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And Selects product type by index 2 on Counting Sessions page
#    And Selects movement class by index 1 on Counting Sessions page
#    And Types supplier by index 2 on Counting Sessions page
#    And Selects owner dropdown by index 1 on Counting Sessions page
#    And Types inventory status by index 5 on Counting Sessions page
#    And Types prod alias type by index 4 on Counting Sessions page
#    And User clicks Save button on Counting Sessions page
#    And Clicks Add Product Button on Counting Sessions page
#    And Validates "Add product" popup is displayed on Counting Sessions page
#    And User clicks Cancel button on Counting Sessions page

  @Productsxpath
  Scenario: Checking Sorting and Select All on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And User clicks session dropdown on Counting Sessions page
    When User selects session with index 2 on Counting Sessions page
    And Deletes cookies on application
    And User clicks Products tab on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And Clicks All Checkbox button on Counting Sessions page
    And Validates product with index 1 is selected on Counting Sessions page
    And Validates product with index 2 is selected on Counting Sessions page
    Then UnClicks All Checkbox button on Counting Sessions page
    And Validates product with index 1 is not selected on Counting Sessions page
    And Validates product with index 2 is not selected on Counting Sessions page
    And User clicks Product Column on Counting Sessions page
    And User clicks Product Column on Counting Sessions page
    And Validates Product Column Sorting Result on Counting Sessions page
    And User clicks Owner Column on Counting Sessions page
    And Validates Owner Column Sorting Result on Counting Sessions page
    And User clicks Owner Column on Counting Sessions page
    And Validates Owner Column Sorting Result on Counting Sessions page
    And User clicks Description Column on Counting Sessions page
    And Validates Description Column Sorting Result on Counting Sessions page
    And User clicks Description Column on Counting Sessions page
    And Validates Description Column Sorting Result on Counting Sessions page
    And User clicks Book Cost Column on Counting Sessions page
    And Validates Book Cost Column Sorting Result on Counting Sessions page
    And User clicks Book Cost Column on Counting Sessions page
    And Validates Book Cost Column Sorting Result on Counting Sessions page
    And User clicks Product Type Column on Counting Sessions page
    And Validates Product Type Column Sorting Result on Counting Sessions page
    And User clicks Product Type Column on Counting Sessions page
    And Validates Product Type Column Sorting Result on Counting Sessions page

  @Productsxpath
  Scenario: Checking Remove Products from Product Tab on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And User clicks session dropdown on Counting Sessions page
    When User selects session with index 0 on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    And User clicks session dropdown on Counting Sessions page
    And User selects session with index 1 on Counting Sessions page
    And User checks table row by index 0 on Counting Sessions page
    Then Clicks Delete products button on Counting Sessions page
    And Validates dialog text "Remove highlighted items?" on Counting Sessions page
    And Validates Cancel and OK buttons are displayed on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page
    And User checks table row by index 1 on Counting Sessions page
    And Clicks Delete products button on Counting Sessions page
    And Validates dialog text "Remove highlighted items?" on Counting Sessions page
    And Validates Cancel and OK buttons are displayed on Counting Sessions page
    And User clicks Cancel button on Counting Sessions page

  Scenario: Checking Generate locations from Product tab on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    When User clicks session dropdown on Counting Sessions page
    And User selects session with index 3 on Counting Sessions page
    And User clicks Products tab on Counting Sessions page
    Then Clicks Generate locations button on Counting Sessions page
    And Validates "Success" notification is displayed on Counting Sessions page
    And User clicks Location tab on Counting Sessions page
    And Validates Session details on Counting Sessions page

  Scenario: Checking Delete Assignments on Counting Sessions screen
    Given User signs in the application
    And Main page is loaded
    And Go to Counting Sessions page
    And Waits for Counting Sessions page to load
    And User clicks session dropdown on Counting Sessions page
    When User selects session with index 3 on Counting Sessions page
    Then User clicks Assignments tab on Counting Sessions page
    And Validates Assignment tab contains Release and Delete buttons, Add filter button on Counting Sessions page
    And Validates Release button is disabled on Counting Sessions page
    And Validates Delete button is disabled on Counting Sessions page
    And Validates Assignments columns are displayed on Counting Sessions page