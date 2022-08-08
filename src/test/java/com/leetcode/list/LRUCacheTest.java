package com.leetcode.list;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


class LRUCacheTest {

    private static Stream<Arguments> testData() {
        return Stream.of(
                arguments(2,
                        asList("put", "put", "get", "put", "get", "put", "get", "get", "get"),
                        new int[][] {
                                {1, 1}, {2, 2}, {1}, {3, 3}, {2}, {4, 4}, {1}, {3}, {4}
                        },
                        asList(null, null, 1, null, -1, null, -1, 3, 4)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testLruCache(int cacheSize, List<String> commands, int[][] params, List<Integer> expected) {
        LRUCache cache = new LRUCache(cacheSize);
        int i = 0;
        List<Integer> actual = new ArrayList<>(commands.size());
        for (String command : commands) {
            int[] commandParams = params[i];
            if ("put".equals(command)) {
                cache.put(commandParams[0], commandParams[1]);
                actual.add(null);
            } else {
                actual.add(cache.get(commandParams[0]));
            }
            i++;
        }
        assertEquals(expected, actual);
    }
}
