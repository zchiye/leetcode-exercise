package io.zchiye.utils;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TestCaseUtils {

    public static <T, R> void testCase(T input, Function<T, R> function, R expect) {
        testCase(input, function, expect, null, null);
    }

    public static <T, R> void testCase(T input, Function<T, R> function, R expect, Function<T, String> inputFormat) {
        testCase(input, function, expect, inputFormat, null);
    }

    public static <T, R> void testCaseEq(T input, Function<T, R> function, R expect, BiFunction<R, R, Boolean> equalizer) {
        testCase(input, function, expect, null, equalizer);
    }

    public static <T, R> void testCase(T input, Function<T, R> function, R expect, Function<T, String> inputFormat, BiFunction<R, R, Boolean> equalizer) {
        System.out.println();
        String inputStr = inputFormat != null ? inputFormat.apply(input) : input.toString();
        System.out.println("input : " + inputStr);
        R result = function.apply(input);
        System.out.println("result = " + result);
        System.out.println("expect = " + expect);
        boolean pass = equalizer != null ? equalizer.apply(result, expect) : Objects.equals(result, expect);
        System.out.println("pass : " + pass);
        assert pass;
        System.out.println("-----------------------------------------------------------------------------------------");
    }

    public static <T, S, R> void testCaseTwo(T input1, S input2, BiFunction<T, S, R> function, R expect) {
        testCaseTwo(input1, input2, function, expect, null, null, null);
    }

    public static <T, S, R> void testCaseTwo(T input1, S input2, BiFunction<T, S, R> function, R expect,
                                             Function<T, String> inputFormat1, Function<S, String> inputFormat2) {
        testCaseTwo(input1, input2, function, expect, inputFormat1, inputFormat2, null);
    }

    public static <T, S, R> void testCaseTwo(T input1, S input2, BiFunction<T, S, R> function, R expect,
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
        boolean pass = (Objects.equals(result, expect));
        System.out.println("pass : " + pass);
        assert pass;
        System.out.println("-----------------------------------------------------------------------------------------");
    }


    public static <T, S> void testCaseVoid(T input1, S input2, BiConsumer<T, S> function, T expect) {
        testCaseVoid(input1, input2, function, expect, null, null, null);
    }

    public static <T, S> void testCaseVoid(T input1, S input2, BiConsumer<T, S> function, T expect,
                                           Function<T, String> inputFormat1, Function<S, String> inputFormat2, BiFunction<T, T, Boolean> equalizer) {
        System.out.println();
        String input1Str = inputFormat1 != null ? inputFormat1.apply(input1) : input1.toString();
        String input2Str = inputFormat2 != null ? inputFormat2.apply(input2) : input2.toString();
        System.out.println("input1 : " + input1Str);
        System.out.println("input2 : " + input2Str);
//        R result = function.apply(input1, input2);
        function.accept(input1, input2);
        String resultStr = inputFormat1 != null ? inputFormat1.apply(input1) : input1.toString();
        System.out.println("result = " + resultStr);
        String expectStr = inputFormat1 != null ? inputFormat1.apply(expect) : expect.toString();
        System.out.println("expect = " + expectStr);
        boolean pass = equalizer != null ? equalizer.apply(input1, expect) : (Objects.equals(input1, expect));
        System.out.println("pass : " + pass);
        assert pass;
        System.out.println("-----------------------------------------------------------------------------------------");
    }


}
