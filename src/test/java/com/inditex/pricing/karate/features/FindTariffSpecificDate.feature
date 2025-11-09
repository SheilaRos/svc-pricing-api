Feature: Find brand product tariff for a specific date

  Background:
    * url 'http://localhost:8082/pricing'
    * header Authorization = 'Basic YWRtaW46YWRtaW4xMjM='

  Scenario Outline: Send request successfully '<description>'
    Given path 'prices'
    And param brandId = <brandId>
    And param productId = <productId>
    And param date = '<date>'
    When method GET
    Then status 200
    * match response == <response>

    Examples:
      | description | brandId | productId | date                | response                                                                                                                                |
      | Test 1      | 1       | 35455     | 2020-06-14T10:00:00 | {"id":1,"brandId":1,"productId":35455,"price":35.50,"currency":"EUR","startDate":"2020-06-14T00:00:00","endDate":"2020-12-31T23:59:59"} |
      | Test 2      | 1       | 35455     | 2020-06-14T16:00:00 | {"id":2,"brandId":1,"productId":35455,"price":25.45,"currency":"EUR","startDate":"2020-06-14T15:00:00","endDate":"2020-06-14T18:30:00"} |
      | Test 3      | 1       | 35455     | 2020-06-14T21:00:00 | {"id":1,"brandId":1,"productId":35455,"price":35.50,"currency":"EUR","startDate":"2020-06-14T00:00:00","endDate":"2020-12-31T23:59:59"} |
      | Test 4      | 1       | 35455     | 2020-06-15T10:00:00 | {"id":3,"brandId":1,"productId":35455,"price":30.50,"currency":"EUR","startDate":"2020-06-15T10:00:00","endDate":"2020-06-15T11:00:00"} |
      | Test 5      | 1       | 35455     | 2020-06-16T21:00:00 | {"id":4,"brandId":1,"productId":35455,"price":38.95,"currency":"EUR","startDate":"2020-06-15T16:00:00","endDate":"2020-12-31T23:59:59"} |


  Scenario: Tariff not found
    Given path 'prices'
    And param brandId = 2
    And param productId = 35455
    And param date = '2020-06-14T00:00:00'
    When method GET
    Then status 404
    * match response.status == 'error'
    * match response.message == 'Tariff not found.'

  Scenario Outline: Invalid request: <description>
    Given path 'prices'
    And param brandId = <brandId>
    And param productId = <productId>
    And param date = <date>
    When method GET
    Then status 400

    Examples:
      | description        | brandId | productId | date                  |
      | missing brand id   | null    | 35455     | '2020-06-14T10:00:00' |
      | missing product id | 1       | null      | '2020-06-14T10:00:00' |
      | missing date id    | 1       | 35455     | null                  |



