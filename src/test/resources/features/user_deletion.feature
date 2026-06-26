@adminLogin
Feature: Admin User Deletion

  As an Admin
  I want to delete system users
  So that obsolete users are removed

  @regression @admin @usermanagement
  Scenario: Delete an existing user
    Given a system user exists for deletion testing
    When the admin searches for the deletion test user
    And the admin deletes the user
    And the admin confirms the deletion
    Then the user should be removed successfully

  @regression @admin @usermanagement
  Scenario: Cancel user deletion
    Given a system user exists for deletion testing
    When the admin searches for the deletion test user
    And the admin deletes the user
    But the admin cancels the deletion
    Then the user should remain available in the system