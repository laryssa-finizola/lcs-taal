# 📊 Maior Subsequência Comum (LCS)

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

## 🛠️ Como Executar

1. Clone o repositório:
   ```bash
   git clone [https://github.com/laryssa-finizola/lcs-taal.git](https://github.com/laryssa-finizola/lcs-taal.git)
