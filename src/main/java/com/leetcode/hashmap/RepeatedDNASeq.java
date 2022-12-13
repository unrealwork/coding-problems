package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RepeatedDNASeq {
    private static final int SEQ_LEN = 10;

    private static final int STRIP = (1 << (SEQ_LEN * 2)) - 1;
    private static final Map<Character, Integer> DNA = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);

    private RepeatedDNASeq() {
    }

    public static List<String> findRepeatedDnaSequences(String s) {
        int seqHash = 1;
        int i = 0;
        int j = 0;
        Map<Integer, Boolean> hashes = new HashMap<>();
        List<String> res = new ArrayList<>();
        while (j < s.length()) {
            seqHash = seqHash << 2;
            seqHash += DNA.get(s.charAt(j));
            boolean isFull = j - i + 1 == SEQ_LEN;
            if (isFull) {
                seqHash = (STRIP + 1) + (STRIP & seqHash);
                Boolean added = hashes.get(seqHash);
                if (added != null) {
                    if (!added) {
                        res.add(s.substring(i, j + 1));
                        hashes.put(seqHash, Boolean.TRUE);
                    }
                } else {
                    hashes.put(seqHash, Boolean.FALSE);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
