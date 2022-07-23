package com.leetcode.list;

import com.leetcode.array.IntArrayConverter;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IntListConverter implements ArgumentConverter {
    private final ArgumentConverter insArrayConverter;

    public IntListConverter() {
        insArrayConverter = new IntArrayConverter();
    }

    @Override
    public final Object convert(Object source, ParameterContext context) throws ArgumentConversionException {
        int[] arr = (int[]) insArrayConverter.convert(source, context);
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }
}
