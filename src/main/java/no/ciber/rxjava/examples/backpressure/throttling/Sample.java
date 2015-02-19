package no.ciber.rxjava.examples.backpressure.throttling;

import no.ciber.rxjava.examples.backpressure.util.BurstyIntegerObservable;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Sample {
    //https://github.com/ReactiveX/RxJava/wiki/Backpressure#sample-or-throttlelast

    public static void main(String[] args) {
        BurstyIntegerObservable.create()
                .sample(1, TimeUnit.SECONDS) //aka throttleLast
                .toBlocking()
                .forEach(System.out::println);
    }
}
