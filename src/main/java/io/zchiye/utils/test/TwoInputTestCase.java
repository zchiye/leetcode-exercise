package io.zchiye.utils.test;

import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class TwoInputTestCase<T, U, R> implements TestCase {
    List<Params<T, U, R>> params;
    Function<T, String> input1Format;
    Function<U, String> input2Format;
    BiFunction<T, U, R> function;
    Function<R, String> outputFormat;
    BiFunction<R, R, Boolean> equalizer;

    public static class Params<T, U, R> {
        T input1;
        U input2;
        R expect;

        public Params(T input1, U input2, R expect) {
            this.input1 = input1;
            this.input2 = input2;
            this.expect = expect;
        }
    }

    public TwoInputTestCase(List<Params<T, U, R>> params, BiFunction<T, U, R> function) {
        this.params = params;
        this.function = function;
    }

    public TwoInputTestCase(List<Params<T, U, R>> params, BiFunction<T, U, R> function,
                            Function<T, String> input1Format, Function<U, String> input2Format,
                            Function<R, String> outputFormat, BiFunction<R, R, Boolean> equalizer) {
        this.params = params;
        this.function = function;
        this.input1Format = input1Format;
        this.input2Format = input2Format;
        this.outputFormat = outputFormat;
        this.equalizer = equalizer;
    }

    @Override
    public void test() {
        for  (Params<T, U, R> param : params) {
            System.out.println();
            String input1Str = input1Format != null ? input1Format.apply(param.input1) : param.input1.toString();
            String input2Str = input2Format != null ? input2Format.apply(param.input2) : param.input2.toString();
            System.out.println("input1 : " + input1Str);
            System.out.println("input2 : " + input2Str);
            R result = function.apply(param.input1, param.input2);
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
