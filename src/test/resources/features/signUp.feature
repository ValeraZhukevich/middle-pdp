@cucumber
Feature: Login on spotify

  Scenario Outline: I can login in spotify

    Given I'm on spotify page
    When I transient on sign up page
    And And fill email field as "<email>"
    And And fill confirm email field as "<confirmEmail>"
    And And fill password field as as "<password>"
    And And fill display field as "<displayName>"
    And And fill day field as <day>
    And And fill month field as "<month>"
    And And fill year field as <year>
    And And fill gender as "<gender>"
    Then  everything will be ok

    Examples:
      | email            | confirmEmail     | password    | displayName     | day | month | year | gender |
      | bruce@mail.uk    | bruce@mail.uk    | password123 | BruCe The Might | 21  | April | 1993 | Male   |
      | nataly@gmail.com | nataly@gmail.com | qwerty      | Nata            | 07  | March | 1997 | Female |