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

  @ForeignLanguage
  Scenario: Check for display of details in foreign language
    Given User on login page
    Then User entered username and password
    Then Admin Page is displayed
    Then Click on user Icon
    Then User changes language to some other language option and validates language
    Then Click on user Icon
    And User resetting language back to
      |English (USA)|
    Then Click on user Icon
    And Click on Logout

  @Verify_Client_AdminLogin
  Scenario: Login as Admin once, Login as Client once and verify landing pages
    Given User on login page
    Then User entered username and password
    Then Admin Page is displayed
    Then Click on user Icon
    And Click on Logout
    Then user enters admin username and password
    And User should be navigated to Admin page
    Then Click on user Icon
    And Click on Logout


