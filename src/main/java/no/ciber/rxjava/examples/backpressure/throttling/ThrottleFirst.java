package no.ciber.rxjava.examples.backpressure.throttling;

import no.ciber.rxjava.examples.backpressure.util.BurstyIntegerObservable;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ThrottleFirst {
    //https://github.com/ReactiveX/RxJava/wiki/Backpressure#throttlefirst

    public static void main(String[] args) {
        BurstyIntegerObservable.create()
                .throttleFirst(1, TimeUnit.SECONDS)
                .toBlocking()
                .forEach(System.out::println);
    }
}
