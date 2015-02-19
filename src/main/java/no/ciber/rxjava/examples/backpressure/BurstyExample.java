package no.ciber.rxjava.examples.backpressure;

import no.ciber.rxjava.examples.backpressure.util.BurstyIntegerObservable;

/**
 *
 */
public class BurstyExample {

    public static void main(String[] args) {
        BurstyIntegerObservable.create()
                .toBlocking()
                .forEach(System.out::println);
    }
}
