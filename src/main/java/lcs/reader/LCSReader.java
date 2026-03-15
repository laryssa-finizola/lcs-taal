package lcs.reader;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Classe responsável por ler os arquivos de entrada do LCS.
 * O arquivo deve conter exatamente duas linhas de texto:
 * Linha 1: String X
 * Linha 2: String Y
 */
public class LCSReader {

    // Lê o arquivo especificado e retorna um array de Strings contendo X e Y.

    public static String[] read(String path) throws Exception {
        
        // Busca o arquivo dentro da pasta src/main/resources
        InputStream input = LCSReader.class.getClassLoader().getResourceAsStream(path);
        
        if (input == null) {
            throw new IllegalArgumentException("Arquivo não encontrado no caminho: " + path);
        }

        //leitura do arquivo
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        // Lê a primeira linha (X) e a segunda linha (Y)
        String stringX = reader.readLine();
        String stringY = reader.readLine();

        reader.close();

        // Retorna as duas strings embutidas em um array
        return new String[]{stringX, stringY};
    }
}