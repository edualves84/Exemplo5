Feature: Consulta



  Scenario Outline:  Consulta relogio
    Given que acesso o site da magalu
    When  vou na caixa de pesquisa e digito <relogio>
    And   clico na lupa
    Then  retorna uma lista de resultados para <relogio>
    When  clico no modelo <relogio>
    Then  confirmo o modelo do relogio como <relogio> com o valor de <preco>

    Examples:
      | relogio                                                                            | preco      |
      | "Relógio Smart Watch Feminino Oled P70 + Duas Pulseiras Rose - Smart X relógios"   | "150,99"   |


