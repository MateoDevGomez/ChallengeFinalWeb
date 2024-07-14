@StoreTest
Feature: Realizar compra en la tienda
  @AddProds
  Scenario Outline: Agregar dos productos al carrito
    Given el Cliente ingresa a la pagina web
    When agrega el primer producto "<PROD1>" al carrito
    And agregar el segundo producto "<PROD2>" llamado
    And se dirige a visualizar el carrito de compras
    Then compruebo que el producto "<PROD1>" se haya agregado al carrito
    And compruebo que el producto "<PROD2>" se haya agregado al carrito
    When ingresa al formulario
    And ingresa al formulario el nombre "<NAME>", pais "<COUNTRY>", ciudad "<CITY>", tarjeta "<CARD>", mes "<MONTH>", anio "<YEAR>"
    Then Finalizo Compra



  Examples:
    |        PROD1             |     PROD2          |     NAME       |  COUNTRY    |    CITY        |         CARD         |  MONTH  |  YEAR  |
    | Samsung galaxy s6      | Iphone 6 32gb    |  Mateo Gomez     | Ecuador    |    Quito       |      15072107        |   07    | 2024   |