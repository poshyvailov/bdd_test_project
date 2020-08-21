Feature: Create Issue

  @Background:
  Scenario Outline: Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name <login>
    And I enter password <pass>
    And I click on the login button
    Then I am on the Home Page

    Examples:
      | login       | pass        |
      | poshyvailov | poshyvailov |


  @Regression
  Scenario: Create new issue in Jira
    And I will wait when my ticket will be opened
    Then I check is Create Ticket button is active
    And I am waiting when main page will be fully loaded
    And I click on the Create Issue button
    And Create ticket window is open
    Then I will clear project name field
    And I fill project name - "Webinar (WEBINAR)"
    And I press Tab
    And I clear issue field
    And I select issue type in the issue field - "Task"
    And I press Tab to go to the next field
    Then I will check if Description field is active
    Then I will type summary of the ticket - "Some New Ticket For Test"
    Then I click on the Save button
    And I am waiting for success message
    And I check is success message contains Webinar ticket type
