@adminLogin
Feature: Admin User Search

  As an Admin
  I want to search system users
  So that I can quickly locate users in the application

  @smoke @admin @usermanagement
  Scenario: Search user by username
    When the admin searches user with username "Admin"
    Then the user "Admin" should be displayed in the search results

  @regression @admin @usermanagement
  Scenario: Search users by role
    When the admin searches users with role "Admin"
    Then users matching role "Admin" should be displayed

  @regression @admin @usermanagement
  Scenario: Search users by employee name
    When the admin searches users with employee name "G Singh"
    Then users matching employee name "G Singh" should be displayed

  @regression @admin @usermanagement
  Scenario: Search users by status
    When the admin searches users with status "Enabled"
    Then users matching status "Enabled" should be displayed

  @regression @admin @usermanagement
  Scenario: Reset search filters
    Given the admin enters search criteria
    When the admin clicks the reset button
    Then all search filters should be cleared