package lcs;

import lcs.model.LCSResult;
import lcs.reader.LCSReader;
import lcs.strategy.LCSAlgorithm;
import lcs.strategy.LCSBacktracking;
import lcs.strategy.LCSBranchAndBound;
import lcs.strategy.LCSDynamicProgramming;
import lcs.strategy.LCSGreedy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        String[] arquivos = {
            "inputs/lcs_10_chars.txt",
            "inputs/lcs_20_chars.txt",
            "inputs/lcs_50_chars.txt"
        };

        while (opcao != 5) {
            System.out.println("\n=== COMPARATIVO LCS ===");
            System.out.println("1. Executar Backtracking");
            System.out.println("2. Executar Branch and Bound");
            System.out.println("3. Executar Programação Dinâmica");
            System.out.println("4. Executar Guloso");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();

            if (opcao == 1) {
                executarAnalise(new LCSBacktracking(), arquivos, "Backtracking");

            } else if (opcao == 2) {
                executarAnalise(new LCSBranchAndBound(), arquivos, "Branch and Bound");

            } else if (opcao == 3) {
                executarAnalise(new LCSDynamicProgramming(), arquivos, "Programação Dinâmica");
            } 
            else if (opcao == 4) {
                executarAnalise(new LCSGreedy(), arquivos, "Guloso");
            }
            else if (opcao != 5) {
                System.out.println("\nOpção inválida! Tente novamente.");
            }
        }
        
        scanner.close();
        System.out.println("Programa encerrado.");
    }

    private static void executarAnalise(LCSAlgorithm algoritmo, String[] arquivos, String nomeAlgoritmo) {
        System.out.println("\n==================================================");
        System.out.println("INICIANDO ANÁLISE COM: " + nomeAlgoritmo.toUpperCase());
        System.out.println("==================================================");
        
        for (String arquivo : arquivos) {
            long tempoInicio = System.currentTimeMillis();
            Runtime runtime = Runtime.getRuntime();
            
            runtime.gc(); 
            long memoriaAntes = runtime.totalMemory() - runtime.freeMemory();

            try {
                String[] strings = LCSReader.read(arquivo);
                String stringX = strings[0];
                String stringY = strings[1];

                System.out.println(">> Testando arquivo: " + arquivo);
                
                tempoInicio = System.currentTimeMillis(); 
                
                LCSResult resultado = algoritmo.solve(stringX, stringY);
                
                long tempoFim = System.currentTimeMillis();
                long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
                
                long tempoTotalMs = tempoFim - tempoInicio;
                long memoriaUsadaBytes = memoriaDepois - memoriaAntes;
                
                if (memoriaUsadaBytes < 0) memoriaUsadaBytes = 0; 

                System.out.println(resultado.toString());
                System.out.println("Tempo de Execução: " + tempoTotalMs + " ms");
                System.out.println("Uso de Memória: " + (memoriaUsadaBytes / 1024) + " KB (" + (memoriaUsadaBytes / (1024 * 1024)) + " MB)");
                
                if (algoritmo instanceof LCSBacktracking) {
                    System.out.println("Estados Avaliados: " + ((LCSBacktracking) algoritmo).getMetrics().getEstadosAvaliados());

                } else if (algoritmo instanceof LCSBranchAndBound) {
                    System.out.println("Estados Avaliados: " + ((LCSBranchAndBound) algoritmo).getMetrics().getEstadosAvaliados());

                } else if (algoritmo instanceof LCSDynamicProgramming) {
                    System.out.println("Estados Avaliados: " + ((LCSDynamicProgramming) algoritmo).getMetrics().getEstadosAvaliados());
                }
                
                System.out.println("--------------------------------------------------");
                
            } catch (RuntimeException e) {
                if ("TIMEOUT".equals(e.getMessage())) {
                    long tempoFim = System.currentTimeMillis();
                    long memoriaDepois = runtime.totalMemory() - runtime.freeMemory();
                    long tempoTotalMs = tempoFim - tempoInicio;
                    long memoriaUsadaBytes = Math.max(0, memoriaDepois - memoriaAntes);

                    System.out.println("Execução abortada: Tempo limite excedido.");
                    System.out.println("Tempo de Execução no Corte: " + tempoTotalMs + " ms");
                    System.out.println("Uso de Memória no Corte: " + (memoriaUsadaBytes / 1024) + " KB (" + (memoriaUsadaBytes / (1024 * 1024)) + " MB)");
                    
                    if (algoritmo instanceof LCSBacktracking) {
                        System.out.println("Escalabilidade falhou após avaliar: " + ((LCSBacktracking) algoritmo).getMetrics().getEstadosAvaliados() + " estados.");

                    } else if (algoritmo instanceof LCSBranchAndBound) {
                        System.out.println("Escalabilidade falhou após avaliar: " + ((LCSBranchAndBound) algoritmo).getMetrics().getEstadosAvaliados() + " estados.");

                    } else if (algoritmo instanceof LCSDynamicProgramming) {
                        System.out.println("Escalabilidade falhou após avaliar: " + ((LCSDynamicProgramming) algoritmo).getMetrics().getEstadosAvaliados() + " estados.");
                    }
                    else if (algoritmo instanceof LCSGreedy) {
                        System.out.println("Estados Avaliados: " + ((LCSGreedy) algoritmo).getMetrics().getEstadosAvaliados());
                    }

                    System.out.println("--------------------------------------------------");
                } else {
                    System.err.println("Erro de execução: " + e.getMessage());
                }
            } catch (Exception e) {
                System.err.println("Erro ao processar o arquivo " + arquivo + ": " + e.getMessage());
            }
        }
    }
}