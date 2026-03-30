package lcs.strategy;

import lcs.model.LCSResult;
import lcs.performance.PerformanceMetrics;

public class LCSGreedy implements LCSAlgorithm {

    private PerformanceMetrics metrics;

    public LCSGreedy() {
        this.metrics = new PerformanceMetrics(30000);
    }

    public PerformanceMetrics getMetrics() {
        return metrics;
    }

    @Override
    public LCSResult solve(String x, String y) {

        this.metrics = new PerformanceMetrics(30000);

        if (x == null || y == null) {
            return new LCSResult(0, "");
        }

        StringBuilder lcs = new StringBuilder();
        int j = 0; 

        for (int i = 0; i < x.length(); i++) {
            
            int buscaJ = j; 
            
            while (buscaJ < y.length()) {
                metrics.registrarNovoEstado();

                if (x.charAt(i) == y.charAt(buscaJ)) {
                    lcs.append(x.charAt(i));
                    j = buscaJ + 1; 
                    break;
                }
                buscaJ++; 
            }
        }

        return new LCSResult(lcs.length(), lcs.toString());
    }
}