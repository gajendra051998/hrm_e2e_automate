Feature: OrangeHRM Login and Logout

  Background:
    Given the user is on the OrangeHRM login page

  @smoke @login @admin
  Scenario Outline: Login with valid user credentials
    When the user enters username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should be redirected to the dashboard
    And the dashboard should be visible

    Examples:
      | username | password |
      | Admin    | admin123 |
      | essuser  | essuser123 |
      | GSingh   | gSingh123  |


  @regression @negative @login
  Scenario Outline: Login with invalid credentials
    When the user enters username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should see login error message "<errorMessage>"

    Examples:
      | username  | password  | errorMessage        |
      | wrongUser | admin123  | Invalid credentials |
      | Admin     | wrongPass | Invalid credentials |
      | wrongUser | wrongPass | Invalid credentials |


  @regression @negative @login
  Scenario Outline: Login with blank required fields
    When the user enters username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should see required field validation message

    Examples:
      | username | password |
      |          | admin123 |
      | Admin    |          |
      |          |          |

  @smoke @logout
  Scenario Outline: Logout from OrangeHRM application
    When the user enters username "<username>" and password "<password>"
    And the user clicks on the login button
    Then the user should be redirected to the dashboard
    When the user logs out from the application
    Then the user should be redirected to the login page

    Examples:
      | username | password |
      | Admin    | admin123 |
      | essuser  | essuser123 |
      | GSingh   | gSingh123  |
