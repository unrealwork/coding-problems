package com.leetcode.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GoalParserInterpretationTest {

    @ParameterizedTest
    @CsvSource( {
            "G()(al),Goal",
            "G()()()()(al),Gooooal",
            "(al)G(al)()()G,alGalooG"
    })
    void testInterpret(String s, String expected) {
        String actual = GoalParserInterpretation.interpret(s);
        Assertions.assertEquals(expected, actual);
    }
}
