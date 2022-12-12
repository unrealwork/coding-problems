package com.leetcode.string;

import com.leetcode.list.IntListConverter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PartitionLabelsTest {

    @ParameterizedTest
    @CsvSource( {
            "ababcbacadefegdehijhklij,'9,7,8'",
            "eccbbbbdec,'10'"
    })
    void testPartitionLabels(String s, @ConvertWith(IntListConverter.class) List<Integer> expected) {
        List<Integer> actual = PartitionLabels.partitionLabels(s);
        assertEquals(expected, actual);
    }
}
