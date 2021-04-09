# Author: Vuong Phan
# Date: 2021/04/07
# Description: Regarding to the Automation test section, Write the script to create the new project

Feature: Projects functionality

  Background:
    Given User is on the login page
    When he logins as ad admin
      | userName | password   |
      | tester   | Tester@123 |
    Then he should be on my dashboard

    @Create
  Scenario:
    Given User is on the Projects page
    When he clicks on Add New button
    And enters the value to some fields as following
      | projectNo | projectName | serialNo |
      | Auto_2021 | AutoTest    | 123456   |
    And clicks on Save button
    Then he sees a confirmation message
    And sees the new record in the list
      | projectNo | projectName | serialNo |
      | Auto_2021 | AutoTest    | 123456   |