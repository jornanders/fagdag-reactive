package no.ciber.rxjava.examples.backpressure.reactivepull;

import no.ciber.rxjava.examples.backpressure.util.BurstyIntegerObservable;
import no.ciber.rxjava.examples.backpressure.util.BurstyStringObservable;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ReactivePullBackpressure {
    //https://github.com/ReactiveX/RxJava/wiki/Backpressure#reactive-pull-backpressure-isnt-magic

    public static void main(String[] args) {
        Observable<String> observableA = BurstyStringObservable.create("A", 500);
        Observable<String> observableB = BurstyStringObservable.create("B", 1000);

        observableA.zipWith(observableB, (a, b) -> a + " - " + b).toBlocking().forEach(System.out::println);
    }
}
