Feature: Add New Payee And Pay With Saved Payee
  User can add new payee information
  and pay bill using accounts of
  some saved payee

  Background:
    Given User navigates to the page and logins with credentials
      | username | password |

  Scenario Outline: Add New Payee
    When User navigates to the "Add New Payee" page
    And User types "<userName>" as user's name
    And User types "<userAddress>" as address
    And User types "<userAccount>" as account number
    And User types "<userDetails>" as details
    And User clicks on Add button
    Then "The new payee <userName> was successfully created." add payee message is shown;

    Examples:
      | userName  | userAddress        | userAccount | userDetails  |
      | Some User | 2323 N Michigan St | 2345532     | details here |

    Scenario: Pay With Saved Payee
      When User navigates to the "Pay Saved Payee" page
      And User types "100" as amount
      And User types "2000-12-01" as date
      And User types "cucumber example" as description
      And User clicks on Pay button
      Then "The payment was successfully submitted." payment result is shown;

