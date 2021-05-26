@ApiTESTING
  Feature: Api testing with help of Cucumber


    Scenario: Add data to DB
      Given path to data is "username.json" and name is 'John'
      When user try to add data to db
      Then user must received '{"name": "John"}'


    Scenario: Get ID value
      Given path to data is "id.json"
      When user try to get id by path
      Then user receive number 2
      And response don't equal zero