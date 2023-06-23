Feature: Testing the Google Search Functionality Parameters
#general description
  Scenario: Happy Path(positive) Testing for Search Parameters
    #test case
    Given User navigates to the 'https://www.google.com/'
    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 links

  Scenario: Happy Path(positive) Testing Result for Search Parameters

    Given  User navigates to the 'https://www.google.com/'
    When User searches for special 'Kyrgyz Food in USA'
    Then User validates the result is less than three 300000000

  Scenario: Testing Loading Time Search for an item Parameters

    Given  User navigates to the 'https://www.google.com/'
    When USer Search for 'Turkish baklava'
    Then User validate it loads less than 1.0

