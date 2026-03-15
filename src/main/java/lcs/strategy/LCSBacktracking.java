package lcs.strategy;

import lcs.model.LCSResult;
import lcs.performance.PerformanceMetrics; 

public class LCSBacktracking implements LCSAlgorithm {

    private PerformanceMetrics metrics;

    public LCSBacktracking() {
        this.metrics = new PerformanceMetrics(30000);
    }

    public PerformanceMetrics getMetrics() {
        return metrics;
    }

    @Override
    public LCSResult solve(String x, String y) {
        this.metrics = new PerformanceMetrics(30000); //30s
        
        if (x == null || y == null) {
            return new LCSResult(0, "");
        }
        
        String lcsEncontrada = findLCS(x, y, 0, 0);
        return new LCSResult(lcsEncontrada.length(), lcsEncontrada);
    }

    private String findLCS(String x, String y, int i, int j) {
        // registra o estado logo no início da recursão
        metrics.registrarNovoEstado(); 

        if (i == x.length() || j == y.length()) {
            return "";
        }

        if (x.charAt(i) == y.charAt(j)) {
            return x.charAt(i) + findLCS(x, y, i + 1, j + 1);
        }

        String caminhoA = findLCS(x, y, i + 1, j);
        String caminhoB = findLCS(x, y, i, j + 1);

        if (caminhoA.length() > caminhoB.length()) {
            return caminhoA;
        } else {
            return caminhoB;
        }
    }
}