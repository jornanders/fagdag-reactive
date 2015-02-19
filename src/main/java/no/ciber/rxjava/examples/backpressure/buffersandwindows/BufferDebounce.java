package no.ciber.rxjava.examples.backpressure.buffersandwindows;

import no.ciber.rxjava.examples.backpressure.util.BurstyIntegerObservable;
import rx.Observable;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class BufferDebounce {
    //https://github.com/ReactiveX/RxJava/wiki/Backpressure#buffer

    public static void main(String[] args) {
        Observable<? super Integer> burstyMulticast = BurstyIntegerObservable.create().publish().refCount();
        burstyMulticast
                .buffer(burstyMulticast
                        .debounce(200, TimeUnit.MILLISECONDS))
                .toBlocking()
                .forEach(System.out::println);
    }
}
