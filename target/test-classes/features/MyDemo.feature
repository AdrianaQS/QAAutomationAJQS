Feature: Validar Funcionalidad Carrito

  @TestCarrito
  Scenario Outline: Agregar Productos al Carrito
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When selecciono el siguiente producto "<PRODUCTO>"
    And agrego <UNIDADES> del producto
    Then valido el carrito de compra actualice correctamente
    #Agregue un Example con otro producto "Sauce Labs Fleece Jacket" porque con un producto "Sauce Labs Bike Light " la app se cierra
    Examples:
      | PRODUCTO                  | UNIDADES |
      | Sauce Labs Backpack       | 1        |
      | Sauce Labs Bolt - T-Shirt | 1        |
      | Sauce Labs Fleece Jacket  | 3        |
      | Sauce Labs Bike Light     | 2        |



