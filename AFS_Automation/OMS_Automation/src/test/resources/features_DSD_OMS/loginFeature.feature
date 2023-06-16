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
