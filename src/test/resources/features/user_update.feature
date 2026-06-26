@adminLogin
Feature: Admin User Update

  As an Admin
  I want to update system users
  So that user information remains accurate

  @regression @admin @usermanagement
  Scenario: Update user status
    Given a system user exists for update testing
    When the admin searches for the update test user
    And the admin edits the user status to "Disabled"
    And the admin saves the changes
    Then the user status should be updated to "Disabled"

  @regression @admin @usermanagement
  Scenario: Update user role
    Given a system user exists for update testing
    When the admin searches for the update test user
    And the admin changes the user role to "Admin"
    And the admin saves the changes
    Then the user role should be updated to "Admin"