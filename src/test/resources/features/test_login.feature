Feature: Login To Jira

  @Regression
  Scenario: Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - "poshyvailov"
    And I enter password - "poshyvailov"
    And I debug
    And I click on the login button
    Then I am on the Home Page

  @Regression
  Scenario: Failed Login to Jira
    Given I navigate to Jira Login Page
    And I enter user name - "webinar5"
    And I enter password - "wrongPassword"
    And I click on the login button
    And I debug
    Then I am on the Home Page

#    @wip