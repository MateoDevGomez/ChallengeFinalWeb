@StoreTest
Feature: Realizar compra en la tienda
  @AddProds
  Scenario Outline: Compra de dos productos en la tienda
    Given el Cliente ingresa a la pagina web
    When agrega el primer producto "<PROD1>" al carrito
    And agrega el segundo producto "<PROD2>" al carrito
    And se dirige a visualizar el carrito de compras
    Then comprueba que el producto "<PROD1>" se haya agregado al carrito
    And comprueba que el producto "<PROD2>" se haya agregado al carrito
    When ingresa al formulario
    And ingresa al formulario el nombre "<NAME>", pais "<COUNTRY>", ciudad "<CITY>", tarjeta "<CARD>", mes "<MONTH>", anio "<YEAR>"
    Then verifica el mensaje "<MESSAGE>" que confirma la compra
    And finaliza la compra



  Examples:
    |        PROD1             |     PROD2          |     NAME       |  COUNTRY    |    CITY        |         CARD         |  MONTH  |  YEAR  |             MESSAGE                 |
    | Samsung galaxy s6        | Iphone 6 32gb    |  Mateo Gomez     | Ecuador    |    Quito       |      15072107        |   07    | 2024    |     Thank you for your purchase!   |