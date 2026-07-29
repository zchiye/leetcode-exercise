package io.zchiye.utils.test;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class OneInputTestCase<T, R> implements TestCase {

    List<OneInputTestCase.Params<T, R>> params;
    Function<T, String> input1Format;
    Function<T, R> function;
    Function<R, String> outputFormat;
    BiFunction<R, R, Boolean> equalizer;

    public static class Params<T, R> {
        T input1;
        R expect;

        public Params(T input1, R expect) {
            this.input1 = input1;
            this.expect = expect;
        }
    }

    public OneInputTestCase(List<OneInputTestCase.Params<T, R>> params, Function<T, R> function) {
        this.params = params;
        this.function = function;
    }

    public OneInputTestCase(List<OneInputTestCase.Params<T, R>> params, Function<T, R> function,
                            Function<T, String> input1Format,
                            Function<R, String> outputFormat, BiFunction<R, R, Boolean> equalizer) {
        this.params = params;
        this.function = function;
        this.input1Format = input1Format;
        this.outputFormat = outputFormat;
        this.equalizer = equalizer;
    }

    @Override
    public void test() {
        for (OneInputTestCase.Params<T, R> param : params) {
            System.out.println();
            String input1Str = input1Format != null ? input1Format.apply(param.input1) : param.input1.toString();
            System.out.println("input1 : " + input1Str);
            R result = function.apply(param.input1);
            String resultStr = outputFormat != null ? outputFormat.apply(result) : result.toString();
            System.out.println("result = " + resultStr);
            String expectStr = outputFormat != null ? outputFormat.apply(param.expect) : param.expect.toString();
            System.out.println("expect = " + expectStr);
            boolean pass = equalizer != null ? equalizer.apply(result, param.expect) : Objects.equals(result, param.expect);
            System.out.println("pass : " + pass);
            assert pass;
            System.out.println("-----------------------------------------------------------------------------------------");
        }
    }
}
