Feature: Gestion Pedidos PetStore

  @crearVariosPedidos
  Scenario Outline: Crear Pedidos

    When envio la solicitud para crear el pedido con id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete "<complete>"
    Then el código de respuesta es 200
    And los datos del response deben ser iguales a id <id>, petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete "<complete>"
    Examples:
      | id | petId | quantity | shipDate                   | status  | complete |
      | 25 | 10    | 10       | 2024-08-26T01:12:25.780Z   | placed  | true     |
      | 21 | 11    | 20       | 2024-08-26T01:12:25.780Z   | placed  | false     |


  @ConsultarPedidos
  Scenario Outline: Consultar Pedidos

    Given valido  que el usuario tiene un id <id> de un pedio que existe
    When consulto el id <id> del pedido
    Then el código de respuesta es 200
    And valido que el id <id> consultado sea igual al del response
    Examples:
      |id|
      |25|
      |21|
