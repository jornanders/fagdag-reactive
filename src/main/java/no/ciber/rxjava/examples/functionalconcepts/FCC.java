package no.ciber.rxjava.examples.functionalconcepts;

import java.util.Arrays;
import java.util.function.Function;

import static java.lang.System.out;

/**
 *
 */
public class FCC {

    public static Function<String, String> helloFunction = s -> ("Hello " + s);
    public static Function<String, String> byeFunction = s -> ("Bye " + s);

    public static void main(String[] args) {
        FCC fcc = new FCC();
        fcc.hello(helloFunction);
//        fcc.hello(byeFunction);
//        fcc.hello(s -> s.toUpperCase());
//
//        Arrays.asList("Per", "Ole", "Lisa").stream()
//                .map(helloFunction)
//                .forEach(fcc::printResult);
    }

    public void hello(Function<String, String> functionToApply) {
        Arrays.asList("Per", "Ole", "Lisa").stream()
                .map(functionToApply)
                .forEach(out::println);
    }

    public void printResult(String result) {
        out.println("** " + result);
    }
}
