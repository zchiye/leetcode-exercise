package io.zchiye.utils;

import java.util.Objects;
import java.util.function.Function;

public class TestCaseUtils {

    public static <T, R> void testCase(T input, Function<T, R> function, R expect) {
        testCase(input, function, expect, null);
    }

    public static <T, R> void testCase(T input, Function<T, R> function, R expect, Function<T, String> inputFormat) {
        if (inputFormat != null) {
            System.out.println(inputFormat.apply(input));
        } else {
            System.out.println(input);
        }
        R result = function.apply(input);
        System.out.println("result = " + result);
        System.out.println("pass : " + (Objects.equals(result, expect)));
    }

}
