Feature: Test requires by Napptilus

  Scenario: Test1-petición a las 10:00 del día 14 del producto 35455 para la brand 1
    Given url 'http://localhost:8080/product/2020-06-14T10:00/35455/1/'
    When method get
    Then status 200
    And match response == {"fromDateApplication":"2020-06-14T00:00:00","toDateApplication":"2020-12-31T23:59:59","productId":"35455","brandId":"1","priceProduct":"35.50","priceCurrency":"EUR"}

  Scenario: Test2-petición a las 16:00 del día 14 del producto 35455 para la brand 1
    Given url 'http://localhost:8080/product/2020-06-14T16:00/35455/1/'
    When method get
    Then status 200
    And match response == {"fromDateApplication":"2020-06-14T15:00:00","toDateApplication":"2020-06-14T18:30:00","productId":"35455","brandId":"1","priceProduct":"25.45","priceCurrency":"EUR"}

  Scenario: Test3-petición a las 21:00 del día 14 del producto 35455 para la brand 1
    Given url 'http://localhost:8080/product/2020-06-14T21:00/35455/1/'
    When method get
    Then status 200
    And match response == {"fromDateApplication":"2020-06-14T00:00:00","toDateApplication":"2020-12-31T23:59:59","productId":"35455","brandId":"1","priceProduct":"35.50","priceCurrency":"EUR"}

  Scenario: Test4-petición a las 10:00 del día 21 del producto 35455 para la brand 1
    Given url 'http://localhost:8080/product/2020-06-21T10:00/35455/1/'
    When method get
    Then status 200
    And match response == {"fromDateApplication":"2020-06-15T16:00:00","toDateApplication":"2020-12-31T23:59:59","productId":"35455","brandId":"1","priceProduct":"38.95","priceCurrency":"EUR"}

  Scenario: Test5-petición a las 21:00 del día 21 del producto 35455 para la brand 1
    Given url 'http://localhost:8080/product/2020-06-14T21:00/35455/1/'
    When method get
    Then status 200
    And match response == {"fromDateApplication":"2020-06-14T00:00:00","toDateApplication":"2020-12-31T23:59:59","productId":"35455","brandId":"1","priceProduct":"35.50","priceCurrency":"EUR"}
