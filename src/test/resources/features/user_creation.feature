@adminLogin
Feature: Admin User Creation

  As an Admin
  I want to create system users
  So that they can access the application

  @smoke @admin @usermanagement
  Scenario Outline: Create a new system user
    When the admin clicks Add User button
    And the admin selects user role "<userRole>"
    And the admin enters employee name "<employeeName>"
    And the admin selects status "<status>"
    And the admin enters a unique username
    And the admin enters password "<password>"
    And the admin confirms password "<password>"
    And the admin saves the user
    Then the user should be created successfully

    Examples:
      | userRole | employeeName | status  | password   |
      | ESS      | Orange Test  | Enabled | Test@12345 |

  @regression @admin @usermanagement @negative
  Scenario Outline: Create user with missing mandatory fields
    When the admin clicks Add User button
    And the admin leaves mandatory fields blank
    And the admin clicks Save button
    Then validation messages should be displayed

    Examples:
      | testCase |
      | Required |