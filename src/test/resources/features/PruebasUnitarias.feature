Feature: Consulta de inventario(Order)


  @CreacionOrder
  Scenario Outline: Crear_Order

    When creo una order con id,petId, quantity,shipDate,status,complete
    Then validar el codigo de respuesta
    And  mostrar descripcion

    Examples:

    |id  | petId | quantity | shipDate                         | status | complete  |
    |"0" | "300"  | "0"     |    "2024-08-07T03:45:39.860Z"    |"placed"|   "true"   |


  @ConsultaOrder
  Scenario Outline: Quiero onsultar una order
    Given la url "https://petstore.swagger.io/v2/store/order"
    When busco una orden por Id
    And valido codigo de respuesta
    Then imprimo mi respuesta
Examples:
    | Id  |
    | "5" |

