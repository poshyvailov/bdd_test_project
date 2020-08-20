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
  Scenario Outline: Failed Login to Jira with wrong creds
    Given I navigate to Jira Login Page
    And I enter user name <login>
    And I enter password <pass>
    And I debug
    And I click on the login button
    And I debug
    Then I am on the Home Page

    Examples:
      | login      | pass   |
      | blablabla  | 123456 |
      | wronglogin | ****   |

#    @wip