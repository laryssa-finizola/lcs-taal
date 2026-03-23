package lcs.strategy;

import lcs.model.LCSResult;
import lcs.performance.PerformanceMetrics;

public class LCSDynamicProgramming implements LCSAlgorithm {

    private PerformanceMetrics metrics;

    public LCSDynamicProgramming() {
        this.metrics = new PerformanceMetrics(30000);
    }

    public PerformanceMetrics getMetrics() {
        return metrics;
    }

    @Override
    public LCSResult solve(String x, String y) {

        this.metrics = new PerformanceMetrics(30000); // reinicia métricas

        if (x == null || y == null) {
            return new LCSResult(0, "");
        }

        int m = x.length();
        int n = y.length();

        int[][] dp = new int[m + 1][n + 1];

        // Preenchimento da tabela
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                metrics.registrarNovoEstado();

                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstrução da LCS
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {

            metrics.registrarNovoEstado();

            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs.append(x.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return new LCSResult(lcs.length(), lcs.reverse().toString());
    }
}