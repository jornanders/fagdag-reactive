package no.ciber.rxjava.examples.functionalconcepts;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *
 */
public class HigherOrder {

    public static void main(String[] args) {
        HigherOrder higherOrder = new HigherOrder();
        higherOrder.doBasicConversion();
        higherOrder.doExtendedConversion();
    }

    public void doBasicConversion() {
        Converter converter = new Converter();
        System.out.println("10 miles in km = " + converter.apply(1.609, 10.0));
        System.out.println("20 miles in km = " + converter.apply(1.609, 20.0));
        System.out.println("50 miles in km = " + converter.apply(1.609, 50.0));
    }

    public void doExtendedConversion() {
        Function<Double, Double> milesToKmConverter = new ConverterExtended().curry(1.609);
        System.out.println("10 miles in km = " + milesToKmConverter.apply(10.0));
        System.out.println("20 miles in km = " + milesToKmConverter.apply(20.0));
        System.out.println("50 miles in km = " + milesToKmConverter.apply(50.0));

        Function<Double, Double> ouncesToGramsConverter = new ConverterExtended().curry(28.345);

        Function<Double, Double> celsisusToFahrenheitConverter = new ConverterExtended().curry(9.0/5).andThen(n -> n + 32);
        System.out.println("10 celsius in fahrenheit: " + celsisusToFahrenheitConverter.apply(10.0));

        Function<Double, Double> fahrenheitToCelsiusConverter = new ConverterExtended().compose((Double n) -> n - 32).curry(5.0 / 9);
        System.out.println("50 fahrenheit in celsius: " + fahrenheitToCelsiusConverter.apply(50.0));
    }

    public class Converter implements BiFunction<Double, Double, Double> {

        @Override
        public Double apply(Double conversionRate, Double value) {
            return conversionRate * value;
        }
    }

    public interface ExtendedBiFunction<CONVERSIONRATE, VALUE, RESULT> extends BiFunction<CONVERSIONRATE, VALUE, RESULT> {
        default Function<VALUE, RESULT> curry(CONVERSIONRATE CONVERSIONRATE) {
            return u -> apply(CONVERSIONRATE, u);
        }

        default <V> ExtendedBiFunction<CONVERSIONRATE, V, RESULT> compose(Function<V, ? extends VALUE> before) {
            return (t, v) -> apply(t, before.apply(v));
        }
    }

    public class ConverterExtended implements ExtendedBiFunction<Double, Double, Double> {

        @Override
        public Double apply(Double conversionRate, Double value) {
            return conversionRate * value;
        }
    }
}
