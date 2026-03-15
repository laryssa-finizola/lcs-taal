package lcs.performance;

public class PerformanceMetrics {

    private long estadosAvaliados = 0; 
    private long tempoInicio;
    private long tempoLimiteMs;

    public PerformanceMetrics(long tempoLimiteMs) {
        this.tempoInicio = System.currentTimeMillis();
        this.tempoLimiteMs = tempoLimiteMs;
    }

    public void registrarNovoEstado() { 
        this.estadosAvaliados++;
        
        if (this.estadosAvaliados % 10000 == 0) {
            if (System.currentTimeMillis() - tempoInicio > tempoLimiteMs) {
                // Lança uma exceção para interromper violentamente a recursão caso exceder o tempo
                throw new RuntimeException("TIMEOUT"); 
            }
        }
    }

    public long getEstadosAvaliados() {
        return estadosAvaliados;
    }
}