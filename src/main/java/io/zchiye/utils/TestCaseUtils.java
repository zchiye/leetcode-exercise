package io.zchiye.utils;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestCaseUtils {

    public static <T, R> void testCase(T input, Function<T, R> function, R expect) {
        testCase(input, function, expect, null);
    }

    public static <T, R> void testCase(T input, Function<T, R> function, R expect, Function<T, String> inputFormat) {
        System.out.println();
        String inputStr = inputFormat != null ? inputFormat.apply(input) : input.toString();
        System.out.println("input : " + inputStr);
        R result = function.apply(input);
        System.out.println("result = " + result);
        System.out.println("expect = " + expect);
        System.out.println("pass : " + (Objects.equals(result, expect)));
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static <T, S, R> void testCase(T input1, S input2, BiFunction<T, S, R> function, R expect) {
        testCase(input1, input2, function, expect, null, null, null);
    }

    public static <T, S, R> void testCase(T input1, S input2, BiFunction<T, S, R> function, R expect,
                                          Function<T, String> inputFormat1, Function<S, String> inputFormat2) {
        testCase(input1, input2, function, expect, inputFormat1, inputFormat2, null);
    }

    public static <T, S, R> void testCase(T input1, S input2, BiFunction<T, S, R> function, R expect,
                                          Function<T, String> inputFormat1, Function<S, String> inputFormat2, Function<R, String> resultFormat) {
        System.out.println();
        String input1Str = inputFormat1 != null ? inputFormat1.apply(input1) : input1.toString();
        String input2Str = inputFormat2 != null ? inputFormat2.apply(input2) : input2.toString();
        System.out.println("input1 : " + input1Str);
        System.out.println("input2 : " + input2Str);
        R result = function.apply(input1, input2);
        String resultStr = resultFormat != null ? resultFormat.apply(result) : result.toString();
        System.out.println("result = " + resultStr);
        String expectStr = resultFormat != null ? resultFormat.apply(expect) : expect.toString();
        System.out.println("expect = " + expectStr);
        System.out.println("pass : " + (Objects.equals(result, expect)));
        System.out.println("-----------------------------------------------------------------------------------------");
    }

}
