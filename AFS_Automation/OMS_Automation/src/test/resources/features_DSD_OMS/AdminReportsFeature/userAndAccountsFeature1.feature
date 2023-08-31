Feature: scenarios for User and Accounts admin feature1

  Background: For login to application and selecting Account# for Admin reports
    Given User enters URL and is on login page and entered credentials for Admin setting for Admin reports
    When User is on Home Page for Admin setting for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# for Admin reports
    Then User Clicks on Permissions by drop down to select Customer Account# to default

  @EnableNewcustomerRegistration
  Scenario Outline: Test scenario for verifying functioning of "Enable new customer registration from login page" taggle button
    Given User is on Home Page for Admin setting to select Admin option for Admin reports
    And User should enter menu "<Main menu>" in search bar and select "<Sub menu>", for user and accounts
    Then User selects "<User Accounts>" in Orders page in admin login and validate user is in selected Tab
    And User enables new customer registration from login page toggle button, and save
    Then User logout from Admin page and click on Register here button, and verify check box
    And User again login as admin and enable taggle button again

    Examples:
      | Main menu           |  Sub menu| User Accounts |
      | Users & Accounts    | General  |   General     |
