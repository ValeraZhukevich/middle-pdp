@cucumber
Feature: Login on spotify

  Scenario Outline: I can sign up in spotify

    Given I'm on signup spotify page
    When I type "<email>" in email input
    And And type "<confirmEmail>" in confirm email input
    And And type "<password>" in password input
    And And type "<nickname>" in nickname input
    And And type <day> in day of birthday
    And And choose "<month>" as a month of birthday
    And And type <year> in year of birthday
    And And choose "<gender>" as gender
    Then  everything will be ok

    Examples:
      | email             | confirmEmail      | password | nickname             | day | month   | year | gender |
      | forest@gamp.com   | forest@gamp.com   | password | forest               | 6   | June    | 1944 | Male   |
      | gendalf@gmail.com | gendalf@gmail.com | LOTR     | Gendalf Almost White | 19  | October | 1921 | Other  |