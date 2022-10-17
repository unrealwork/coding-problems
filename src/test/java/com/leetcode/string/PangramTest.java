package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PangramTest {

    @ParameterizedTest
    @CsvSource( {
            "thequickbrownfoxjumpsoverthelazydog, true",
            "leetcode, false"
    })
    void checkIfPangram(String s, boolean expected) {
        final boolean isPangram = Pangram.checkIfPangram(s);
        Assertions.assertEquals(expected, isPangram);
    }
}
