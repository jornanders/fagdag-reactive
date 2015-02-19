package no.ciber.rxjava.examples.backpressure.util;

import rx.Observable;
import rx.Subscriber;

public class BurstyIntegerObservable extends BurstyObservableSupport<Integer> {

    public static Observable<Integer> create() {
        return (Observable<Integer>) new BurstyIntegerObservable().instantiate();
    }

    @Override
    protected void produceBurstyData(Subscriber<? super Integer> s) {
        for (int i = 0; i < Math.random() * 20; i++) {
            s.onNext(Integer.valueOf(i));
        }
    }
}
