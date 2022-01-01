package com.leetcode.array;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;

public class IntArrayConverter implements ArgumentConverter {
    @Override
    public Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        final String argString = (String) source;
        return Arrays.stream(argString.split(",\\s*"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
