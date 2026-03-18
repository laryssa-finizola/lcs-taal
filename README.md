# 📊 Maior Subsequência Comum (LCS)

Este projeto foi desenvolvido em Java para analisar e comparar o desempenho de diferentes estratégias algorítmicas na resolução do problema clássico da **Maior Subsequência Comum (Longest Common Subsequence - LCS)**.

##  Objetivo
O foco principal é contrastar a abordagem de busca exaustiva (Backtracking) com métodos de otimização (Branch and Bound), avaliando como cada algoritmo se comporta diante do crescimento da entrada (explosão combinatória).

##  Métricas Analisadas
O motor de análise embutido no projeto recolhe e exibe em tempo real:
* **Complexidade Assintótica:** Tempo e espaço teóricos.
* **Tempo de Execução:** Medido em milissegundos (ms).
* **Uso de Memória:** Medido dinamicamente via JVM (KB/MB).
* **Estados Avaliados:** Contagem de nós visitados na árvore de recursão.
* **Mecanismo de Timeout:** Interrupção segura (*fail-fast*) configurada para 30 segundos, para evitar travamentos em complexidades exponenciais.

##  Estrutura do Projeto
O projeto foi construído utilizando o padrão de desenho *Strategy* para facilitar a injeção de novos algoritmos sem alterar o motor de testes.
* `lcs.strategy`: Contém a interface `LCSAlgorithm` e as implementações.
* `lcs.performance`: Classes responsáveis por rastrear o tempo limite e a contagem de nós.
* `lcs.model`: Classes de domínio, como o encapsulamento do resultado (`LCSResult`).
* `inputs/`: Ficheiros `.txt` padronizados contendo as strings de teste.

---

##  Pré-requisitos

Antes de iniciar, certifique-se de que tem as seguintes ferramentas instaladas no seu ambiente:
* **[Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)**: Versão 8 ou superior.
* **[Git](https://git-scm.com/)**: Para efetuar a clonagem do repositório.
* **IDE Java**: [Eclipse](https://www.eclipse.org/downloads/) ou [IntelliJ IDEA](https://www.jetbrains.com/idea/) (recomendado para gerir o Maven).

---

##  Como Executar

Este projeto foi estruturado utilizando o **Maven** para a gestão de dependências (JUnit 5). 

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/laryssa-finizola/lcs-taal.git](https://github.com/laryssa-finizola/lcs-taal.git)
   ```

2. **Importe o projeto na sua IDE:**
   * **No Eclipse:** Vá a `File > Import > Maven > Existing Maven Projects` e selecione a pasta clonada.
   * **No IntelliJ:** Vá a `File > Open` e selecione o ficheiro `pom.xml`.

3. **Execute o Benchmark (Consola):**
   * Navegue até ao ficheiro principal localizado em: `src/main/java/lcs/Main.java`.
   * Clique com o botão direito no ficheiro e selecione **Run As > Java Application**.
   * O menu interativo aparecerá na consola da IDE. Basta digitar a opção desejada (`1` para Backtracking, `2` para Branch and Bound ou `3` para Sair) e pressionar `Enter`.
  
###  Execução de Testes Unitários (JUnit)

Para validar a corretude semântica de ambos os algoritmos, o projeto conta com uma suíte de testes automatizados a cobrir casos base e cenários extremos.

1. **Navegue até à pasta de testes na sua IDE:** * Caminho: `src/test/java/lcs/strategy/`
   
2. **Localize os ficheiros de teste:**
   * Encontrará `LCSBacktrackingTest.java` e `LCSBranchAndBoundTest.java`.

3. **Execute os testes:**
   * Clique com o botão direito sobre qualquer um dos ficheiros (ou na pasta) e selecione **Run As > JUnit Test**.

---

## Formato de Entrada (Testes Personalizados)

Se o professor ou avaliador desejar submeter as suas próprias sequências de teste ao motor do sistema, o processo é muito simples:
1. Navegue até ao diretório `src/main/resources/inputs/`.
2. Crie um novo ficheiro `.txt` (ex: `meu_teste.txt`).
3. Na primeira linha do ficheiro, insira a **String X**.
4. Na segunda linha, insira a **String Y** (e guarde o ficheiro).
5. No ficheiro `Main.java`, adicione o caminho `"inputs/meu_teste.txt"` ao array `arquivos` e execute o programa novamente.
