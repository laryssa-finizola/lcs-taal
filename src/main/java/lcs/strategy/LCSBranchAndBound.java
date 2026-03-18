package lcs.strategy;

import lcs.model.LCSResult;
import lcs.performance.PerformanceMetrics;

public class LCSBranchAndBound  implements LCSAlgorithm{
	//implementacao do branch and bound
	//explora apenas ramos promissores, que podem melhorar a solucao

	private PerformanceMetrics metrics;

    private String bestLCS;

    public LCSBranchAndBound() {
        this.metrics = new PerformanceMetrics(30000);
    }

    public PerformanceMetrics getMetrics() {
        return metrics;
    }

    @Override
    public LCSResult solve(String x, String y) {

        this.metrics = new PerformanceMetrics(30000); //reinicia metricas
        bestLCS = ""; //iniciar com a melhor solucao (no momento sem subsequencia)

        if (x == null || y == null) {
            return new LCSResult(0, ""); //string nula = 0
        }

        branchAndBound(x, y, 0, 0, "");

        return new LCSResult(bestLCS.length(), bestLCS);
    }

    private void branchAndBound(String x, String y, int i, int j, String current) { //arvore de busca

        metrics.registrarNovoEstado(); //um estado da arvore de busca

        if (i == x.length() || j == y.length()) {

            if (current.length() > bestLCS.length()) { //se a solucao for melhor, atualiza
                bestLCS = current;
            }

            return;
        }

        int limiteSuperior = current.length() + Math.min(x.length() - i, y.length() - j); //tamanho max que o ramo pode alcançar

        //poda da arvorve:
        if (limiteSuperior <= bestLCS.length()) {
            return;
        }

        if (x.charAt(i) == y.charAt(j)) {

            branchAndBound( x,y,i + 1, j + 1, current + x.charAt(i));

        } else {

            branchAndBound( x, y,i + 1, j, current);

            branchAndBound(x,y, i,j + 1,current);
        }
    }
}
