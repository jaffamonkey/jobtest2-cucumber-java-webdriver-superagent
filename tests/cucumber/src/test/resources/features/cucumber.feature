Feature: Some scenarios

    Scenario: Test 1
        Given I open page "Homepage"
        And I close cookie overlay
        When I click "View All"
        Then a 100 results are displayed

    Scenario: Test 2
        Given I open page "Homepage"
        And I close cookie overlay
        And I add 5 random cryptocurrencies to the watchlist
        When I open page "Watchlist"
        Then 5 newly added cryptocurrencies are visible in the watchlist

    Scenario: Test 3
        Given I open page "Homepage"
        And I close cookie overlay
        And I click the list filter button
        When I select "30000000000" from filter "circulating supply"
        Then I should see list updated to 67 rows
        When I select "500000" from filter "volume"
        Then I should see list updated to 12 rows
        When I select "0.000054" from filter "price"
        Then I should see list updated to 11 rows
