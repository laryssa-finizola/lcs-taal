package lcs.model;

public class LCSResult {
    private final int length;
    private final String lcs;

    public LCSResult(int length, String lcs) {
        this.length = length;
        this.lcs = lcs;
    }

    public int getLength() {
        return length;
    }

    public String getLcs() {
        return lcs;
    }

    @Override
    public String toString() {
        return "Comprimento da LCS: " + length + "\nLCS: " + lcs;
    }
}