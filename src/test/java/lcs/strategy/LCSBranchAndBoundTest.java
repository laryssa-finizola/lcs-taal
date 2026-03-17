package lcs.strategy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lcs.model.LCSResult;

public class LCSBranchAndBoundTest {

    private final LCSAlgorithm algoritmo = new LCSBranchAndBound();

    @Test
    public void testCenarioDidatico() {
        LCSResult resultado = algoritmo.solve("ABC", "AC");
        
        assertNotNull(resultado, "O resultado não deveria ser nulo");
        assertEquals(2, resultado.getLength(), "O tamanho da LCS deve ser 2");
        assertEquals("AC", resultado.getLcs(), "A LCS deve ser 'AC'");
    }

    @Test
    public void testCenario1() {
        LCSResult resultado = algoritmo.solve("ABCBDAB", "BDCABA");
        
        assertNotNull(resultado, "O resultado não deveria ser nulo");
        assertEquals(4, resultado.getLength(), "O tamanho da LCS deve ser 4");
        
        String lcs = resultado.getLcs();

        assertTrue(
            lcs.equals("BCBA") || 
            lcs.equals("BDAB") || 
            lcs.equals("BCAB"),
            "A LCS deve ser uma das subsequências válidas ('BCBA', 'BDAB' ou 'BCAB')"
        );
    }

    @Test
    public void testCenario2() {
        LCSResult resultado = algoritmo.solve("AGGTAB", "GXTXAYB");
        
        assertNotNull(resultado, "O resultado não deveria ser nulo");
        assertEquals(4, resultado.getLength(), "O tamanho da LCS deve ser 4");
        assertEquals("GTAB", resultado.getLcs(), "A LCS deve ser 'GTAB'");
    }

    @Test
    public void testStringsTotalmenteDiferentes() {
        LCSResult resultado = algoritmo.solve("ABC", "DEF");
        
        assertNotNull(resultado);
        assertEquals(0, resultado.getLength(), "O tamanho deve ser 0 para strings sem intersecção");
        assertEquals("", resultado.getLcs(), "A string deve ser vazia");
    }

    @Test
    public void testStringsIdenticas() {
        LCSResult resultado = algoritmo.solve("COMPUTACAO", "COMPUTACAO");
        
        assertNotNull(resultado);
        assertEquals(10, resultado.getLength());
        assertEquals("COMPUTACAO", resultado.getLcs());
    }

    @Test
    public void testUmaStringVazia() {
        LCSResult resultado = algoritmo.solve("ALGORITMO", "");
        
        assertNotNull(resultado);
        assertEquals(0, resultado.getLength());
        assertEquals("", resultado.getLcs());
    }

    @Test
    public void testEntradasNulas() {
        LCSResult resultado1 = algoritmo.solve(null, "TEXTO");
        LCSResult resultado2 = algoritmo.solve("TEXTO", null);
        
        assertNotNull(resultado1);
        assertEquals(0, resultado1.getLength());
        
        assertNotNull(resultado2);
        assertEquals(0, resultado2.getLength());
    }
}
