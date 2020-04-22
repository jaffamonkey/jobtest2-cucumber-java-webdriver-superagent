Feature: Transfer Funds Zero Bank
  This feature allows User
  To Transfer Funds using Zero App

  Background:
    Given User navigates to the page and logins with credentials
      | username | password |

  Scenario: Transfer Funds
    When User navigates to the "Transfer Funds" page
    And User randomly selects accounts
    And User sets "100" as amount
    And User sets "description" as description
    And User clicks submit
    Then User makes sure input data is correct
    And User clicks submit
    Then "You successfully submitted your transaction." result message is shown