Feature: Testing the Google Search Functionality Parameters
#general description
  Scenario: Happy Path(positive) Testing for Login
    #test case

    When User searches for  fields 'guest1@microworks.com', 'Guest1!',
    Then User validates title of the 'ORDER DETAILS - Weborder'

  Scenario: Negative (wrong password) Testing for Login
    #test case

    When User searches for  fields inCorrectPassword 'guest1@microworks.com', 'Gf',
    Then User validates for error 'Sign in Failed'

  Scenario: Negative (wrong login) Testing for Login
    #test case
    When User searches for  fields inCorrectLogin 'walsf@gmail.com', 'Guest1',
    Then User validates for password error 'Sign in Failed'

  Scenario: Happy Path(positive) Testing for Login and main page
    #test case

    Given User Login to page,
    When User enter '356' , 'value','I LOVE SELENIUM' ,'email@gmail.com','email2@gmail.com',
    Then  User validate '3137 Laguna',
    And   validate following words 'View Group Order','Your group order is now pending'
