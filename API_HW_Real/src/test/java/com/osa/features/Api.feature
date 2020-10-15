Feature: Rest Api Testing

  Scenario: Common scenario
    Given I am authenticating the user
    When I send a "GET" call by using "api/users?id=2" I get the information for that user
    Then I verify the Response Code
      |status | HTTTPStatusCode | 200 |
    Then I verify if the information is correct or not
      |data.email | janet.weaver@reqres.in |
     
       
       
      