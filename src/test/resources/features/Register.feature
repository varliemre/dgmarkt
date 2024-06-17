Feature: As a user, I should be able to register on the website.

  @wip
  Scenario Outline: Positive Register Test
    Given The user is on the Home page
    When The user navigates to the Register page
    And The user register with "<First Name>" und "<Last Name>" und "<E-Mail>" "<Telephone>" und "<Password>" und "<Password Confirm>"
    Then User should see a registration confirmation message
    Examples:
      | First Name | Last Name | E-Mail               | Telephone   | Password   | Password Confirm |
      | admin9     | last      | adminlast9@gmail.com | 01798659885 | admin98765 | admin98765       |


