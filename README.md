# 📊 Sequência Comum Mais Longa (LCS)

Este projeto é desenvolvido em Java para analisar e comparar o desempenho de diferentes estratégias algorítmicas na resolução do problema clássico da **Maior Subsequência Comum (Longest Common Subsequence - LCS)**.

## Objetivo
O foco principal é contrastar a abordagem de busca exaustiva com métodos de otimização, avaliando como cada algoritmo se comporta diante do crescimento da entrada, dita como explosão combinatória.

## Métricas Analisadas
O motor de análise embutido no projeto coleta e exibe em tempo real:
* **Complexidade Assintótica:** Tempo e espaço teóricos.
* **Tempo de Execução:** Medido em milissegundos (ms).
* **Uso de Memória:** Medido dinamicamente via JVM (KB/MB).
* **Estados Avaliados:** Contagem de nós visitados na árvore de recursão.
* **Mecanismo de Timeout:** Interrupção segura (fail-fast) configurada para 30 segundos para evitar travamentos em complexidades exponenciais, exibindo o status de falha de escalabilidade.

## Estrutura do Projeto
O projeto foi construído utilizando padrões de projeto (como o *Strategy*) para facilitar a injeção de novos algoritmos sem alterar o motor de testes.

* `lcs.strategy`: Contém a interface `LCSAlgorithm` e as implementações (Backtracking, etc.).
* `lcs.performance`: Classes responsáveis por rastrear tempo limite e contagem de nós.
* `lcs.model`: Classes de domínio, como o encapsulamento do `LCSResult`.
* `inputs/`: Arquivos `.txt` padronizados contendo as strings de teste (10, 20 e 50 caracteres).

##  Pré-requisitos

Antes de iniciar, certifique-se de que tem as seguintes ferramentas instaladas no seu ambiente:
* **[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)**: Versão 8 ou superior (o projeto está compatível com as versões recentes do Java SE).
* **[Git](https://git-scm.com/)**: Para efetuar a clonagem do repositório.
* **IDE Java**: [Eclipse](https://www.eclipse.org/downloads/) ou [IntelliJ IDEA](https://www.jetbrains.com/idea/) (recomendado para facilitar a importação automática das dependências do Maven).

##  Como Executar

Este projeto foi estruturado utilizando o **Maven** para gerenciamento de dependências (JUnit 5). O projeto pode ser executado do seguinte modo:

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/laryssa-finizola/lcs-taal.git](https://github.com/laryssa-finizola/lcs-taal.git)
   ```

2. **Importe o projeto na sua IDE:**
   * **No Eclipse:** Vá em `File > Import > Maven > Existing Maven Projects` e selecione a pasta clonada.
   * **No IntelliJ:** Vá em `File > Open` e selecione o arquivo `pom.xml`.

3. **Execute o Benchmark (Console):**
   * Navegue até o arquivo principal localizado em: `src/main/java/lcs/Main.java`.
   * Clique com o botão direito no arquivo e selecione **Run As > Java Application**.
   * O menu interativo aparecerá no console da IDE. Basta digitar a opção desejada (`1` para Backtracking, `2` para Branch and Bound ou `3` para Sair) e pressionar `Enter`.
  
###  Execução de Testes Unitários (JUnit)

Para validar a corretude semântica de ambos os algoritmos, o projeto conta com uma suíte de testes automatizados tratando casos base, variações de entrada e cenários extremos.

1. **Navegue até a pasta de testes na sua IDE:** * Caminho: `src/test/java/lcs/strategy/`
   
2. **Localize os arquivos de teste:**
   * Você encontrará os arquivos `LCSBacktrackingTest.java` e `LCSBranchAndBoundTest.java`.

3. **Execute os testes:**
   * Clique com o botão direito sobre qualquer um dos arquivos (ou sobre a pasta inteira para rodar todos de uma vez).
   * Selecione **Run As > JUnit Test**.
   * A aba do JUnit se abrirá na IDE mostrando a barra verde, indicando que todas as asserções e regras de negócio passaram com sucesso.
