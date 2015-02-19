package no.ciber.rxjava.examples.backpressure.buffersandwindows;

import no.ciber.rxjava.examples.backpressure.util.BurstyIntegerObservable;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Buffer {
    //https://github.com/ReactiveX/RxJava/wiki/Backpressure#buffer

    public static void main(String[] args) {
        BurstyIntegerObservable.create()
                .buffer(1, TimeUnit.SECONDS)
                .toBlocking()
                .forEach(System.out::println);
    }
}
