package no.ciber.rxjava.examples.backpressure.throttling;

import no.ciber.rxjava.examples.backpressure.util.BurstyIntegerObservable;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Debounce {
    //https://github.com/ReactiveX/RxJava/wiki/Backpressure#debounce-or-throttlewithtimeout

    public static void main(String[] args) {
        BurstyIntegerObservable.create()
                .debounce(1, TimeUnit.SECONDS   ) //throttleWithTimeout
                .toBlocking()
                .forEach(System.out::println);
    }
}
