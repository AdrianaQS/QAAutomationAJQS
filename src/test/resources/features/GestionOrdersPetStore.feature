Feature: Gestion Pedidos PetStore

  @crearVariosPedidos
  Scenario Outline: Creación de Order
    When se realiza la creación del pedido con los datos <id>, <petId>, <quantity>, "<shipDate>", "<status>"
    Then el código de respuesta es 200
    And los datos del response deben ser iguales a id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>"
    Examples:
      | id | petId | quantity | shipDate                   | status  |
      | 25 | 10    | 10       | 2024-08-26T01:12:25.780+0000  | placed  |
      | 21 | 11    | 20       | 2024-08-26T01:12:25.780+0000   | placed  |

  @ConsultarPedidos
  Scenario Outline: Consultar Pedidos

    Given valido  que el usuario tiene un id <id> de un pedido que existe
    When consulto el id <id> del pedido
    Then el código de respuesta es 200
    And valido que el id <id> consultado sea igual al del response
    Examples:
      |id|
      |25|
      |21|


