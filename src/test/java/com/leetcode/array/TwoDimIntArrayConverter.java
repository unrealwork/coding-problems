package com.leetcode.array;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

public class TwoDimIntArrayConverter implements ArgumentConverter {
    private final IntArrayConverter intArrayConverter = new IntArrayConverter();

    @Override
    public final Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        final String argString = (String) source;
        if (argString.trim().isEmpty()) {
            return new int[][] {};
        }
        String[] split = argString.split("[|]\\s*");
        return Arrays.stream(split)
                .map(s -> (int[]) intArrayConverter.convert(s, context))
                .toArray(int[][]::new);
    }
}
