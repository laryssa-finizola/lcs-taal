package lcs.strategy;

import lcs.model.LCSResult;

public interface LCSAlgorithm {
    
    LCSResult solve(String x, String y);
    
}